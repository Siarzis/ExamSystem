import java.awt.*;
import javax.swing.*;  

public class DeskApp {
	
	DeskApp() {
		JFrame frame = new JFrame("Desktop Application"); //creating instance of JFrame
		JButton button = new JButton("Click"); //creating instance of JButton
		JLabel label1 = new JLabel("Welcome to our Test"); //creating instance of JLabel
		JTextArea IntroText = new JTextArea("Welcome to the self-quiz on Psychology and Science. Introductory psychology textbooks often begin with a chapter which reviews the history of the field and different scientific approaches to psychology. Yours may not be titled \"Psychology and Science,\" but it will probably cover some of the same material. Read the question and click on an answer. You will jump to a correction or (if the answer is correct) a confirmation. No total score is provided for this quiz because it is meant to be browsed; you can scan the responses to wrong answers as well as right answers. If you run into problems or have a question, read the introductory paragraphs on theself-quiz index page.");
		//BoxLayout FrameBoxLayout = new BoxLayout(frame, BoxLayout.Y_AXIS);
		
		// button properties
		button.setBounds(130,100,100,40); //x axis, y axis, width, height
		
		// properties of a multiple-lines text
		IntroText.setBounds(10,30,300,300); //x axis, y axis, width, height
		IntroText.setLineWrap(true); // a pair of commands to show text line by line
		IntroText.setWrapStyleWord(true);
		Color defaultFrameColor = frame.getBackground(); // match area's background color
		IntroText.setBackground(defaultFrameColor); // with frame's background color
		
		frame.add(button, BorderLayout.SOUTH); //adding button in JFrame
		frame.add(label1,BorderLayout.NORTH); //adding 'welcome' message in JFrame
		frame.add(IntroText,BorderLayout.CENTER);
		
		frame.setSize(400,500); //400 width and 500 height
		frame.setLayout(new FlowLayout()); //using no layout managers  
		frame.setVisible(true); //making the frame visible
	}
	
	public static void main(String[] args) {
		new DeskApp();
	}
}
