import java.util.TimerTask;
import java.util.Timer;
import javax.swing.SwingUtilities;

/**
 * GameTimer is responsible for keeping track of the game time and handling game events when the timer runs out.
 */
public class GameTimer {
	private Window window; // Reference to the Window object where the money balance is displayed and managed
	private WinningNumber winningNumber;
	private Timer timer;
	private int timeLeft; // for saving the remaining time as seconds
	private int minutes; // for saving remaining minutes value
	private int seconds; // for saving remaining seconds value

	/**
     * Constructor for GameTimer.
     * 
     * @param window        The main window of the application where the timer will be displayed.
     * @param winningNumber Classes to draw the winning numbers.
     */
	public GameTimer(Window window) {
		this.window = window; // Store the reference to the window.
		winningNumber = new WinningNumber(window);
		timer = new Timer();
		setTimeLeft(180000); // Initialize the time for 3 minutes
		startTimer(); // Start the game timer as soon as an instance is created
	}
	
	/**
     * This method sets up and starts the game timer.
     */
	private void startTimer() {	
		// Schedule a task to run at a fixed rate (3 minutes)
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (timeLeft > 0) {
                    timeLeft -= 1000; // Decrease time left by 1 second
                    minutes = timeLeft / 60000; // Calculate minutes from timeLeft
                    seconds = (timeLeft % 60000) / 1000; // Calculate seconds from timeLeft
                    window.lblTimer.setText(String.format("%02d:%02d", minutes, seconds)); // Update the timer label in the window with the new time
                } else {
                    this.cancel(); // Stop the timer when time runs out (timeLeft <= 0)
                    SwingUtilities.invokeLater(() -> winningNumber.actionPerformed(null)); // Execute the winning number action on the Event Dispatch Thread
                    // Start a new thread to wait until the winning number process is complete
                    new Thread(() -> {
                        synchronized (winningNumber.getLock()) {
                            try {
                                winningNumber.getLock().wait(); // Wait until the winning number process is complete
                                timeLeft = 180000; // Reset the time to 3 minutes
                                window.btnPurchase.setEnabled(true); // Re-enable the purchase button
                                // reset game history
                        		window.historyCount = 0;
                        		window.historys.clear();
                        		window.purchaseHistoryPanel.removeAll();
                        		window.purchaseHistoryPanel.revalidate();
                                window.purchaseHistoryPanel.repaint();
                                startTimer(); // Restart the timer
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            }
        }, 1000L, 1000L); // Schedule to run after 1 second delay, and then every 1 second
    }
	
	/**
     * Setting the timeLeft variable.
     * 
     * @param timeLeft The remaining time.
     */
	public void setTimeLeft(int timeLeft) {
		this.timeLeft = timeLeft;
	}
}
