import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * The Balance class extends the Money class to manage the user's balance.
 * It includes methods to fill the balance and to update the balance after making purchases.
 */
public class Balance extends Money{
	private int remainingTimeForCharge; // for counting the remaining time for charge
	
	/**
     * Constructor for the Balance class with two arguments.
     * @param money   Initial amount of money to set.
     * @param window  The Window object where the balance will be displayed and managed.
     */
	Balance(int money, Window window) {
		super(money, window);		
	}
	
	/**
     * This method increases the user's balance by a fixed amount (3000 won).
     * To limit reckless free charging,it also starts a count down timer to re-enable the charge button after 60 seconds.
     */
	public void freeCharge() {
		setMoney(getWindow().user.getBalance()+3000); // Add 3000 won to the balance
		updateMoney(); // Update the display
		getWindow().btnCharge.setEnabled(false); // Disable the charge button to prevent reckless charges
		startChargeCountDown();
	}
	
	/**
     * Count down timer to re-enable the charge button after 60 seconds.
     */
	private void startChargeCountDown() {
		remainingTimeForCharge = 60; // Set the next time for charging to 1 minute
		getWindow().btnCharge.setText("1:00");
		
        Timer timer = new Timer(1000, new ActionListener() {
        	 // Timer to count down from 60, updating the button text each second
            @Override
            public void actionPerformed(ActionEvent e) {
            	remainingTimeForCharge--; // Decrement the remaining time
            	getWindow().btnCharge.setText(Integer.toString(remainingTimeForCharge)); // Update the button text to show the remaining time
            	// Re-enable the button and reset its text after a minute.
            	if (remainingTimeForCharge <= 0) {
                    ((Timer) e.getSource()).stop();
                    getWindow().btnCharge.setEnabled(true);
                    getWindow().btnCharge.setText("Charge");
                }
            }
        });
        timer.start(); // Start the count down timer
	}
	
	/**
     * Decreases the user's balance by the cost of a purchase (1000 won).
     */
	public void purchaseCost() {
		setMoney(getWindow().user.getBalance() - 1000); // Deduct the purchase cost from the balance
		updateMoney();  // Update the display
	}
}