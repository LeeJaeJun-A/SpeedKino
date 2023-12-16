import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

/**
 * SignUp class extends JDialog to handle the user registration process.
 */
public class SignUp extends JDialog{
	private JFrame frame; // Frame that contains the sign-up form
	private JLabel lblID; // Label for the user ID input field
	private JTextField idTextField; // Text field for user ID input
	private JLabel lblPassword; // Label for the password input field
	private JLabel lblName; // Label for the name input field
	private JTextField nameTextField; // Text field for the name input
	private JPasswordField passwordTextField; // Password field for user password input
	private JLabel lblBirthDate; // Label for the birth date input field
	private JTextField birthDateTextField; // Text field for birth date input
	private JButton btnNewButton; // Button to submit the sign-up form
	private StringBuilder errorMessage; // StringBuilder to construct the error message for invalid inputs
	private int errorNumber; // Counter to keep track of the number of errors in the form
	
	// Variables to store user input data
	private String id; // User ID
	private String password; // User password
	private String name; // User name
	private String birthDate; // User birth date
	private String[] information; // Array to store user information
	
	/**
     * Constructor for the SignUp dialog.
     * 
     * @param parent The parent frame to which this dialog is attached.
     */
	public SignUp(Frame parent) {
        super(parent, "Sign Up", true);// Set up as a modal dialog
        
        this.setSize(400, 275); // Set dialog size
        this.setLocationRelativeTo(parent); // Center the dialog relative to the parent frame
        this.setResizable(false); // Make the dialog non-resizable
        
        initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Setup GridBagLayout and add components
		GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] {0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        
        // Adding and setting up the ID label
        lblID = new JLabel("ID (English, Number only)");
        lblID.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_lblID = new GridBagConstraints();
        gbc_lblID.anchor = GridBagConstraints.WEST;
        gbc_lblID.insets = new Insets(5, 20, 5, 0);
        gbc_lblID.gridx = 0;
        gbc_lblID.gridy = 0;
        getContentPane().add(lblID, gbc_lblID);
        
        // Adding and setting up the ID text field
        idTextField = new JTextField();
        GridBagConstraints gbc_idTextField = new GridBagConstraints();
        gbc_idTextField.insets = new Insets(0, 10, 5, 10);
        gbc_idTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_idTextField.gridx = 0;
        gbc_idTextField.gridy = 1;
        getContentPane().add(idTextField, gbc_idTextField);
        idTextField.setColumns(10);
        
        // Adding and setting up the Password label
        lblPassword = new JLabel("Password (minimum 6, maximum 20 characters)");
        GridBagConstraints gbc_lblPassword = new GridBagConstraints();
        gbc_lblPassword.anchor = GridBagConstraints.WEST;
        gbc_lblPassword.insets = new Insets(0, 20, 5, 0);
        gbc_lblPassword.gridx = 0;
        gbc_lblPassword.gridy = 2;
        getContentPane().add(lblPassword, gbc_lblPassword);
        
        // Adding and setting up the Password text field
        passwordTextField = new JPasswordField();
        GridBagConstraints gbc_passwordTextField = new GridBagConstraints();
        gbc_passwordTextField.insets = new Insets(0, 10, 5, 10);
        gbc_passwordTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordTextField.gridx = 0;
        gbc_passwordTextField.gridy = 3;
        getContentPane().add(passwordTextField, gbc_passwordTextField);
        
        // Adding and setting up the Name label
        lblName = new JLabel("Name");
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.anchor = GridBagConstraints.WEST;
        gbc_lblName.insets = new Insets(0, 20, 5, 0);
        gbc_lblName.gridx = 0;
        gbc_lblName.gridy = 4;
        getContentPane().add(lblName, gbc_lblName);
        
        // Adding and setting up the Name text field
        nameTextField = new JTextField();
        GridBagConstraints gbc_nameTextField = new GridBagConstraints();
        gbc_nameTextField.insets = new Insets(0, 10, 5, 10);
        gbc_nameTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nameTextField.gridx = 0;
        gbc_nameTextField.gridy = 5;
        getContentPane().add(nameTextField, gbc_nameTextField);
        nameTextField.setColumns(10);
        
        // Adding and setting up the BirthDate label
        lblBirthDate = new JLabel("Birth Date (ex. 2001-06-30)");
        GridBagConstraints gbc_lblBirthDate = new GridBagConstraints();
        gbc_lblBirthDate.anchor = GridBagConstraints.WEST;
        gbc_lblBirthDate.insets = new Insets(0, 20, 5, 0);
        gbc_lblBirthDate.gridx = 0;
        gbc_lblBirthDate.gridy = 6;
        getContentPane().add(lblBirthDate, gbc_lblBirthDate);
        
        // Adding and setting up the BirthDate text field
        birthDateTextField = new JTextField();
        GridBagConstraints gbc_birthDateTextField = new GridBagConstraints();
        gbc_birthDateTextField.insets = new Insets(0, 10, 5, 10);
        gbc_birthDateTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_birthDateTextField.gridx = 0;
        gbc_birthDateTextField.gridy = 7;
        getContentPane().add(birthDateTextField, gbc_birthDateTextField);
        birthDateTextField.setColumns(10);
        
        btnNewButton = new JButton("Sumbit"); // Button for submitting the sign-up form
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		errorMessage = new StringBuilder();
        		errorNumber = 1;
        		// Validation checks for each field
        		try {
					idError();
					passwordError();
	        		nameError();
	        		birthDateError();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
        		if(errorMessage.length() >0) { // Display error messages if any validation fails
        			JOptionPane.showMessageDialog(null, errorMessage.toString(), "Fail", JOptionPane.WARNING_MESSAGE);
        		}else {
        			User user = new User(name, birthDate, id, password); // Make new user
        			if(user.getIsTeenager()) { // If user's age is under 19, this user can't use this program
        				JOptionPane.showMessageDialog(null, "Under 19 years of age, sign up is not allowed.", "Fail", JOptionPane.WARNING_MESSAGE);
        				return;
        			}
        		    try{// If user's information are all valid, update the account.txt file and then finish the registration.
        		    	FileOutputStream fileObject;
        		    	fileObject = new FileOutputStream("account.txt",true);
        				PrintWriter printWriter = new PrintWriter(fileObject);
        		        printWriter.println(user.toString());
        		        printWriter.close();
        		    	JOptionPane.showMessageDialog(null, "Successfully Submitted", "Success", JOptionPane.INFORMATION_MESSAGE);
            			dispose();
        		    } catch (IOException e) {
        		        e.printStackTrace();
        		    }
        		}
        		
        	}
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 8;
        getContentPane().add(btnNewButton, gbc_btnNewButton); // Add btnNewButton to the content pane
	}
	
