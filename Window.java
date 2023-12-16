import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
public class Window extends JFrame{
	private JFrame frmSpeedKino; // The main frame of the application
	private JFrame frame = Window.this; // Reference to the current instance of the window
	
	// Panels for different sections of the window
	private JPanel topPanel;
	private JPanel midPanel;
	private JPanel bottomPanel;
	private JPanel numbersGame;
	private JScrollPane purchaseHistory;
	private JPanel resultPanel;
	private JPanel balancePanel;
	protected JPanel purchaseHistoryPanel;
	
	// Labels for different sections and information
	public JLabel lblSelectedLabel;
	private JPanel numberPad;
	private JLabel barcodeLabel1;
	private JLabel barcodeLabel2;
	private JLabel barcodeLabel3;
	private JLabel barcodeLabel4;
	private JLabel barcodeLabel5;
	private JLabel barcodeLabel6;
	private JLabel barcodeLabel7;
	private JLabel barcodeLabel8;
	private JLabel barcodeLabel9;
	private JLabel barcodeLabel10;
	private JLabel barcodeLabel11;
	private JLabel barcodeLabel12;
	private JLabel barcodeLabel13;
	private JLabel barcodeLabel14;
	private JLabel barcodeLabel15;
	private JLabel barcodeLabel16;
	private JLabel lblGameTitle;
	
	// Buttons for the game.
	private JButton btnOne;
	private JButton btnTwo;
	private JButton btnThree;
	private JButton btnFour;
	private JButton btnFive;
	private JButton btnSix;
	private JButton btnSeven;
	private JButton btnEight;
	private JButton btnNine;
	private JButton btnTen;
	private JButton btnEleven;
	private JButton btnTwelve;
	private JButton btnThirteen;
	private JButton btnFourteen;
	private JButton btnFifteen;
	private JButton btnSixteen;
	private JButton btnSeventeen;
	private JButton btnEighteen;
	private JButton btnNineteen;
	private JButton btnTwenty;
	private JButton btnTwentyTwo;
	private JButton btnTwentyOne;
	private JButton btnTwentyThree;
	private JButton btnTwentyFive;
	private JButton btnTwentySix;
	private JButton btnTwentyEight;
	private JButton btnThirty;
	private JButton btnTwentyFour;
	private JButton btnTwentyNine;
	private JButton btnThirtyOne;
	private JButton btnTwentySeven;
	private JButton btnThirtyTwo;
	private JButton btnThirtyThree;
	private JButton btnThirtyFour;
	private JButton btnThirtyFive;
	private JButton btnThirtySix;
	private JButton btnFortyOne;
	private JButton btnForty;
	private JButton btnThirtyNine;
	private JButton btnThirtyEight;
	private JButton btnThirtySeven;
	private JButton btnFortyThree;
	private JButton btnFortyTwo;
	private JButton btnFortyFour;
	private JButton btnFortyFive;
	private JButton btnFortySix;
	private JButton btnFortySeven;
	private JButton btnFortyEight;
	private JButton btnFifty;
	private JButton btnFortyNine;
	private JButton btnFiftyOne;
	private JButton btnFiftyTwo;
	private JButton btnFiftyThree;
	private JButton btnFiftyFour;
	private JButton btnFiftyFive;
	private JButton btnFiftySeven;
	private JButton btnFiftySix;
	private JButton btnFiftyEight;
	private JButton btnFiftyNine;
	private JButton btnSixty;
	private JButton btnSixtyOne;
	private JButton btnSixtyTwo;
	private JButton btnSixtyFour;
	private JButton btnSixtyThree;
	private JButton btnSixtyFive;
	private JButton btnSixtySix;
	private JButton btnSixtySeven;
	private JButton btnSixtyEight;
	private JButton btnSixtyNine;
	private JButton btnSeventy;
	
	private JLabel lblPurchaseHistory; // Label for purchase history
	private JLabel lblWinningNumberTitle; // Label for the winning number title
	private JLabel lblBalacneTitle; // Label for the balance title
	private JLabel lblLogo; // Label for the logo
	private JLabel lblGuide; // Label for the guide
	protected JLabel lblTimer; // Label for the timer
	protected JLabel lblWinningNumber; // Label for the winning number
	protected JLabel lblBalance; // Label for the balance
	
	protected JButton btnCharge; // Button for charging the balance
	protected JPasswordField passwordField; // Password field for login
	protected JTextField idField; // Text field for user ID
	protected JButton btnSignIn; // Button for signing in
	protected JButton btnSignUp; // Button for signing up
	protected JLabel lblPassword; // Label for the password field
	protected JLabel lblID; // Label for the ID field
	protected JLabel lblGreeting; // Label for the greeting message
	
