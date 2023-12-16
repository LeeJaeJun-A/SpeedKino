/**
 * The Money class encapsulates the money handling for the user associated with a window.
 * Updating money by implementing the Updateable interface.
 * It is the parent class of Balance class and WinningPrize class.
 */
public class Money implements Updateable{
	private Window window; // Reference to the Window object where the money is displayed and managed
	private int money; // The amount of money the user has
	
	 /**
     * Constructor initializing the Money object with a specific amount of money and the associated window.
     *
     * @param money  The initial amount of money.
     * @param window The Window object that displays and interacts with the user's balance.
     */
	Money(int money, Window window){
		setMoney(money); // Set the initial money amount
		this.window = window; // Store the reference to the window
	}
	
	/**
     * Alternative constructor that initializes the Money object using the user's current balance from the window.
     *
     * @param window The Window object that displays and interacts with the user's balance.
     */
	Money(Window window){
		this.window = window; // Store the reference to the window
		setMoney(window.user.getBalance()); // Initialize the money amount to the user's current balance
	}
	
	/**
     * Getter of the current amount of money.
     * 
     * @return The current money balance.
     */
	public int getMoney() {
		return money;
	}

	/**
	 * Setter of the current amount of money to a new value.
	 * 
	 * @param money Current money
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	
	/**
	 * Getter of window
	 * 
	 * @return Windows currently referencing
	 */
	public Window getWindow() {
		return window;
	}
	
	/**
     * Updates the display of money balance in the window and synchronizes the user's balance with it.
     */
	@Override
	public void updateMoney() {
		window.lblBalance.setText(Integer.toString(getMoney()) + " Won");
		window.user.setBalance(getMoney());
	}
}
