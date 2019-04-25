import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class HelloWord {

	private JFrame frame;
	private JLabel lblMessage;
	private JTextField txtWord;
	private static FlashCard  fs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					HelloWord window = new HelloWord();
					window.frame.setVisible(true);
					ArrayList<IWord>  wordList = new ArrayList<IWord>();
					Word word = new Word("happy","joyful",3);
					Word word1 = new Word("sad","unhappy",4);
					fs = new FlashCard();
					wordList.add(word1);
					wordList.add(word);
					fs.createDataStructure(wordList);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HelloWord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(182, 121, 1, 16);
		frame.getContentPane().add(textArea);
		
		txtWord = new JTextField();
		txtWord.setHorizontalAlignment(SwingConstants.CENTER);
		txtWord.setText("word");
		txtWord.setBounds(140, 72, 156, 26);
		frame.getContentPane().add(txtWord);
		txtWord.setColumns(10);
		
		JButton btnKnown = new JButton("known");
		btnKnown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Word word = (Word) fs.getFlashCard();
				txtWord.setText(word.getWord());
				lblMessage.setText(word.getDefinition());
			}
		});
		btnKnown.setBounds(75, 170, 108, 29);
		frame.getContentPane().add(btnKnown);
		
		JButton btnUnknown = new JButton("unknown");
		btnUnknown.setBounds(240, 170, 102, 29);
		frame.getContentPane().add(btnUnknown);
		
		JLabel lblTheDefinitionIs = new JLabel("The definition is:");
		lblTheDefinitionIs.setBounds(53, 111, 117, 37);
		frame.getContentPane().add(lblTheDefinitionIs);
		
		lblMessage = new JLabel("Flashcard");
		lblMessage.setBounds(195, 100, 224, 58);
		frame.getContentPane().add(lblMessage);
		lblMessage.setForeground(UIManager.getColor("Button.light"));
		lblMessage.setBackground(UIManager.getColor("Button.light"));
	}
}
