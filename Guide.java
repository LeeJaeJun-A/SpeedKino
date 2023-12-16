import java.awt.Frame;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Guide class extends JDialog to create a modal dialog box with instructions for the game.
 */
public class Guide extends JDialog{
	private JFrame frame;
	// for saving the guideline
	private JLabel lblGuideOne; 
	private JLabel lblGuideTwo;
	private JLabel lblGuideThree;
	private JLabel lblGuideFour;
	private JLabel lblGuideFive;
	private JLabel lblGuideSix;
	private JLabel lblGuideCharge;
	
	private JLabel lblWinningStructure; // for representing winning structure image
	private JButton btnOK;
	
	/**
     * Constructor for creating the guide dialog.
     * Set up the dialog as a modal window.
     * 
     * @param parent The parent frame to which this dialog will be attached.
     */
	public Guide(Frame parent) {
		super(parent, "Guide", true);
		getContentPane().setBackground(new Color(238, 238, 238)); // Set the background color of the dialog
		initialize(); // Initialize the UI components
		this.setSize(393, 475); // Set the size of the dialog
		this.setLocationRelativeTo(parent);  // Center the dialog relative to the parent frame
		getContentPane().setLayout(null); // Use absolute layout
		this.setResizable(false); // Make the dialog non-resizable
	}
	
	/**
     * Initialize the UI components of the dialog.
     */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Default close operation
		
		// Label with instructions to log in first
		lblGuideOne = new JLabel("1. Please log in first");
		lblGuideOne.setBounds(6, 6, 338, 22);
		getContentPane().add(lblGuideOne);
		
		// Label with instructions for signing up if the user doesn't have an account
		lblGuideTwo = new JLabel("<html>2. If you don't have an account,<br>please press the sign up button to sign up.</html>");
		lblGuideTwo.setBounds(6, 29, 338, 34);
		getContentPane().add(lblGuideTwo);
		
		// Label with instructions to select 10 numbers
		lblGuideThree = new JLabel("3. Select 10 numbers.");
		lblGuideThree.setBounds(6, 59, 338, 34);
		getContentPane().add(lblGuideThree);
		
		// Label with instructions to press the purchase button, including the cost
		lblGuideFour = new JLabel("4. press the purchase button. The purchase cost is 1,000 won");
		lblGuideFour.setBounds(6, 82, 338, 34);
		getContentPane().add(lblGuideFour);
	
		// Label indicating the frequency of drawing the winning number
		lblGuideFive = new JLabel("<html>5. The draw starts every three minutes.</html>");
		lblGuideFive.setBounds(6, 95, 338, 54);
		getContentPane().add(lblGuideFive);
		
		// Label explaining how the winning numbers are drawn and how the ranking is determined
		lblGuideSix = new JLabel("<html>6. The program will randomly pick 22 out of 70 numbers, and your ranking will be determined accordingly.</html>");
		lblGuideSix.setBounds(6, 120, 370, 61);
		getContentPane().add(lblGuideSix);
		
		// Label with instruction about charging money
		lblGuideCharge = new JLabel("<html>* If you don't have money, press the charge button</html>");
		lblGuideCharge.setForeground(new Color(255, 38, 0));
		lblGuideCharge.setBounds(6, 148, 387, 61);
		getContentPane().add(lblGuideCharge);
		
		// Label for reminding users to save their balance
		lblGuideCharge = new JLabel("<html>* Don't forget to press save button for saving your balance.</html>");
		lblGuideCharge.setForeground(new Color(255, 38, 0));
		lblGuideCharge.setBounds(6, 167, 380, 61);
		getContentPane().add(lblGuideCharge);
		
		// Label to display the winning structure image
		lblWinningStructure = new JLabel();
		lblWinningStructure.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon originalIcon = new ImageIcon(Window.class.getResource("/assets/winning_structure.png"));
		Image originalImage = originalIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(380, 200,  Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		lblWinningStructure.setIcon(resizedIcon);
		lblWinningStructure.setBounds(0, 205, 393, 209);
		getContentPane().add(lblWinningStructure);
		
		btnOK = new JButton("OK"); // Button for closing the guide dialog
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOK.setBounds(167, 412, 58, 29);
		getContentPane().add(btnOK);
	}
}
