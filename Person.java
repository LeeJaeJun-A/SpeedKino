import java.time.LocalDate;
import java.time.Period;

/**
 * The Person class represents a person with a name, birth date, and age.
 * It provides methods to set and get these properties and calculate the age.
 */
public class Person {
	private String name; // for saving the person's name
	private String birthDate; // for saving the birthDate in YYYY-MM-DD format
	private int age; // for saving the person's age in years

	 /**
     * Constructor that initializes a Person object with a name and birth date.
     * Implement caculateAge method to calculate the person's age based on birth date.
     * 
     * @param name         The String that represents the person's name.
     * @param birthDate    The String that represents the person's birth date in YYYY-MM-DD format.
    
     */
	Person(String name, String birthDate){
		setName(name);
		setBirthDate(birthDate);
		calculateAge();
	}

	/**
     * Overloaded constructor that initializes a Person object with only a name.
     * 
     * @param name The String that represents the person's name.
     */
	Person(String name){
		setName(name);
	}
	
	/**
	 * Getter of name.
	 * 
	 * @return The person's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
     * Setter of the person's name.
     * 
     * @param name the name to set.
     */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter of birthDate.
	 * 
	 * @return The person's birth date in YYYY-MM-DD format.
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
     * Setter of the birth date of the person and recalculates the age.
     * 
     * @param birthDate The person's birth date to set in YYYY-MM-DD format.
     */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	/**
	 * Getter of age.
	 * 
	 * @return The person's age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Setter of age.
	 * 
	 * @param age The person's age.
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * This method calculates the age of the person based on the birth date.
	 */
	public void calculateAge() {
		LocalDate birthDate = LocalDate.parse(getBirthDate()); // Convert the birth date string to a LocalDate object
		LocalDate currentDate = LocalDate.now(); // Get the current date
		int tempAge = Period.between(birthDate, currentDate).getYears(); // Calculate the full years between the birth date and current date
		
		 // If the current date is before the birthday in the current year, decrement the age by one
		if (currentDate.getMonthValue() < birthDate.getMonthValue() || (currentDate.getMonthValue() == birthDate.getMonthValue() && currentDate.getDayOfMonth() < birthDate.getDayOfMonth())) {
				tempAge--;
	    }
		setAge(tempAge);// Set the age with the calculated value
	}
}