	private JButton btnGuide; // Button for the guide
	protected JButton btnSave; // Button for saving
	protected JButton btnPurchase; // Button for making a purchase
	protected JButton btnClear; // Button for clearing selections

	private String password; // String to store password
	protected GameTimer timer; // Timer for the game
	protected User user; // User object for the current user
	protected Balance balance; // Balance object for the user's balance
	protected int historyCount; // Counter for the purchase history
	protected ArrayList<JLabel> historys; // List of labels for history entries
	protected WinningPrize winningStructure; // WinningPrize object for handling prizes
	
	// Static lists for buttons and numbers
	protected static List<JButton> numberButtons = new ArrayList<>(); // List of buttons for number selection
	protected static ArrayList<String> numbers = new ArrayList<>(); // List of selected numbers
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmSpeedKino.setVisible(true);
					window.frmSpeedKino.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
     * Creates the application and initializes the GUI components.
     */
	public Window() {
		initialize();
		makeNumbersGame();
		makeBalance();
		makeLogin();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpeedKino = new JFrame(); // Creating the main frame
		ImageIcon icon = new ImageIcon("/assets/title_logo.png"); // Loading the application icon
        Image image = icon.getImage();
        frmSpeedKino.setIconImage(image);
		
		frmSpeedKino.setTitle("Speed Kino"); // Setting the title of the frame
		frmSpeedKino.setBounds(100, 100, 900, 600);
		frmSpeedKino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpeedKino.getContentPane().setLayout(new BoxLayout(frmSpeedKino.getContentPane(), BoxLayout.Y_AXIS));
		
		// Setting up the top panel
		topPanel = new JPanel();
		topPanel.setBackground(new Color(31, 55, 134));
		frmSpeedKino.getContentPane().add(topPanel);
		topPanel.setPreferredSize(new Dimension(900,80));
		topPanel.setLayout(null);
		
		// Adding logo to the top panel
		lblLogo = new JLabel("");
		ImageIcon originalIcon = new ImageIcon(Window.class.getResource("/assets/title_logo.png"));
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(90, 70, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		lblLogo.setIcon(scaledIcon);
		lblLogo.setBounds(10, 5, 94, 71);
		topPanel.add(lblLogo);
		
		// Adding guide label to the top panel
		lblGuide = new JLabel("Choose your 10 lucky numbers!");
		lblGuide.setForeground(new Color(254, 255, 255));
		lblGuide.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblGuide.setBounds(112, 5, 483, 64);
		topPanel.add(lblGuide);
		
		// Adding save button to the top panel
		btnSave = new JButton("Save");
		btnSave.setEnabled(false);
		btnSave.setBounds(765, 25, 104, 29);
		btnSave.addActionListener(new Save(this));
		topPanel.add(btnSave);
		
		// Adding timer label to the top panel
		lblTimer = new JLabel("03:00");
		lblTimer.setForeground(new Color(255, 255, 255));
		lblTimer.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblTimer.setBounds(616, 22, 125, 34);
		topPanel.add(lblTimer);
		
		// Setting up the middle of the panel
		midPanel = new JPanel();
		midPanel.setBackground(new Color(52, 53, 60));
		frmSpeedKino.getContentPane().add(midPanel);
		midPanel.setPreferredSize(new Dimension(900,440));
		midPanel.setLayout(null);
		
		// Setting up the panel for displaying purchase history
		purchaseHistoryPanel = new JPanel();
		purchaseHistoryPanel.setBackground(new Color(255, 255, 255));
        purchaseHistoryPanel.setLayout(new BoxLayout(purchaseHistoryPanel, BoxLayout.Y_AXIS));
        
        // Setting up the scroll pane for purchase history
		purchaseHistory = new JScrollPane(purchaseHistoryPanel);
		purchaseHistory.setBounds(562, 26, 316, 314);
		midPanel.add(purchaseHistory);
		
		// Creating and configuring the label for purchase history
		lblPurchaseHistory = new JLabel("Purchase History");
		lblPurchaseHistory.setBackground(new Color(255, 255, 255));
		lblPurchaseHistory.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPurchaseHistory.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseHistory.setColumnHeaderView(lblPurchaseHistory);
		
		// Setting up the panel for displaying winning numbers
		resultPanel = new JPanel();
		resultPanel.setBounds(562, 348, 316, 67);
		midPanel.add(resultPanel);
		GridBagLayout gbl_resultPanel = new GridBagLayout();
		resultPanel.setLayout(gbl_resultPanel);
		
		// Creating and configuring the label for the winning number title
		lblWinningNumberTitle = new JLabel("Winning Number");
		lblWinningNumberTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblWinningNumberTitle.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblWinningNumberTitle = new GridBagConstraints();
		gbc_lblWinningNumberTitle.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblWinningNumberTitle.gridx = 0;
		gbc_lblWinningNumberTitle.gridy = 0;
		gbc_lblWinningNumberTitle.weightx = 1;
		gbc_lblWinningNumberTitle.weighty = 1;
		gbc_lblWinningNumberTitle.fill = GridBagConstraints.BOTH;
		resultPanel.add(lblWinningNumberTitle, gbc_lblWinningNumberTitle);
		
		// Creating and configuring the label for displaying the winning number
		lblWinningNumber = new JLabel("");
		lblWinningNumber.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblWinningNumber = new GridBagConstraints();
		gbc_lblWinningNumber.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblWinningNumber.gridx = 0;
		gbc_lblWinningNumber.gridy = 1;
		gbc_lblWinningNumber.weightx = 1;
		gbc_lblWinningNumber.weighty = 3;
		gbc_lblWinningNumber.fill = GridBagConstraints.BOTH;
		resultPanel.add(lblWinningNumber, gbc_lblWinningNumber);
		
		// Setting up the bottom panel
		bottomPanel = new JPanel();
		bottomPanel.setBackground(new Color(51, 53, 59));
		frmSpeedKino.getContentPane().add(bottomPanel);
		bottomPanel.setPreferredSize(new Dimension(900,80));
		bottomPanel.setLayout(null);
	}
	
	/**
	 * Sets up the login section of the application.
	 */
	private void makeLogin() {
		// Creating and setting the ID label
		lblID = new JLabel("ID");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setForeground(new Color(254, 255, 255));
		lblID.setBounds(44, 10, 61, 16);
		bottomPanel.add(lblID);
		
		// Creating and setting the ID text field
		idField = new JTextField();
		idField.setBounds(109, 6, 130, 26);
		bottomPanel.add(idField);
		idField.setColumns(10);
		
		// Creating and setting the password label
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(254, 255, 255));
		lblPassword.setBounds(44, 32, 61, 16);
		bottomPanel.add(lblPassword);
		
		// Creating and setting the password field
		passwordField = new JPasswordField();
		passwordField.setBounds(109, 28, 130, 26);
		bottomPanel.add(passwordField);
		passwordField.setColumns(10);
		
		// Creating and configuring the Sign In button
		btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new SignIn(this));
		btnSignIn.setBounds(260, 15, 88, 29);
		bottomPanel.add(btnSignIn);
		
