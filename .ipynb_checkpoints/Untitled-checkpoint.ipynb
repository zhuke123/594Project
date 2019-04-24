{
 "cells": [
  {
   "cell_type": "code",
   "execution_count": 2,
   "metadata": {},
   "outputs": [],
   "source": [
    "\n",
    "                "
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 1,
   "metadata": {},
   "outputs": [],
   "source": [
    "import csv\n",
    "a = {}\n",
    "for i in range(ord(\"A\"), ord(\"Z\")+1):\n",
    "    filename = chr(i) + \".csv\"\n",
    "    with open(filename, 'r',encoding=\"utf8\", errors='ignore') as csvDataFile:\n",
    "        Reader = csv.reader(csvDataFile)\n",
    "        for row in Reader:\n",
    "            if len(row) > 0:\n",
    "                words = row[0].split(\" \")\n",
    "                word = words[0].lower()\n",
    "                definition = \" \".join(words[1:])\n",
    "                a[word] = definition\n",
    "\n",
    "import re\n",
    "\n",
    "f2 = open(\"para.txt\", \"r+\")\n",
    "line = f2.readline()\n",
    "passage = 1\n",
    "d = {}\n",
    "while line:\n",
    "    if (\"Passage \" + str(passage)) in line:\n",
    "        passage += 1\n",
    "        continue\n",
    "    words = re.split('[^a-zA-Z]', line)\n",
    "    for word in words:\n",
    "        word = word.lower()\n",
    "        if word and (word in a):\n",
    "            if word not in d:\n",
    "                d[word] = [{passage}, 1, a[word]]\n",
    "            else:\n",
    "                d[word][0].add(passage)\n",
    "                d[word][1] += 1\n",
    "            \n",
    "    line = f2.readline()\n",
    "\n",
    "f = open(\"Dictionary\", \"w+\")\n",
    "for key in d:\n",
    "    f.write(key + \"\\n\")\n",
    "    f.write(d[key][2] + \"\\n\")\n",
    "    f.write(str(d[key][1]) + \"\\n\")\n",
    "    p = list(d[key][0])\n",
    "    for t in p:\n",
    "            f.write(str(t) + \" \")\n",
    "    f.write(\"\\n\")\n",
    "f.close()"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "metadata": {},
   "outputs": [],
   "source": []
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "metadata": {},
   "outputs": [],
   "source": []
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "metadata": {},
   "outputs": [],
   "source": []
  }
 ],
 "metadata": {
  "kernelspec": {
   "display_name": "Python 3",
   "language": "python",
   "name": "python3"
  },
  "language_info": {
   "codemirror_mode": {
    "name": "ipython",
    "version": 3
   },
   "file_extension": ".py",
   "mimetype": "text/x-python",
   "name": "python",
   "nbconvert_exporter": "python",
   "pygments_lexer": "ipython3",
   "version": "3.7.0"
  }
 },
 "nbformat": 4,
 "nbformat_minor": 2
}
