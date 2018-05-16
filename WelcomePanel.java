import java.awt.*;
import java.awt.event.*;  
import javax.swing.*;  

public class WelcomePanel implements ActionListener{
	
	JLabel label1;
	JPanel cardPanel, loginPanel;
	CardLayout cardLayout;
	
	WelcomePanel() {
		JFrame frame = new JFrame("Desktop Application"); //creating instance of JFrame
		JButton introButton = new JButton("Start"); //creating instance of JButton
		cardLayout = new CardLayout(); 
		cardPanel = new JPanel(cardLayout);
		JPanel introPanel = new JPanel();
		JPanel firstQuestion = new JPanel();
		loginPanel = new LoginForm();
		label1 = new JLabel("Welcome to our Test"); //creating instance of JLabel
		JLabel label2 = new JLabel("This is the first Question");
		JTextArea introText = new JTextArea("Welcome to the self-quiz on Psychology and Science. Introductory psychology textbooks often begin with a chapter which reviews the history of the field and different scientific approaches to psychology. Yours may not be titled \"Psychology and Science,\" but it will probably cover some of the same material. Read the question and click on an answer. You will jump to a correction or (if the answer is correct) a confirmation. No total score is provided for this quiz because it is meant to be browsed; you can scan the responses to wrong answers as well as right answers. If you run into problems or have a question, read the introductory paragraphs on theself-quiz index page.");
		
		// introduction panel properties
		introPanel.setBackground(new Color(255, 0, 0));
		
		// introduction page button properties
		introButton.setBounds(130,100,100,40); //x axis, y axis, width, height
		introButton.addActionListener(this); // on clicking the button me make an action
		introButton.setBackground(new Color(59, 89, 182));
		introButton.setForeground(Color.WHITE);
		introButton.setFocusPainted(false);
		introButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		// introduction text area properties
		introText.setBounds(10,30,300,300); //x axis, y axis, width, height
		introText.setLineWrap(true); // a pair of commands to show text line by line
		introText.setWrapStyleWord(true);
		Color defaultFrameColor = frame.getBackground(); // match area's background color
		introText.setBackground(defaultFrameColor); // with frame's background color
		introText.setEditable(false); // text areas are editable by default
		
		introPanel.add(introButton); //adding button in JFrame
		introPanel.add(label1); //adding 'welcome' message in JFrame
		introPanel.add(introText);
		introPanel.setLayout(new BoxLayout(introPanel, BoxLayout.Y_AXIS));  
		
		firstQuestion.add(label2);
		
		cardPanel.add(introPanel, "Intro");
	    cardPanel.add(loginPanel, "Login");
		
		frame.setSize(400,500); //400 width and 500 height
		frame.setLayout(new FlowLayout()); //using no layout managers
		frame.add(cardPanel);
		frame.setVisible(true); //making the frame visible
	}
	
	public void actionPerformed(ActionEvent e) {
		//label1.setText("New Welcome Message");
		cardLayout.next(cardPanel);
	}
	
	public static void main(String[] args) {
		new WelcomePanel();
	}
}