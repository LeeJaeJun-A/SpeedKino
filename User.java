/**
 * User class extends Person to add additional attributes and functionality specific to a user.
 */
public class User extends Person{
	private boolean isTeenager = false; // Flag to indicate if the user is a teenager (under 19 years old)
	private String id; // User's identification string
	private String password; // User's password for authentication
	private int balance; // User's current balance
	
	/**
     * Constructor for User with name, birth date, ID, and password.
     * Determines if the user is a teenager based on the age calculated from the birth date.
     * Sets initial balance to zero.
     *
     * @param name      The name of the user.
     * @param birthDate The birth date of the user.
     * @param id        The identification string of the user.
     * @param password  The password of the user.
     */
	User(String name, String birthDate, String id, String password) {
		super(name, birthDate); // Call to the superclass (Person) constructor
		if(this.getAge() < 19) {
			setIsTeenager(true);
		}
		setId(id);
		setPassword(password);
		setBalance(0); // Initial balance set to zero
	}
	
	/**
     * Alternate constructor for User with name, ID, password, and balance.
     * This constructor does not require a birth date.
     * It will be used for the user who already register the account.
     * 
     * @param name     The name of the user.
     * @param id       The identification string of the user.
     * @param password The password of the user.
     * @param balance  The initial balance of the user.
     */
	User(String name, String id, String password, int balance) {
		super(name); // Call to the superclass (Person) constructor
		setId(id);
		setPassword(password);
		setBalance(balance); // Balance set to the user's previous balance information
	}
	
	/**
     * Gets the ID of the user.
     * 
     * @return The ID of the user.
     */
	public String getId() {
		return id;
	}

	/**
     * Sets the ID of the user.
     * 
     * @param id The ID to set for the user.
     */
	public void setId(String id) {
		this.id = id;
	}

	/**
     * Gets the password of the user.
     * 
     * @return The password of the user.
     */
	public String getPassword() {
		return password;
	}

	/**
     * Sets the password of the user.
     * 
     * @param password The password to set for the user.
     */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
     * Gets the balance of the user.
     * 
     * @return The balance of the user.
     */
	public int getBalance() {
		return balance;
	}

	/**
     * Sets the balance of the user.
     * 
     * @param balance The balance to set for the user.
     */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	/**
     * Checks if the user is a teenager.
     * 
     * @return True if the user is a teenager, false otherwise.
     */
	public boolean getIsTeenager() {
		return isTeenager;
	}

	/**
     * Sets the teenager status of the user.
     * 
     * @param isTeenager The teenager status to set for the user.
     */
	public void setIsTeenager(boolean isTeenager) {
		this.isTeenager = isTeenager;
	}
	
	/**
     * Returns a string representation of the user, including name, ID, password, and balance.
     * 
     * @return String representation of the user.
     */
	@Override
	public String toString() {
		return getName() + " " + getId() + " " + getPassword() + " " + String.valueOf(getBalance());	
	}
	
}
