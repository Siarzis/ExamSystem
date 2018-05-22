import java.awt.*;
import java.awt.event.*;  
import javax.swing.*;

public class LoginForm extends JPanel implements ActionListener{
	
	private JTextField usernameTextfield;
	private JPasswordField passwordTextfield;
	
	LoginForm() {
		//l1 = new JLabel("Login Form");
		//l1.setForeground(Color.blue);
		//l1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gridbag);
		gbc.fill = GridBagConstraints.BOTH;

		JLabel loginLabel  = new JLabel("Login Form", SwingConstants.CENTER);
		gbc.gridy = 0; //row
		gbc.gridx = 0; //column
		gbc.gridwidth = 2;
		gridbag.setConstraints(loginLabel, gbc);
		add(loginLabel);
		
		JLabel usernameLabel = new JLabel("Username:");
		gbc.gridwidth = 1;
		gbc.gridy = 1; //row
		gbc.gridx = 0; //column
		gridbag.setConstraints(usernameLabel, gbc);
		add(usernameLabel);

		usernameTextfield = new JTextField(10);
		gbc.gridy = 1;
		gbc.gridx = 1;
		gridbag.setConstraints(usernameTextfield, gbc);
		add(usernameTextfield);
		
		JLabel passwordLabel = new JLabel("Password:");
		gbc.gridy = 2;
		gbc.gridx = 0;
		gridbag.setConstraints(passwordLabel, gbc);
		add(passwordLabel);

		passwordTextfield = new JPasswordField(10);
		gbc.gridy = 2;
		gbc.gridx = 1;
		gridbag.setConstraints(passwordTextfield, gbc);
		add(passwordTextfield);
		
		JButton button1 = new JButton("Button 1");
		gbc.gridy = 3;
		gbc.gridx = 0;
		gridbag.setConstraints(button1, gbc);
		add(button1, gbc);
		
		button1.addActionListener(this);
		setSize(600,600);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String username = usernameTextfield.getText();
		String password = new String(passwordTextfield.getPassword());
		
		Database db = new Database();
		db.establishConnection();
		db.isUsernameRegistered(username, password);
    }
}