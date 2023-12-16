import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Implements ActionListener to handle the save operation for a user's account information,
 * including updating the balance in a persistent storage.
 */
public class Save implements ActionListener{
	private Window window; // Reference to the main window of the application
	private String id;  //for saving user ID for identification
	private String password; // for saving user password for authentication
	private String[] information;  // Array to hold account information read from file
	
	/**
	 * Constructor that initializes the Save object with the main application window
	 * 
	 * @param window The main game window
	 */
	public Save(Window window) {
		this.window = window;
	}
	
	/**
     * Performs the action of saving the user's balance when an event is received.
     * Reads the existing account file, updates the balance for the current user, and writes back to the file.
     * 
     * @param e The event that triggers the save action
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		id = window.getId(); // Retrieve the ID from the window
		password = window.getPassword(); // Retrieve the password from the window
		 
		try {
			FileInputStream fileObject = new FileInputStream("account.txt"); // Open the account file for reading
	    	Scanner x = new Scanner(fileObject); // Scanner for reading the file
	    	String line = new String();
	    	String result = ""; // String to store the updated account information	
	    	
	    	// Read the file line by line
	    	while(x.hasNext()) {
	    		line = x.nextLine();
	    		information = line.split(" "); // Split the line into parts
                
	    		// If the line corresponds to the current user, update the balance
	    		if(information[1].equals(id) && information[2].equals(password)){
	    			information[3] = Integer.toString(window.user.getBalance());
	    		}
	    		
	    		 // Reconstruct the account information with updated balance
	    		result += information[0] + " " + information[1] + " " + information[2] + " " + information[3] + "\n";   
	    	}
	    	
	    	// Remove the trailing newline character
	    	if (result.endsWith("\n")) {
	    		result = result.substring(0, result.length() - 1);
	    	}
	    	
	    	FileOutputStream fileOutputObject = new FileOutputStream("account.txt"); // Open the account file for writing
			PrintWriter printWriter = new PrintWriter(fileOutputObject); // PrintWriter to write to the file
	        printWriter.println(result); // Write the updated account information
	        printWriter.close(); // Close the PrintWriter
	        
	        // Show success message
	    	JOptionPane.showMessageDialog(null, "Your balance has been successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(IOException a) { // Show error message in case of failure
			JOptionPane.showMessageDialog(null, "Fail to update", "Fail", JOptionPane.WARNING_MESSAGE);
			a.printStackTrace(); // Print the stack trace for debugging
		}
	}
}
