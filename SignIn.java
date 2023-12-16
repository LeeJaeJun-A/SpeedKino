import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 * SignIn class implements ActionListener to handle the sign-in process for the application.
 */
public class SignIn implements ActionListener{
	private Window window; // Reference to the main application window where the sign-in process is managed.
	private String id; // for saving user's ID for login.
	private String password; // for saving user's password for login.	
	private boolean isValid; // Flag to check if the input (ID and password) is valid.
	private boolean loginSucceed;  // Flag to indicate whether the login process has succeeded.
	private String[] information; // Array to store user information read from the account.txt file.
	
	/**
     * Constructor for SignIn.
     * 
     * @param window The main window of the application.
     */
	public SignIn(Window window) {
		this.window = window;
	}
	
	/**
     * Invoked when an action occurs on the sign-in button.
     * 
     * @param e The event that occurs when the button is pressed.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		checkValid(); // Check the validity of the entered ID and password
		if(!isValid) {
			return;
		}
		loginSucceed = false;
		try{
	    	FileInputStream fileObject = new FileInputStream("account.txt");
	    	Scanner x = new Scanner(fileObject);
	    	String line = new String();
	    	while(x.hasNext()) {
	    		line = x.nextLine();
	    		information = line.split(" ");
	    		// Check if the ID and password match an account in the file
	    		if(information[1].equals(id) && information[2].equals(password)){
	    			loginSucceed = true;
	    			break;
	    		}else if(information[1].equals(id) && !information[2].equals(password)) { // When ID exists in file, but password is not match
	    			JOptionPane.showMessageDialog(null, "ID and password do not match.", "Fail", JOptionPane.WARNING_MESSAGE);
	    			return;
	    		}
	    	}
	    	  	
	    	if(loginSucceed) {
	    		// On successful login, initialize the balance and user, and update the UI
	    		window.balance = new Balance(Integer.parseInt(information[3]), window);
	    		window.user = new User(information[0],information[1],information[2], Integer.parseInt(information[3]));
	    		window.lblBalance.setText(window.user.getBalance() + " Won");
	    		
	    		// Hide login fields and display greeting
	    		window.lblID.setVisible(false);
	    		window.idField.setVisible(false);
	    		window.lblPassword.setVisible(false);
	    		window.passwordField.setVisible(false);
	    		window.btnSignIn.setVisible(false);
	    		window.btnSignUp.setVisible(false);
	    		window.lblGreeting.setText("Hello! " + information[0]);
	    		
	    		window.btnSave.setEnabled(true); // Enable save button
	    		window.btnPurchase.setEnabled(true); // Enable purchase button
	    		window.btnClear.setEnabled(true); // Enable clear button
	    		window.btnCharge.setEnabled(true); // Enable charge button
	    		window.timer = new GameTimer(window); // Start game timer
	    	}else {// Display error if login fails
	    		JOptionPane.showMessageDialog(null, "Account does not exist. Please make an account.", "Fail", JOptionPane.WARNING_MESSAGE);
	    	}
	    } catch (FileNotFoundException a) {
	    	JOptionPane.showMessageDialog(null, "Account does not exist. Please make an account.", "Fail", JOptionPane.WARNING_MESSAGE);
	    }
	}
	
	/**
     * Checks the validity of the entered ID and password.
     */
	private void checkValid() {
		id = window.getId();
		password = window.getPassword();
		isValid = true;
		
		Pattern idPattern = Pattern.compile("^[A-Za-z0-9]+$"); // Regular expression for alphanumeric and numeric IDs.
		Matcher idMatcher = idPattern.matcher(id);
		
		int passwordLength = password.length();
		
		// Check if ID and password are entered and if they meet the requirements.
		if(id.equals("") || password.equals("")) { // 
			JOptionPane.showMessageDialog(null, "Please enter both ID and password.", "Fail", JOptionPane.WARNING_MESSAGE);
			isValid = false;
		}else if(!idMatcher.matches()) { // When there are letters other than alphabet and numbers
			JOptionPane.showMessageDialog(null, "You can only use alphabet and number.", "Fail", JOptionPane.WARNING_MESSAGE);
			isValid = false;
		}else if(!(passwordLength >= 6 && passwordLength <= 20)) { // When the password number of characters is not valid
			JOptionPane.showMessageDialog(null, "The password is between 6 and 20 characters.", "Fail", JOptionPane.WARNING_MESSAGE);
			isValid = false;
		}
	}
}
