import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Font;

public class HelloWord {
	private JPanel panelMenu;
	private JPanel panelFC;
	private JPanel panelBOW;
	private JPanel panelLogin;
	private JFrame frame;
	private JLabel lblMessage;
	private JTextField txtUsername;
	private String username;
	private JLabel greetingLabel = new JLabel();
	private JLabel test = new JLabel();
	private static Program pro = new Program("Dictionary.txt");
	private static IDictionary dic;
	private JTextArea textArea;
	private JLabel wordLabel;
	private Word word;
	private JTextField txtSize;
	private Set<IWord> wordSet;
	private int bagSize;
	private String str;
	private JLabel lblRanking;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		dic = pro.getDict();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloWord window = new HelloWord();				
					window.frame.setVisible(true);		
					
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
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		panelMenu = new JPanel();
		frame.getContentPane().add(panelMenu, "name_49647960823438");
		panelMenu.setLayout(null);
		panelMenu.setVisible(false);
		
		panelBOW = new JPanel();
		frame.getContentPane().add(panelBOW, "name_50915847383607");
		panelBOW.setLayout(null);
		panelBOW.setVisible(false);
		
	    panelLogin = new JPanel();
		frame.getContentPane().add(panelLogin, "name_51769814100289");
		panelLogin.setVisible(true);
		panelLogin.setLayout(null);
		
		
		panelFC = new JPanel();
		frame.getContentPane().add(panelFC, "name_49529805569344");
		panelFC.setVisible(false);
		
		
	
