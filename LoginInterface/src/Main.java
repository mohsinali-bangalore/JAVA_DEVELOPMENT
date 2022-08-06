import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
	
	private static JLabel userLabel;
	private static JLabel passwordLabel;
	private static JTextField userField;
	private static JPasswordField passwordField;
	private static JButton button;
	private static JLabel success;
	private static JButton button2;
	private static JButton button3;

	public static void main(String[] args) {
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		userLabel = new JLabel("User ID: ");
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);
		
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);
		
		userField = new JTextField(); 
		userField.setBounds(100, 20, 165, 25);
		panel.add(userField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 50, 165, 25);
		panel.add(passwordField);
		
		button = new JButton("Login");
		button.setBounds(85, 80, 80, 25);
		button.addActionListener(new Main());
		panel.add(button);
		
		button2 = new JButton("Reset");
		button2.setBounds(175, 80, 80, 25);
		button2.addActionListener(new Main());
		panel.add(button2);

		button3 = new JButton("Exit");
		button3.setBounds(130, 120, 80, 25);
		button3.addActionListener(new Main());
		panel.add(button3);
		
		success = new JLabel("");
		success.setBounds(10, 110, 300, 25);
		panel.add(success);
		
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			String user = userField.getText();
			String password = passwordField.getText();
			//System.out.println(user + ", " + password);
			if(user.equals("mohsinali.bangalore") && password.equals("Password1234@")) {
				success.setText("Login Successful!");
			} else {
				success.setText("Invalid credentials");
			}
		} else if(e.getSource() == button2) {
			userField.setText(null);
			passwordField.setText(null);
			success.setText(null);
		} else if(e.getSource() == button3) {
			System.exit(0);
		}
	}

}
