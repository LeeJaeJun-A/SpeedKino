import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionEvent;

/**
 * NumberButton class implements the ActionListener interface to handle actions for a number selection button.
 */
public class NumberButton implements ActionListener{
	private static ArrayList<String> numbers; // List to store the number of selected buttons
	private static List<JButton> numberButtons;  // List to keep references to the selected JButton objects
	private static int selectedCount = 0; // for counting the number of selected buttons
	private static JLabel lblSelectedLabel; // Label to display the number of selected buttons
	private JButton button; // The JButton this instance of NumberButton is associated with
	private Color originalColor = new Color(254, 255, 255);  // The original background color of the button before selection
    private Color selectedButtonColor = new Color(255, 240, 248); // The background color of the button when it is selected
    
    /**
     * Constructor for the NumberButton class.
     * 
     * @param button         The JButton to which this NumberButton is associated.
     * @param label          The JLabel that displays the number of selected buttons.
     * @param numbers        The ArrayList that stores the text of selected buttons.
     * @param numberButtons  The List that keeps references to the selected JButton objects.
     */
	public NumberButton(JButton button, JLabel label, ArrayList<String> numbers, List<JButton> numberButtons) {
		this.button = button;
		NumberButton.lblSelectedLabel = label;
		NumberButton.numbers = numbers;
		NumberButton.numberButtons = numberButtons;
		button.setOpaque(true); // Make sure the background color is visible
	}
	
	/**
     * Invoked when an action occurs on the associated button.
     * 
     * @param arg0 The event that occurs when the button is pressed.
     */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (button.getBackground().equals(originalColor)) { // Button is clicked when the button is not selected yet
			// If more than 10 buttons are selected, prevent user from clicking the additional buttons
			if(lblSelectedLabel.getText().equals("Number of selected numbers: 10")) {
				JOptionPane.showMessageDialog(null, "Only 10 buttons can be selected.", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}
            button.setBackground(selectedButtonColor); // Change the background color to the selectedButtonColor
            // Update the selected count and lists
            selectedCount++;
            numbers.add(button.getText());
            numberButtons.add(button);
        } else { // Click the already selected button
            button.setBackground(originalColor); // Change the background color to the original color
            // / Update the selected count and lists
            numbers.remove(button.getText());
            numberButtons.remove(button);
            selectedCount--;//
        }
		lblSelectedLabel.setText("Number of selected numbers: " + selectedCount);
	}
	
	/**
	 * Setter of the selectedCount static variable.
	 * 
	 * @param selectedCount the number of buttons selected so far.
	 */
	public static void setSelectedCount(int selectedCount) {
		NumberButton.selectedCount = selectedCount;
	}

	/**
	 * Getter of the selectedCount static variable.
	 * 
	 * @return selectedCount the number of buttons selected so far.
	 */
	public static int getSelectedCount() {
		return selectedCount;
	}
}
