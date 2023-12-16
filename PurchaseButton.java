import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Handles purchase actions for a lottery game, including validation of selections, 
 * enforcing purchase limits, and managing balance deductions.
 */
public class PurchaseButton implements ActionListener{
	private Window window; // Reference to the main game window
	
	/**
     * Constructor that initializes the PurchaseButton with the game window.
     * Also initializes the purchase history in the window.
     * 
     * @param window The main game window
     */
	public PurchaseButton(Window window){
		this.window = window; 
		window.historyCount = 0; // Reset the count of purchased numbers
		window.historys = new ArrayList(); // Initialize the history list
	}
	
	/**
     * Defines the action to be performed when the purchase button is clicked.
     * Validates the number selection, checks the purchase limit and balance before allowing a purchase.
     * 
     * @param e ActionEvent triggered by clicking the purchase button.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(Window.numberButtons.size() != 10 || Window.numbers.size() != 10) { // Warns if 10 numbers are not selected yet
			JOptionPane.showMessageDialog(null, "You have to select 10 numbers to purchase.", "Warning", JOptionPane.WARNING_MESSAGE);
		}else if(window.historyCount == 10) { // Warns if the purchase limit per game is reached
			JOptionPane.showMessageDialog(null, "You can only purchase up to 10 numbers per game.", "Warning", JOptionPane.WARNING_MESSAGE);
		}else if(window.balance.getMoney() < 1000) { // Warns if there is not enough balance to make a purchase
			JOptionPane.showMessageDialog(null, "Your balance is insufficient.", "Warning", JOptionPane.WARNING_MESSAGE);
		}else {  // Processes the purchase if all checks pass
			addNewLabel();
		}
	}
	
	/**
     * Adds a new label to the purchase history panel with the selected numbers.
     * Sorts and checks for duplicate purchases before adding.
     */
	private void addNewLabel() {
		// Sorts the selected numbers in ascending order
		Collections.sort(Window.numbers, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return Integer.compare(Integer.parseInt(a), Integer.parseInt(b));
		    }
		});
		
		// Joins the sorted numbers into a string
		String numberString = String.join(" ", Window.numbers);
		
		// Warn if duplicate number set is already existed in history
		for(JLabel previousNumber: window.historys) {
			if(previousNumber.getText().equals("<html> " + numberString + " </html>")) {
				JOptionPane.showMessageDialog(null, "This is the number you already purchased.", "Warning", JOptionPane.WARNING_MESSAGE);
				return; // Exits if a duplicate is found
			}
		}
		// Creates a new label for the purchase history
        JLabel history = new JLabel("<html> " + numberString + " </html>"); // Using HTML to format text
        history.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Sets border spacing
        Dimension size = new Dimension(310, 50); // Sets the size of the label
        history.setPreferredSize(size);
        history.setHorizontalAlignment(JLabel.CENTER); // Centers text horizontally
        history.setVerticalAlignment(JLabel.CENTER); // Centers text vertically
        history.setFont(new Font("Lucida Grande", Font.PLAIN, 13)); // Sets the font of the label
        
        // Adds the new label to the history and updates the UI
        window.historys.add(history);
        window.historyCount++;
        window.purchaseHistoryPanel.add(history);
        window.purchaseHistoryPanel.revalidate(); // Refreshes the layout
        window.purchaseHistoryPanel.repaint(); // Repaints the panel to show the new label
        window.balance.purchaseCost(); // Deducts the cost of purchase from balance
		window.balance.updateMoney(); // Updates the display of money
    }
}
