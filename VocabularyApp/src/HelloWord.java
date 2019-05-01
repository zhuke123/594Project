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
import java.awt.Canvas;

public class HelloWord {
	private JPanel panelMenu;
	private JPanel panelFC;
	private JPanel panelBOW;
	private JPanel panelLogin;
	private JFrame frame;
	private JTextField txtUsername;
	private String username;
	private JLabel greetingLabel = new JLabel();
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
	private JTextArea textArea_1;
	
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
		frame.setBounds(100, 100, 900, 600);
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
		txtUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtUsername.setBounds(400, 192, 130, 26);
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
		greetingLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		greetingLabel.setBounds(62, 53, 241, 60);
		panelMenu.add(greetingLabel);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username = txtUsername.getText();
				String cap = username.substring(0, 1).toUpperCase() + username.substring(1);
				greetingLabel.setText("Hello, " + cap +"!");	
				panelLogin.setVisible(false);
				panelFC.setVisible(false);
				panelMenu.setVisible(true);
				panelBOW.setVisible(false);
				pro.addUsers(username);
				lblRanking.setText("ranking: " + (pro.getRank()).getRank(username) + "\n word count: " + pro.getUser(username).getWordCount());

			}
		});
		btnNewButton.setBounds(538, 192, 76, 29);
		panelLogin.add(btnNewButton);
		
		
		JLabel lblNewLabel_1 = new JLabel("Type in your username");
		lblNewLabel_1.setBounds(335, 70, 481, 60);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		panelLogin.add(lblNewLabel_1);
		
	
		
		JLabel lblNewLabel = new JLabel("What do you want to play?");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblNewLabel.setBounds(231, 87, 550, 199);
		panelMenu.add(lblNewLabel);
		
		wordLabel = new JLabel();
		wordLabel.setText("word");
		wordLabel.setBackground(Color.ORANGE);
		wordLabel.setForeground(Color.ORANGE);
		wordLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		wordLabel.setBounds(427, 64, 264, 59);
		panelFC.add(wordLabel);
		

		
		JButton btnFlashcard = new JButton("FlashCard");  
		btnFlashcard.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
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
		btnFlashcard.setBounds(294, 338, 160, 53);
		panelMenu.add(btnFlashcard);
	
		//bag of words
		JButton btnBagOfWords = new JButton("Bag of Words");
		btnBagOfWords.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnBagOfWords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFC.setVisible(false);
				panelMenu.setVisible(false);
				panelBOW.setVisible(true);
				panelLogin.setVisible(false);
				dic.handleRequest(pro.getUser(username).getBagOfWords());
					
			}
		});
		btnBagOfWords.setBounds(583, 338, 160, 53);
		panelMenu.add(btnBagOfWords);
		
		txtSize = new JTextField();
		txtSize.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		txtSize.setText("size");
		txtSize.setBounds(325, 62, 205, 29);
		panelBOW.add(txtSize);
		txtSize.setColumns(10);
		

		
		
		JButton btnGo = new JButton("go");
		btnGo.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnGo.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				bagSize = Integer.parseInt(txtSize.getText());
				if(bagSize>5) {
					JOptionPane.showMessageDialog(null, "Bag Size should be smaller than 6", 
				            "warning", JOptionPane.CLOSED_OPTION);
				}
				wordSet =  pro.getUser(username).getBagOfWords().getBag(bagSize);
				str = "";
				for(IWord word: wordSet) {
					str += word.getWord()+'\n';
				}
				textArea_1.setText(str);
			}
		});
		btnGo.setBounds(536, 63, 64, 29);
		panelBOW.add(btnGo);
		
		textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		textArea_1.setBounds(235, 112, 505, 173);
		panelBOW.add(textArea_1);
		
		
		//home page
				JButton btnHome = new JButton("Home");
				btnHome.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
				btnHome.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panelFC.setVisible(false);
						panelMenu.setVisible(true);
						panelBOW.setVisible(false);
						panelLogin.setVisible(false);
					}
				});
				
				btnHome.setBounds(408, 312, 81, 29);
				panelBOW.add(btnHome);
				
			
				
		JButton btnNewButton_1 = new JButton("Log out");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(true);
				panelFC.setVisible(false);
				panelMenu.setVisible(false);
				panelBOW.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(447, 403, 137, 53);
		panelMenu.add(btnNewButton_1);
		

		
		JButton button = new JButton("Home");
		button.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		button.setBounds(522, 435, 86, 29);
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
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textArea.setBounds(320, 148, 545, 213);
		panelFC.add(textArea);
		
		
		
	
		// if known, pop the word, and pop next one
		JButton btnKnown = new JButton("known");
		btnKnown.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnKnown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(word.isFirst()) {
				pro.getUser(username).setWordCount(pro.getUser(username).getWordCount()+1);
			}
			else {
				word.updateFeedback(1);
				word.updateTime();
				pro.getUser(username).getFlashCard().insert(word);
			}
				//current word
				word = (Word) pro.getUser(username).getFlashCard().getFlashCard();
				wordLabel.setText(word.getWord());
				textArea.setText(word.getDefinition());							
				lblRanking.setText("ranking: " + (pro.getRank()).getRank(username) + "\n word count: " + pro.getUser(username).getWordCount() );
			}
		});
		btnKnown.setBounds(442, 396, 86, 29);
		panelFC.add(btnKnown);
		
		// if unknown, update the value and insert
		JButton btnUnknown = new JButton("unknown");
		btnUnknown.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnUnknown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//last word
				word.updateFeedback(0);		
				word.updateTime();
				pro.getUser(username).getFlashCard().insert(word);
				
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
				lblRanking.setText("ranking: " + (pro.getRank()).getRank(username) + "\n word count: " + pro.getUser(username).getWordCount() );
			}
		});
		btnUnknown.setBounds(582, 396, 152, 29);
		panelFC.add(btnUnknown);
		
		JLabel lblTheDefinitionIs = new JLabel("The definition is:");
		lblTheDefinitionIs.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTheDefinitionIs.setBounds(149, 137, 194, 65);
		panelFC.add(lblTheDefinitionIs);
		
		lblRanking = new JLabel("ranking");
		lblRanking.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblRanking.setBounds(20, 6, 314, 119);
		panelFC.add(lblRanking);
		lblRanking.setText("ranking: 0");



	}
}