		// Creating and configuring the Sign Up button
		btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUp signUp = new SignUp(frame);
				signUp.setVisible(true);
			}
		});
		btnSignUp.setBounds(346, 15, 88, 29);
		bottomPanel.add(btnSignUp);	
		
		// Creating and setting the greeting label
		lblGreeting = new JLabel("");
		lblGreeting.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblGreeting.setForeground(new Color(255, 255, 255));
		lblGreeting.setHorizontalAlignment(SwingConstants.CENTER);
		lblGreeting.setBounds(70, 10, 428, 29);
		bottomPanel.add(lblGreeting);
	}
	
	/**
	 * Sets up the balance display and charge button in the application.
	 */
	private void makeBalance() {
		// Creating and setting the balance panel
		balancePanel = new JPanel();
		balancePanel.setBackground(new Color(51, 53, 59));
		balancePanel.setBounds(656, 6, 198, 52);
		bottomPanel.add(balancePanel);
		balancePanel.setLayout(new BorderLayout(0, 0));
		
		// Creating and setting the balance title label
		lblBalacneTitle = new JLabel("Balance:");
		lblBalacneTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblBalacneTitle.setForeground(new Color(254, 255, 255));
		balancePanel.add(lblBalacneTitle);
		
		// Creating and setting the balance label
		lblBalance = new JLabel("0 Won");
		lblBalance.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblBalance.setForeground(new Color(254, 255, 255));
		balancePanel.add(lblBalance, BorderLayout.EAST);
		
		// Creating and configuring the Charge button
		btnCharge = new JButton("Charge");
		btnCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				balance.freeCharge();
			}
		});
		btnCharge.setEnabled(false);
		btnCharge.setBounds(568, 18, 88, 29);
		bottomPanel.add(btnCharge);
	}
	
	/**
	 * Creates and configures the numbers game interface components.
	 */
	private void makeNumbersGame() {
		// Creating and configuring the main panel for the numbers game
		numbersGame = new JPanel();
		numbersGame.setBackground(new Color(254, 255, 255));
		numbersGame.setBorder(new MatteBorder(3, 0, 3, 3, new Color(234, 56, 110)));
		numbersGame.setBounds(31, 26, 509, 343);
		midPanel.add(numbersGame);
		numbersGame.setLayout(null);
		
		// Creating and configuring the number pad panel
		numberPad = new JPanel();
		numberPad.setBackground(new Color(254, 255, 255));
		numberPad.setBorder(new LineBorder(new Color(234, 56, 110), 2));
		numberPad.setBounds(20, 20, 469, 306);
		numbersGame.add(numberPad);
		numberPad.setLayout(new GridLayout(7, 10, 0, 0));
		
		// Creating and configuring the label for displaying the number of selected numbers
		lblSelectedLabel = new JLabel("Number of selected numbers: 0");
		lblSelectedLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblSelectedLabel.setForeground(new Color(254, 255, 255));
		lblSelectedLabel.setBounds(31, 386, 240, 16);
		midPanel.add(lblSelectedLabel);
		
		// Creating and adding number buttons to the number pad
	    // Each button is configured with an action listener for the number selection functionality
	    // The following creates buttons from 1 to 70 and adds them to the number pad
		btnOne = new JButton("1");
		btnOne.setBackground(new Color(254, 255, 255));
		btnOne.addActionListener(new NumberButton(btnOne, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnOne);
		
		btnTwo = new JButton("2");
		btnTwo.setBackground(new Color(254, 255, 255));
		btnTwo.addActionListener(new NumberButton(btnTwo, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnTwo);
		
		btnThree = new JButton("3");
		btnThree.setBackground(new Color(254, 255, 255));
		btnThree.addActionListener(new NumberButton(btnThree, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnThree);
		
		btnFour = new JButton("4");
		btnFour.setBackground(new Color(254, 255, 255));
		btnFour.addActionListener(new NumberButton(btnFour, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFour);
		
		btnFive = new JButton("5");
		btnFive.setBackground(new Color(254, 255, 255));
		btnFive.addActionListener(new NumberButton(btnFive, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFive);
		
		btnSix = new JButton("6");
		btnSix.setBackground(new Color(254, 255, 255));
		btnSix.addActionListener(new NumberButton(btnSix, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnSix);
		
		btnSeven = new JButton("7");
		btnSeven.setBackground(new Color(254, 255, 255));
		btnSeven.addActionListener(new NumberButton(btnSeven, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnSeven);
		
		btnEight = new JButton("8");
		btnEight.setBackground(new Color(254, 255, 255));
		btnEight.addActionListener(new NumberButton(btnEight, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnEight);
		
		btnNine = new JButton("9");
		btnNine.setBackground(new Color(254, 255, 255));
		btnNine.addActionListener(new NumberButton(btnNine, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnNine);
		
		btnTen = new JButton("10");
		btnTen.setBackground(new Color(254, 255, 255));
		btnTen.addActionListener(new NumberButton(btnTen, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnTen);
		
		btnEleven = new JButton("11");
		btnEleven.setBackground(new Color(254, 255, 255));
		btnEleven.addActionListener(new NumberButton(btnEleven, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnEleven);
		
		btnTwelve = new JButton("12");
		btnTwelve.setBackground(new Color(254, 255, 255));
		btnTwelve.addActionListener(new NumberButton(btnTwelve, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnTwelve);
		
		btnThirteen = new JButton("13");
		btnThirteen.setBackground(new Color(254, 255, 255));
		btnThirteen.addActionListener(new NumberButton(btnThirteen, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnThirteen);
		
		btnFourteen = new JButton("14");
		btnFourteen.setBackground(new Color(254, 255, 255));
		btnFourteen.addActionListener(new NumberButton(btnFourteen, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFourteen);
		
		btnFifteen = new JButton("15");
		btnFifteen.setBackground(new Color(254, 255, 255));
		btnFifteen.addActionListener(new NumberButton(btnFifteen, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFifteen);
		
		btnSixteen = new JButton("16");
		btnSixteen.setBackground(new Color(254, 255, 255));
		btnSixteen.addActionListener(new NumberButton(btnSixteen, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnSixteen);
		
		btnSeventeen = new JButton("17");
		btnSeventeen.setBackground(new Color(254, 255, 255));
		btnSeventeen.addActionListener(new NumberButton(btnSeventeen, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnSeventeen);
		
		btnEighteen = new JButton("18");
		btnEighteen.setBackground(new Color(254, 255, 255));
		btnEighteen.addActionListener(new NumberButton(btnEighteen, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnEighteen);
		
		btnNineteen = new JButton("19");
		btnNineteen.setBackground(new Color(254, 255, 255));
		btnNineteen.addActionListener(new NumberButton(btnNineteen, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnNineteen);
		
		btnTwenty = new JButton("20");
		btnTwenty.setBackground(new Color(254, 255, 255));
		btnTwenty.addActionListener(new NumberButton(btnTwenty, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnTwenty);
		
		btnTwentyOne = new JButton("21");
		btnTwentyOne.setBackground(new Color(254, 255, 255));
		btnTwentyOne.addActionListener(new NumberButton(btnTwentyOne, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnTwentyOne);
		
		btnTwentyTwo = new JButton("22");
		btnTwentyTwo.setBackground(new Color(254, 255, 255));
		btnTwentyTwo.addActionListener(new NumberButton(btnTwentyTwo, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnTwentyTwo);
		
		btnTwentyThree = new JButton("23");
		btnTwentyThree.setBackground(new Color(254, 255, 255));
		btnTwentyThree.addActionListener(new NumberButton(btnTwentyThree, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnTwentyThree);
		
		btnTwentyFour = new JButton("24");
		btnTwentyFour.setBackground(new Color(254, 255, 255));
		btnTwentyFour.addActionListener(new NumberButton(btnTwentyFour, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnTwentyFour);
		
		btnTwentyFive = new JButton("25");
		btnTwentyFive.setBackground(new Color(254, 255, 255));
		btnTwentyFive.addActionListener(new NumberButton(btnTwentyFive, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnTwentyFive);
		
		btnTwentySix = new JButton("26");
		btnTwentySix.setBackground(new Color(254, 255, 255));
		btnTwentySix.addActionListener(new NumberButton(btnTwentySix, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnTwentySix);
		
		btnTwentySeven = new JButton("27");
		btnTwentySeven.setBackground(new Color(254, 255, 255));
		btnTwentySeven.addActionListener(new NumberButton(btnTwentySeven, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnTwentySeven);
		
		btnTwentyEight = new JButton("28");
		btnTwentyEight.setBackground(new Color(254, 255, 255));
		btnTwentyEight.addActionListener(new NumberButton(btnTwentyEight, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnTwentyEight);
		
		btnTwentyNine = new JButton("29");
		btnTwentyNine.setBackground(new Color(254, 255, 255));
		btnTwentyNine.addActionListener(new NumberButton(btnTwentyNine, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnTwentyNine);
		
		btnThirty = new JButton("30");
		btnThirty.setBackground(new Color(254, 255, 255));
		btnThirty.addActionListener(new NumberButton(btnThirty, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnThirty);
		
		btnThirtyOne = new JButton("31");
		btnThirtyOne.setBackground(new Color(254, 255, 255));
		btnThirtyOne.addActionListener(new NumberButton(btnThirtyOne, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnThirtyOne);
		
		btnThirtyTwo = new JButton("32");
		btnThirtyTwo.setBackground(new Color(254, 255, 255));
		btnThirtyTwo.addActionListener(new NumberButton(btnThirtyTwo, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnThirtyTwo);
		
		btnThirtyThree = new JButton("33");
		btnThirtyThree.setBackground(new Color(254, 255, 255));
		btnThirtyThree.addActionListener(new NumberButton(btnThirtyThree, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnThirtyThree);
		
		btnThirtyFour = new JButton("34");
		btnThirtyFour.setBackground(new Color(254, 255, 255));
		btnThirtyFour.addActionListener(new NumberButton(btnThirtyFour, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnThirtyFour);
		
		btnThirtyFive = new JButton("35");
		btnThirtyFive.setBackground(new Color(254, 255, 255));
		btnThirtyFive.addActionListener(new NumberButton(btnThirtyFive, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnThirtyFive);
		
		btnThirtySix = new JButton("36");
		btnThirtySix.setBackground(new Color(254, 255, 255));
		btnThirtySix.addActionListener(new NumberButton(btnThirtySix, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnThirtySix);
		
		btnThirtySeven = new JButton("37");
		btnThirtySeven.setBackground(new Color(254, 255, 255));
		btnThirtySeven.addActionListener(new NumberButton(btnThirtySeven, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnThirtySeven);
		
		btnThirtyEight = new JButton("38");
		btnThirtyEight.setBackground(new Color(254, 255, 255));
		btnThirtyEight.addActionListener(new NumberButton(btnThirtyEight, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnThirtyEight);
		
		btnThirtyNine = new JButton("39");
		btnThirtyNine.setBackground(new Color(254, 255, 255));
		btnThirtyNine.addActionListener(new NumberButton(btnThirtyNine, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnThirtyNine);
		
		btnForty = new JButton("40");
		btnForty.setBackground(new Color(254, 255, 255));
		btnForty.addActionListener(new NumberButton(btnForty, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnForty);
		
		btnFortyOne = new JButton("41");
		btnFortyOne.setBackground(new Color(254, 255, 255));
		btnFortyOne.addActionListener(new NumberButton(btnFortyOne, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFortyOne);
		
		btnFortyTwo = new JButton("42");
		btnFortyTwo.setBackground(new Color(254, 255, 255));
		btnFortyTwo.addActionListener(new NumberButton(btnFortyTwo, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFortyTwo);
		
		btnFortyThree = new JButton("43");
		btnFortyThree.setBackground(new Color(254, 255, 255));
		btnFortyThree.addActionListener(new NumberButton(btnFortyThree, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFortyThree);
		
		btnFortyFour = new JButton("44");
		btnFortyFour.setBackground(new Color(254, 255, 255));
		btnFortyFour.addActionListener(new NumberButton(btnFortyFour, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFortyFour);
		
		btnFortyFive = new JButton("45");
		btnFortyFive.setBackground(new Color(254, 255, 255));
		btnFortyFive.addActionListener(new NumberButton(btnFortyFive, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFortyFive);
		
		btnFortySix = new JButton("46");
		btnFortySix.setBackground(new Color(254, 255, 255));
		btnFortySix.addActionListener(new NumberButton(btnFortySix, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFortySix);
		
		btnFortySeven = new JButton("47");
		btnFortySeven.setBackground(new Color(254, 255, 255));
		btnFortySeven.addActionListener(new NumberButton(btnFortySeven, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFortySeven);
		
		btnFortyEight = new JButton("48");
		btnFortyEight.setBackground(new Color(254, 255, 255));
		btnFortyEight.addActionListener(new NumberButton(btnFortyEight, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFortyEight);
		
		btnFortyNine = new JButton("49");
		btnFortyNine.setBackground(new Color(254, 255, 255));
		btnFortyNine.addActionListener(new NumberButton(btnFortyNine, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFortyNine);
		
		btnFifty = new JButton("50");
		btnFifty.setBackground(new Color(254, 255, 255));
		btnFifty.addActionListener(new NumberButton(btnFifty, lblSelectedLabel, numbers, numberButtons));
		
		btnFiftyOne = new JButton("51");
		btnFiftyOne.setBackground(new Color(254, 255, 255));
		btnFiftyOne.addActionListener(new NumberButton(btnFiftyOne, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFiftyOne);
		
		btnFiftyTwo = new JButton("52");
		btnFiftyTwo.setBackground(new Color(254, 255, 255));
		btnFiftyTwo.addActionListener(new NumberButton(btnFiftyTwo, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFiftyTwo);
		
		btnFiftyThree = new JButton("53");
		btnFiftyThree.setBackground(new Color(254, 255, 255));
		btnFiftyThree.addActionListener(new NumberButton(btnFiftyThree, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFiftyThree);
		
		btnFiftyFour = new JButton("54");
		btnFiftyFour.setBackground(new Color(254, 255, 255));
		btnFiftyFour.addActionListener(new NumberButton(btnFiftyFour, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFiftyFour);
		
		btnFiftyFive = new JButton("55");
		btnFiftyFive.setBackground(new Color(254, 255, 255));
		btnFiftyFive.addActionListener(new NumberButton(btnFiftyFive, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFiftyFive);
		
		btnFiftySix = new JButton("56");
		btnFiftySix.setBackground(new Color(254, 255, 255));
		btnFiftySix.addActionListener(new NumberButton(btnFiftySix, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFiftySix);
		
		btnFiftySeven = new JButton("57");
		btnFiftySeven.setBackground(new Color(254, 255, 255));
		btnFiftySeven.addActionListener(new NumberButton(btnFiftySeven, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFiftySeven);
		
		btnFiftyEight = new JButton("58");
		btnFiftyEight.setBackground(new Color(254, 255, 255));
		btnFiftyEight.addActionListener(new NumberButton(btnFiftyEight, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFiftyEight);
		
		btnFiftyNine = new JButton("59");
		btnFiftyNine.setBackground(new Color(254, 255, 255));
		btnFiftyNine.addActionListener(new NumberButton(btnFiftyNine, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnFiftyNine);
		
		btnSixty = new JButton("60");
		btnSixty.setBackground(new Color(254, 255, 255));
		btnSixty.addActionListener(new NumberButton(btnSixty, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnSixty);
		
		btnSixtyOne = new JButton("61");
		btnSixtyOne.setBackground(new Color(254, 255, 255));
		btnSixtyOne.addActionListener(new NumberButton(btnSixtyOne, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnSixtyOne);
		
		btnSixtyTwo = new JButton("62");
		btnSixtyTwo.setBackground(new Color(254, 255, 255));
		btnSixtyTwo.addActionListener(new NumberButton(btnSixtyTwo, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnSixtyTwo);
		
		btnSixtyThree = new JButton("63");
		btnSixtyThree.setBackground(new Color(254, 255, 255));
		btnSixtyThree.addActionListener(new NumberButton(btnSixtyThree, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnSixtyThree);
		
		btnSixtyFour = new JButton("64");
		btnSixtyFour.setBackground(new Color(254, 255, 255));
		btnSixtyFour.addActionListener(new NumberButton(btnSixtyFour, lblSelectedLabel, numbers, numberButtons));
		
		btnSixtyFive = new JButton("65");
		btnSixtyFive.setBackground(new Color(254, 255, 255));
		btnSixtyFive.addActionListener(new NumberButton(btnSixtyFive, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnSixtyFive);
		
		btnSixtySix = new JButton("66");
		btnSixtySix.setBackground(new Color(254, 255, 255));
		btnSixtySix.addActionListener(new NumberButton(btnSixtySix, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnSixtySix);
		
		btnSixtySeven = new JButton("67");
		btnSixtySeven.setBackground(new Color(254, 255, 255));
		btnSixtySeven.addActionListener(new NumberButton(btnSixtySeven, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnSixtySeven);
		
		btnSixtyEight = new JButton("68");
		btnSixtyEight.setBackground(new Color(254, 255, 255));
		btnSixtyEight.addActionListener(new NumberButton(btnSixtyEight, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnSixtyEight);
		
		btnSixtyNine = new JButton("69");
		btnSixtyNine.setBackground(new Color(254, 255, 255));
		btnSixtyNine.addActionListener(new NumberButton(btnSixtyNine, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnSixtyNine);
		
		btnSeventy = new JButton("70");
		btnSeventy.setBackground(new Color(254, 255, 255));
		btnSeventy.addActionListener(new NumberButton(btnSeventy, lblSelectedLabel, numbers, numberButtons));
		numberPad.add(btnSeventy);
		
		// Creating and configuring bar code labels as part of the game's visual design
		barcodeLabel1 = new JLabel("");
		barcodeLabel1.setBackground(new Color(0, 0, 0));
		barcodeLabel1.setOpaque(true);
		barcodeLabel1.setBounds(0, 20, 10, 5);
		numbersGame.add(barcodeLabel1);
		
		barcodeLabel2 = new JLabel("");
		barcodeLabel2.setOpaque(true);
		barcodeLabel2.setBackground(Color.BLACK);
		barcodeLabel2.setBounds(0, 83, 10, 5);
		numbersGame.add(barcodeLabel2);
		
		barcodeLabel3 = new JLabel("");
		barcodeLabel3.setOpaque(true);
		barcodeLabel3.setBackground(Color.BLACK);
		barcodeLabel3.setBounds(0, 100, 10, 5);
		numbersGame.add(barcodeLabel3);
		
		barcodeLabel4 = new JLabel("");
		barcodeLabel4.setOpaque(true);
		barcodeLabel4.setBackground(Color.BLACK);
		barcodeLabel4.setBounds(0, 117, 10, 5);
		numbersGame.add(barcodeLabel4);
		
		barcodeLabel5 = new JLabel("");
		barcodeLabel5.setOpaque(true);
		barcodeLabel5.setBackground(Color.BLACK);
		barcodeLabel5.setBounds(0, 134, 10, 5);
		numbersGame.add(barcodeLabel5);
		
		barcodeLabel6 = new JLabel("");
		barcodeLabel6.setOpaque(true);
		barcodeLabel6.setBackground(Color.BLACK);
		barcodeLabel6.setBounds(0, 151, 10, 5);
		numbersGame.add(barcodeLabel6);
		
		barcodeLabel7 = new JLabel("");
		barcodeLabel7.setOpaque(true);
		barcodeLabel7.setBackground(Color.BLACK);
		barcodeLabel7.setBounds(0, 168, 10, 5);
		numbersGame.add(barcodeLabel7);
		
		barcodeLabel8 = new JLabel("");
		barcodeLabel8.setOpaque(true);
		barcodeLabel8.setBackground(Color.BLACK);
		barcodeLabel8.setBounds(0, 185, 10, 5);
		numbersGame.add(barcodeLabel8);
		
		barcodeLabel9 = new JLabel("");
		barcodeLabel9.setOpaque(true);
		barcodeLabel9.setBackground(Color.BLACK);
		barcodeLabel9.setBounds(0, 202, 10, 5);
		numbersGame.add(barcodeLabel9);
		
		barcodeLabel10 = new JLabel("");
		barcodeLabel10.setOpaque(true);
		barcodeLabel10.setBackground(Color.BLACK);
		barcodeLabel10.setBounds(0, 219, 10, 5);
		numbersGame.add(barcodeLabel10);
		
		barcodeLabel11 = new JLabel("");
		barcodeLabel11.setOpaque(true);
		barcodeLabel11.setBackground(Color.BLACK);
		barcodeLabel11.setBounds(0, 236, 10, 5);
		numbersGame.add(barcodeLabel11);
		
		barcodeLabel12 = new JLabel("");
		barcodeLabel12.setOpaque(true);
		barcodeLabel12.setBackground(Color.BLACK);
		barcodeLabel12.setBounds(0, 253, 10, 5);
		numbersGame.add(barcodeLabel12);
		
		barcodeLabel13 = new JLabel("");
		barcodeLabel13.setOpaque(true);
		barcodeLabel13.setBackground(Color.BLACK);
		barcodeLabel13.setBounds(0, 270, 10, 5);
		numbersGame.add(barcodeLabel13);
		
		barcodeLabel14 = new JLabel("");
		barcodeLabel14.setOpaque(true);
		barcodeLabel14.setBackground(Color.BLACK);
		barcodeLabel14.setBounds(0, 287, 10, 5);
		numbersGame.add(barcodeLabel14);
		
		barcodeLabel15 = new JLabel("");
		barcodeLabel15.setOpaque(true);
		barcodeLabel15.setBackground(Color.BLACK);
		barcodeLabel15.setBounds(0, 304, 10, 5);
		numbersGame.add(barcodeLabel15);
		
		barcodeLabel16 = new JLabel("");
		barcodeLabel16.setOpaque(true);
		barcodeLabel16.setBackground(Color.BLACK);
		barcodeLabel16.setBounds(0, 321, 10, 5);
		numbersGame.add(barcodeLabel16);
		
		lblGameTitle = new JLabel("Numbers Game");
		lblGameTitle.setBounds(21, 5, 96, 16);
		numbersGame.add(lblGameTitle);
		
		// Creating and setting up the Guide button
		btnGuide = new JButton("Guide");
		btnGuide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Guide guide = new Guide(frame);
				guide.setVisible(true);
			}
		});
		
		btnGuide.setBounds(260, 381, 89, 29);
		midPanel.add(btnGuide);
		
		// Creating and setting up the Clear button
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numberButtons.size() != 0 && numbers.size() != 0) { // Clearing the selection when the Clear button is pressed
					numbers.clear();
					NumberButton.setSelectedCount(0);
					lblSelectedLabel.setText("Number of selected numbers: " + NumberButton.getSelectedCount());
					for(JButton button: numberButtons) {
						button.setBackground(new Color(254, 255, 255)); // original color
					}
					numberButtons.clear();
				}
			}
		});
		btnClear.setBounds(345, 381, 100, 29);
		btnClear.setEnabled(false);
		midPanel.add(btnClear);
		
		// Creating and setting up the Purchase button
		btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new PurchaseButton(this));
		btnPurchase.setBounds(440, 381, 100, 29);
		btnPurchase.setEnabled(false);
		midPanel.add(btnPurchase);
	}
	
	/**
	 * Gets the password entered in the password field.
	 *
	 * @return The password as a String.
	 */
	public String getPassword() {
		char[] passwordCharArray = passwordField.getPassword();
		password = new String(passwordCharArray);
		java.util.Arrays.fill(passwordCharArray, '0');
		return password;
	}
	
	/**
	 * Gets the ID entered in the ID text field.
	 *
	 * @return The ID as a String.
	 */
	public String getId() {
		return idField.getText();
	}
}
