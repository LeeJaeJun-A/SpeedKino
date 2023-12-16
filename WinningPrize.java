/**
 * The WinningPrize class extends the Money class to handle prize distribution for winning users.
 */
public class WinningPrize extends Money{
	/**
     * Constructor for WinningPrize.
     * 
     * @param window The Window object associated with this WinningPrize.
     */
	WinningPrize(Window window) {
		super(window); // Calls the constructor of the superclass (Money)
	}
	
	/**
     * Adds the first prize amount to the user's balance and updates it.
     */
	public void firstPrize() {
		setMoney(getMoney() + 25000000);
		updateMoney();
	}
	
	/**
     * Adds the second prize amount to the user's balance and updates it.
     */
	public void secondPrize() {
		setMoney(getMoney() + 1000000);
		updateMoney();
	}
	
	/**
     * Adds the third prize amount to the user's balance and updates it.
     */
	public void thirdPrize() {
		setMoney(getMoney() + 100000);
		updateMoney();
	}
	
	/**
     * Adds the fourth prize amount to the user's balance and updates it.
     */
	public void fourthPrize() {
		setMoney(getMoney() + 10000);
		updateMoney();
	}
	
	/**
     * Adds the fifth prize amount to the user's balance and updates it.
     */
	public void fifthPrize() {
		setMoney(getMoney() + 2000);
		updateMoney();
	}
	
	/**
     * Adds the sixth prize amount to the user's balance and updates it.
     */
	public void sixthPrize() {
		setMoney(getMoney() + 1000);
		updateMoney();
	}
	
	/**
     * Adds the seventh prize amount to the user's balance and updates it.
     */
	public void seventhPrize() {
		setMoney(getMoney() + 4000);
		updateMoney();
	}
}