		txtUsername = new JTextField();
		txtUsername.setBounds(96, 98, 130, 26);
		panelLogin.add(txtUsername);
		txtUsername.setText("username");
		txtUsername.setColumns(10);
		//get username from user
		txtUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username = txtUsername.getText();
				greetingLabel.setText(username);	
			}
		});	
		greetingLabel.setBounds(62, 53, 171, 18);
		panelMenu.add(greetingLabel);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username = txtUsername.getText();
				greetingLabel.setText("Hello " +username);	
				panelLogin.setVisible(false);
				panelFC.setVisible(false);
				panelMenu.setVisible(true);
				panelBOW.setVisible(false);
				pro.addUsers(username);
				lblRanking.setText("ranking: " + (pro.getRank()).getRank(username));
			}
		});
		btnNewButton.setBounds(238, 98, 76, 29);
		panelLogin.add(btnNewButton);
		
		
		JLabel lblNewLabel_1 = new JLabel("Type in your username");
		lblNewLabel_1.setBounds(68, 26, 312, 60);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		panelLogin.add(lblNewLabel_1);
		
	
		
		JLabel lblNewLabel = new JLabel("What do you want to play?");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		lblNewLabel.setBounds(62, 36, 360, 103);
		panelMenu.add(lblNewLabel);
		
		wordLabel = new JLabel();
		wordLabel.setBounds(194, 62, 154, 16);
		panelFC.add(wordLabel);
		

		
		JButton btnFlashcard = new JButton("FlashCard");  
		btnFlashcard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFC.setVisible(true);
				panelMenu.setVisible(false);
				panelBOW.setVisible(false);
				panelLogin.setVisible(false);
				dic.handleRequest(pro.getUser(username).getFlashCard());
				//pop the first word of user's list
				word = (Word) pro.getUser(username).getFlashCard().getFlashCard();
				wordLabel.setText(word.getWord());			
				textArea.setText(word.getDefinition());
				
			}
		});
		btnFlashcard.setBounds(65, 171, 117, 29);
		panelMenu.add(btnFlashcard);
	
		//bag of words
		JButton btnBagOfWords = new JButton("Bag of Words");
		btnBagOfWords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFC.setVisible(false);
				panelMenu.setVisible(false);
				panelBOW.setVisible(true);
				panelLogin.setVisible(false);
				dic.handleRequest(pro.getUser(username).getBagOfWords());
				wordSet =  pro.getUser(username).getBagOfWords().getBag(bagSize);	
			}
		});
		btnBagOfWords.setBounds(221, 171, 117, 29);
		panelMenu.add(btnBagOfWords);
		
		txtSize = new JTextField();
		txtSize.setText("size");
		txtSize.setBounds(153, 63, 130, 26);
		panelBOW.add(txtSize);
		txtSize.setColumns(10);
		

		
		
		JButton btnGo = new JButton("go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bagSize = Integer.parseInt(txtSize.getText());
				System.out.println(bagSize);
				str = "";
				for(IWord word: wordSet) {
					str += word.getWord();
				}
				System.out.println(str);
			}
		});
		btnGo.setBounds(280, 63, 64, 29);
		panelBOW.add(btnGo);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(125, 103, 223, 76);
		panelBOW.add(textArea_1);
		textArea_1.setText(str);
		
		//home page
				JButton btnHome = new JButton("Home");
				btnHome.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panelFC.setVisible(false);
						panelMenu.setVisible(true);
						panelBOW.setVisible(false);
						panelLogin.setVisible(false);
					}
				});
				
				btnHome.setBounds(175, 213, 81, 29);
				panelBOW.add(btnHome);
				
			
				
		JButton btnNewButton_1 = new JButton("Log out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(true);
				panelFC.setVisible(false);
				panelMenu.setVisible(false);
				panelBOW.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(142, 212, 117, 29);
		panelMenu.add(btnNewButton_1);
		

		
		JButton button = new JButton("Home");
		button.setBounds(174, 216, 81, 29);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFC.setVisible(false);
				panelMenu.setVisible(true);
				panelBOW.setVisible(false);
				panelLogin.setVisible(false);
				
			}
		});
		panelFC.setLayout(null);
		panelFC.add(button);

		
		textArea = new JTextArea();
		textArea.setBounds(137, 110, 287, 68);
		panelFC.add(textArea);
		
		
		
	
		// if known, pop the word, and pop next one
		JButton btnKnown = new JButton("known");
		btnKnown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//last word
				System.out.println(word.getWeight() + "known: " + word.getWord());
				
				//current word
				word = (Word) pro.getUser(username).getFlashCard().getFlashCard();
				wordLabel.setText(word.getWord());
				textArea.setText(word.getDefinition());	
			
				pro.getUser(username).setWordCount(pro.getUser(username).getWordCount()+1);
				lblRanking.setText("ranking: " + (pro.getRank()).getRank(username) + " word count: " + pro.getUser(username).getWordCount() );
			}
		});
		btnKnown.setBounds(102, 187, 86, 29);
		panelFC.add(btnKnown);
		
		// if unknown, update the value and insert
		JButton btnUnknown = new JButton("unknown");
		btnUnknown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//last word
				word.updateFeedback(0);		
				word.updateTime();
				pro.getUser(username).getFlashCard().insert(word);
				System.out.println(word.getWeight() + "unknown: " + word.getWord());
				
				//current word
				List<IWord> pops = new LinkedList<>(); 
				while(true) {
					word = (Word) pro.getUser(username).getFlashCard().getFlashCard();
					if(word.getTime() == -1 || System.currentTimeMillis() - word.getTime() >= 5000)
						break;
					pops.add(word);
				}
				//push back
				for(IWord word : pops) pro.getUser(username).getFlashCard().insert(word);
				wordLabel.setText(word.getWord());
				textArea.setText(word.getDefinition());
				lblRanking.setText("ranking: " + (pro.getRank()).getRank(username) + " word count: " + pro.getUser(username).getWordCount() );
			}
		});
		btnUnknown.setBounds(233, 187, 102, 29);
		panelFC.add(btnUnknown);
		
		JLabel lblTheDefinitionIs = new JLabel("The definition is:");
		lblTheDefinitionIs.setBounds(18, 110, 107, 16);
		panelFC.add(lblTheDefinitionIs);
		
		lblMessage = new JLabel("Flashcard");
		lblMessage.setBounds(188, 6, 81, 44);
		panelFC.add(lblMessage);
		lblMessage.setForeground(UIManager.getColor("Button.light"));
		lblMessage.setBackground(UIManager.getColor("Button.light"));
		
		lblRanking = new JLabel("ranking");
		lblRanking.setBounds(18, 62, 168, 36);
		panelFC.add(lblRanking);
		
		


	}
}
