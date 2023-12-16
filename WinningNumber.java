import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * WinningNumber class implements ActionListener to handle the generation of winning numbers randomly.
 */
public class WinningNumber implements ActionListener{
	private Window window; // Reference to the main application window.
	private final Object lock = new Object(); // Lock object for synchronization purposes
	private List<Integer> numberList; // List of all possible numbers (1 to 70)
	private List<Integer> winningNumberList; // List of selected winning numbers
	private List<Integer> resultList; // List to track the number of matches for each history entry
	private StringBuilder message; // StringBuilder to construct the result message
	
	/**
     * Constructor for WinningNumber.
     * 
     * @param window The Window object associated with this action.
     */
	public WinningNumber(Window window) {
		this.window = window;
		numberList = new ArrayList<>();
		// Populating the list with numbers 1 through 70
		for (int i = 1; i <= 70; i++) {
            numberList.add(i);
        }
	}

	/**
     * Invoked when an action occurs.
     * 
     * @param arg0 The event that triggers this action.
     */
	@Override
    public void actionPerformed(ActionEvent arg0) {
        new Thread(() -> {
        	window.btnPurchase.setEnabled(false); // While populate the winning number, disable to purchase
    		Collections.shuffle(numberList); // Shuffle the number list for random selection
    		winningNumberList = numberList.subList(0, 22); // Select the first 22 numbers as winning numbers
    		String numbers = "";
    		resultList = new ArrayList<>(Collections.nCopies(window.historyCount, 0));
    		
    		// Loop through the winning numbers and display them
    		for(int i = 0; i < winningNumberList.size(); i++) {
    			String winningOneNumber = Integer.toString(winningNumberList.get(i));
    			numbers += winningOneNumber + " ";
    			if(i == 9) {
    				numbers += "<br>"; // Add a line break after 10 numbers for formatting
    			}
    			final String finalNumbers = numbers;
                SwingUtilities.invokeLater(() -> {
                    window.lblWinningNumber.setText("<html><div style='text-align: center;'>" + finalNumbers + "</div></html>");
                });
                
            	// Check for matching numbers in user's history
                for(int j = 0; j < window.historyCount; j++) {
                	checkSameNumber(window.historys.get(j), winningOneNumber, j);
                }
                
    			try {
                    Thread.sleep(1000); // Delay for 1 second.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    		}
    		// Building the result message.
    		message = new StringBuilder();
    		checkRank(message); // Check the rank and update the message accordingly
    		if(message.length() > 0) { // If the user participate in the game in this round, display the result message
				JOptionPane.showMessageDialog(null, message.toString(), "Result", JOptionPane.INFORMATION_MESSAGE);
			}
    		
    		// Notify that the task is completed to start a new round
            synchronized (lock) {
                lock.notify();
            }
        }).start();
    }
	
	/**
     * Gets the lock object for synchronization.
     * 
     * @return The lock object.
     */
	public Object getLock() {
        return lock;
    }
	
	/**
     * Checks if the user's numbers match any of the winning numbers.
     * 
     * @param history        The JLabel representing the user's number history.
     * @param winningOneNumber A winning number to compare against.
     * @param historyNumber  The index of the user's history entry.
     */
	private void checkSameNumber(JLabel history, String winningOneNumber, int historyNumber) {
		String userNumber = history.getText().replace("<html>", "").replace("</html>", ""); // Retrieve the text from the history label and remove HTML tags
		String[] userNumbers = userNumber.split(" "); // Split the text to get individual numbers
		
		// Loop through the user's numbers to check for matches with the winning number
		for(int i = 0; i < userNumbers.length; i++) {
			if(userNumbers[i].equals(winningOneNumber)) {
				userNumbers[i] = "<font color= 'red'>" + userNumbers[i] + "</font>"; // If a match is found, highlight the number in red
				resultList.set(historyNumber, resultList.get(historyNumber) + 1); // Increment the count of matched numbers for this history entry
			}
		}
		history.setText("<html>" + String.join(" ", userNumbers) + "</html>"); // Update the history label with the possibly modified numbers (with matches highlighted)
	}
	
	/**
     * Checks the user's rank based on the number of matched winning numbers and constructs a message.
     * 
     * @param message The StringBuilder to append the result message.
     */
	private void checkRank(StringBuilder message) {
		window.winningStructure = new WinningPrize(window); // Initialize the WinningPrize object
		
		// Loop through each entry in the resultList to determine the user's rank
		for(int i = 0; i < resultList.size(); i ++) {
			switch(resultList.get(i)) { // Check the number of matched numbers
				case 10: // First prize
					message.append(i + ". First prize: 25,000,000 Won\n");
					window.winningStructure.firstPrize();
					break;
				case 9: // Second prize
					message.append(i + ". Second prize: 1,000,000 Won\n");
					window.winningStructure.secondPrize();
					break;
				case 8: // Third prize
					message.append(i + ". Third prize: 100,000 Won\n");
					window.winningStructure.thirdPrize();
					break;
				case 7: // Fourth prize
					message.append(i + ". Fourth prize: 10,000 Won\n");
					window.winningStructure.fourthPrize();
					break;
				case 6: // Fifth prize
					message.append(i + ". Fifth prize: 2,000 Won\n");
					window.winningStructure.fifthPrize();
					break;
				case 5: // Sixth prize
					message.append(i + ". Sixth prize: 1,000 Won\n");
					window.winningStructure.sixthPrize();
					break;
				case 4: case 3: case 2: case 1: // Fail to prize
					message.append(i + ". No Luck\n");
					break;
				case 0: // Seventh prize
					message.append(i + ". Seventh prize: 4,000 Won\n");
					window.winningStructure.seventhPrize();
					break;
			}
			
		}
	}
}
