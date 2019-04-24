import csv
a = {}
for i in range(ord("A"), ord("Z")+1):
    filename = chr(i) + ".csv"
    with open(filename, 'r',encoding="utf8", errors='ignore') as csvDataFile:
        Reader = csv.reader(csvDataFile)
        for row in Reader:
            if len(row) > 0:
                words = row[0].split(" ")
                word = words[0].lower()
                definition = " ".join(words[1:])
                a[word] = definition

import re

f2 = open("para.txt", "r+")
line = f2.readline()
passage = 1
d = {}
while line:
    if ("Passage " + str(passage)) in line:
        passage += 1
        continue
    words = re.split('[^a-zA-Z]', line)
    for word in words:
        word = word.lower()
        if word and (word in a):
            if word not in d:
                d[word] = [{passage}, 1, a[word]]
            else:
                d[word][0].add(passage)
                d[word][1] += 1
            
    line = f2.readline()

f = open("Dictionary", "w+")
for key in d:
    f.write(key + "\n")
    f.write(d[key][2] + "\n")
    f.write(str(d[key][1]) + "\n")
    p = list(d[key][0])
    for t in p:
            f.write(str(t) + " ")
    f.write("\n")
f.close()