	/**
	 * Validates the ID entered by the user.
	 * Checks if the ID field is empty, follows the defined pattern, and ensures the ID is unique.
	 * 
	 * @throws FileNotFoundException If the account file cannot be found.
	 */
	private void idError() throws FileNotFoundException {
		id = idTextField.getText(); // Retrieve the text entered in the ID field
		Pattern idPattern = Pattern.compile("^[A-Za-z0-9]+$"); // Regular expression for allowing only alphabet and numbers
		Matcher idMatcher = idPattern.matcher(id); // Match the ID against the pattern
		
		if(id.equals("")) { // Error if ID field is empty
			errorMessage.append(errorNumber + ". You forgot to fill the id text field, Please fill it.\n");
			errorNumber++;
		}else if(!idMatcher.matches()) { // Error if ID includes the other characters except for alphabet and numbers
			errorMessage.append(errorNumber + ". Please follow the id setting rules.\n");
			errorNumber++;
		}
		try{
		FileInputStream fileObject = new FileInputStream("account.txt"); // Open the file containing account information
    	Scanner x = new Scanner(fileObject);
    	String line = new String();
    	while(x.hasNext()) {
    		line = x.nextLine();
    		information = line.split(" ");  // Split the line to get individual fields
    		if(information[1].equals(id)){ // Error if the ID already exists in the file
    			errorMessage.append(errorNumber + ". This id already exists.\n");
    			errorNumber++;
    			break;
    		}
    	}}catch(FileNotFoundException e) {
    		return;
    	}
	}
	
	/**
	 * Validates the password entered by the user.
	 * Checks if the password field is empty and meets the length requirements.
	 */
	private void passwordError() {
		char[] passwordCharArray = passwordTextField.getPassword(); // Retrieve the password entered
		password = new String(passwordCharArray); // Convert password form char to String
		int passwordLength = password.length(); // Get the length of the password
		if(password.equals("")) { // Error if password field is empty
			errorMessage.append(errorNumber + ". You forgot to fill the password text field, Please fill it.\n");
			errorNumber++;
		}else if(!(passwordLength >= 6 && passwordLength <= 20)) { // Error if password length is not within the required range
			errorMessage.append(errorNumber + ". Please follow the password setting rules.\n");
			errorNumber++;
		}
		java.util.Arrays.fill(passwordCharArray, '0'); // Clear the password array for security
	}
	
	/**
	 * Validates the name entered by the user.
	 * Checks if the name field is empty.
	 */
	private void nameError() {
		name = nameTextField.getText(); // Retrieve the name entered in the name field
		
		if(name.equals("")) { // Error if name field is empty
			errorMessage.append(errorNumber + ". You forgot to fill the name text field, Please fill it.\n");
			errorNumber++;
		}
	}
	
	/**
	 * Validates the birth date entered by the user.
	 * Checks if the birth date field is empty, follows the defined format, and is a valid date.
	 */
	private void birthDateError() {
		birthDate = birthDateTextField.getText(); // Retrieve the birth date entered.
		Pattern birthDatePattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$"); // Regular expression pattern for date format yyyy-mm-dd
		Matcher birthDateMatcher = birthDatePattern.matcher(birthDate); // Match the birth date against the pattern
		if(birthDate.equals("")) {
			errorMessage.append(errorNumber + ". You forgot to fill the birth date text field, Please fill it.\n"); // Error if birth date field is empty
			errorNumber++;
		}else if(birthDateMatcher.matches()) {
			String[] parts = birthDate.split("-"); // Split the birth date into year, month, and day
			int year = Integer.parseInt(parts[0]);
			int month = Integer.parseInt(parts[1]);
			int day = Integer.parseInt(parts[2]);
			int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // Maximum days in each month
			
			// Adjust for leap year
			if (month == 2 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
	            maxDays[1] = 29;
	        }
			
			// Check if the month and day are valid.
			if(month < 1 || month > 12) { // Error if month is invalid s
				errorMessage.append(errorNumber + ". Invalid date.\n"); 
				errorNumber++;
			}else if(day < 1 || day > maxDays[month -1]) { // Error if day is invalid for the given month
				errorMessage.append(errorNumber + ". Invalid date.\n");
				errorNumber++;
			}
		}else{ // Error if birth date does not match the required format
			errorMessage.append(errorNumber + ". Birthdate must be in 'yyyy-mm-dd'format.\n");
			errorNumber++;
		}
	}
}
