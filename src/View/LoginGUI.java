package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LoginGUI extends JFrame {
	
	private boolean loggedin = false;
	private String membershipExpiration = "YYY/MM/DD";
	//need to update
	
	private static final long serialVersionUID = 1L;
	private JTextField searchTime=null;
	private JButton createLoginBtn =null;
	private JButton browseMoviesBtn =null;
	private JButton voucherBtn=null;
	private JButton loginBtn=null;
	private JButton refundBtn=null;
	private JButton logoutBtn=null;
	private JButton renewBtn=null;
	
	private JTextField userNameInput=null;
	private JTextField passwordInput=null;
	private JTextField createPasswordInput=null;
	private JTextField createUserNameInput=null;
	private JTextField voucherCodeInput=null;
	private JTextField registeredVoucherCodeInput=null;
	private JTextField creditCardInput=null;


	public LoginGUI() {
		this.setSize(1000, 600);
		this.setLayout(null);
		this.setLocation(217, 69);
		JPanel titlePanel=new JPanel();
		JLabel title=new JLabel("WELCOME!!!");
		title.setFont(new Font("Courier New", Font.BOLD, 30));
		title.setForeground(Color.WHITE);
		titlePanel.setBounds(0, 0, 1000, 60);
		titlePanel.setBackground(Color.DARK_GRAY);
		titlePanel.add(title,JLabel.CENTER);
		this.add(titlePanel);
		JPanel leftPanel=new JPanel();
		leftPanel.setLayout(null);
		leftPanel.setBounds(0, 60, 500, 400);
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		JLabel searchtitle=new JLabel("Regular User Options");
		searchtitle.setFont(new Font("Courier New", Font.BOLD, 24));
		searchtitle.setBounds(100, 5, 300, 40);
		leftPanel.add(searchtitle);
		
		JLabel registerTxt=new JLabel("Register? (optional)");
		registerTxt.setFont(new Font("Courier New", Font.BOLD, 16));
		registerTxt.setBounds(220, 90, 200, 30);
		leftPanel.add(registerTxt);
		
		
		JLabel createUserNameTxt=new JLabel("Input Email:");
		createUserNameTxt.setFont(new Font("Courier New", Font.BOLD, 15));
		createUserNameTxt.setBounds(50, 115, 150, 30);
		leftPanel.add(createUserNameTxt);
		createUserNameInput=new JTextField();
		createUserNameInput.setBounds(215, 115, 220, 27);
		leftPanel.add(createUserNameInput);
		
		JLabel createPasswordTxt=new JLabel("Create Password:");
		createPasswordTxt.setFont(new Font("Courier New", Font.BOLD, 15));
		createPasswordTxt.setBounds(50, 165, 150, 30);
		leftPanel.add(createPasswordTxt);
		createPasswordInput=new JTextField();
		createPasswordInput.setBounds(215, 165, 220, 27);
		leftPanel.add(createPasswordInput);
		
		JLabel registerCreditCardTxt=new JLabel("Input Credit Card:");
		registerCreditCardTxt.setFont(new Font("Courier New", Font.BOLD, 15));
		registerCreditCardTxt.setBounds(50, 215, 180, 30);
		leftPanel.add(registerCreditCardTxt);
		creditCardInput=new JTextField();
		creditCardInput.setBounds(215, 215, 220, 27);
		leftPanel.add(creditCardInput);
		
		createLoginBtn = new JButton("Create");
		createLoginBtn.setBounds(355, 265, 80, 30);
		leftPanel.add(createLoginBtn);

		
		JLabel voucherTxt=new JLabel("Get Refund (Voucher):");
		voucherTxt.setFont(new Font("Courier New", Font.BOLD, 16));
		voucherTxt.setBounds(50, 415, 250, 30);
		this.add(voucherTxt);

		
		JLabel voucherInput=new JLabel("Ticket Id");
		voucherInput.setFont(new Font("Courier New", Font.BOLD, 13));
		voucherInput.setBounds(385, 330, 250, 30);
		leftPanel.add(voucherInput);
		voucherCodeInput=new JTextField();
		voucherCodeInput.setBounds(380, 355, 80, 30);
		leftPanel.add(voucherCodeInput);
		
		
		voucherBtn = new JButton("Refund");
		voucherBtn.setBounds(260, 355, 80, 30);
		leftPanel.add(voucherBtn);
		this.add(leftPanel);

		
		JPanel rightPanel=new JPanel(); 
		rightPanel.setLayout(null);
		rightPanel.setBounds(500, 60, 485, 401);
		rightPanel.setBorder(BorderFactory.createEtchedBorder());
		JLabel clentTitle=new JLabel("Registered User Options");
		clentTitle.setFont(new Font("Courier New", Font.BOLD, 24));
		clentTitle.setBounds(50, 5, 350, 40);
		rightPanel.add(clentTitle);
		
		JLabel loginTxt=new JLabel("Login? (optional)");
		loginTxt.setFont(new Font("Courier New", Font.BOLD, 16));
		loginTxt.setBounds(170, 90, 200, 30);
		rightPanel.add(loginTxt);
		
		JLabel userNameTxt=new JLabel("Email:");
		userNameTxt.setFont(new Font("Courier New", Font.BOLD, 15));
		userNameTxt.setBounds(50, 115, 120, 30);
		rightPanel.add(userNameTxt);
		userNameInput=new JTextField();
		userNameInput.setBounds(150, 115, 220, 27);
		rightPanel.add(userNameInput);
		
		JLabel passwordTxt=new JLabel("Password:");
		passwordTxt.setFont(new Font("Courier New", Font.BOLD, 15));
		passwordTxt.setBounds(50, 165, 120, 30);
		rightPanel.add(passwordTxt);
		passwordInput=new JTextField();
		passwordInput.setBounds(150, 165, 220, 27);
		rightPanel.add(passwordInput);
		
		JLabel memberShipEndDate = new JLabel("Membership Expires: " + getMembershipExpiration());
		memberShipEndDate.setFont(new Font("Courier New", Font.PLAIN, 13));
		memberShipEndDate.setBounds(50, 265, 250, 30);
		rightPanel.add(memberShipEndDate);
		
		renewBtn = new JButton("Renew");
		renewBtn.setBounds(290, 265, 80, 30);
		rightPanel.add(renewBtn);
		
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(290, 215, 80, 30);
		rightPanel.add(logoutBtn);
		
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(150, 215, 80, 30);
		rightPanel.add(loginBtn);


		JLabel getRefund=new JLabel("Get Full Refund:");
		getRefund.setFont(new Font("Courier New", Font.BOLD, 15));
		getRefund.setBounds(50, 355, 250, 30);
		rightPanel.add(getRefund);
		refundBtn = new JButton("Refund");
		refundBtn.setBounds(195, 355, 80, 30);
		rightPanel.add(refundBtn);
		
		JLabel registeredVoucherInput=new JLabel("Ticket Id");
		registeredVoucherInput.setFont(new Font("Courier New", Font.BOLD, 13));
		registeredVoucherInput.setBounds(320, 330, 250, 30);
		rightPanel.add(registeredVoucherInput);
		registeredVoucherCodeInput=new JTextField();
		registeredVoucherCodeInput.setBounds(315, 355, 80, 30);
		rightPanel.add(registeredVoucherCodeInput);
		
		this.add(rightPanel);
		
		
		
		JPanel bottomPanel=new JPanel(); 
		bottomPanel.setLayout(null);
		bottomPanel.setBounds(0, 459, 985, 103);
		bottomPanel.setBorder(BorderFactory.createEtchedBorder());
		
		JLabel BrowseMovies=new JLabel("Browese Movies:");
		BrowseMovies.setFont(new Font("Courier New", Font.BOLD, 20));
		BrowseMovies.setBounds(250, 50, 250, 30);
		bottomPanel.add(BrowseMovies);
		
		browseMoviesBtn = new JButton("Browse!");
		browseMoviesBtn.setBounds(450, 45, 100, 40);
		bottomPanel.add(browseMoviesBtn);
		
		
		this.add(bottomPanel);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	 


	public void displayErrorMessage (String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
	public static void main(String[] args) {
		//new LoginGUI().init();
	}



	public JTextField getSearchTime() {
		return searchTime;
	}
	
	public JTextField getVoucherCodeInput() {
		return voucherCodeInput;
	}
	
	public JTextField getRegisteredVoucherCodeInput() {
		return registeredVoucherCodeInput;
	}
	
	public JTextField getUserNameInput() {
		return userNameInput;
	}
	
	public JTextField getPasswordInput() {
		return passwordInput;
	}
	
	public JTextField getCreatePasswordInput() {
		return createPasswordInput;
	}
	
	public JTextField getCreateUserNameInput() {
		return createUserNameInput;
	}
	
	public JTextField getCreditCardInput() {
		return creditCardInput;
	}



	public void setSearchTime(JTextField searchTime) {
		this.searchTime = searchTime;
	}



	public JButton getCreateLoginBtn() {
		return createLoginBtn;
	}



	public void setCreateLoginBtn(JButton createLoginBtn) {
		this.createLoginBtn = createLoginBtn;
	}



	public JButton getBrowseMovies() {
		return browseMoviesBtn;
	}



	public void setBrowseMovies(JButton browseMovies) {
		this.browseMoviesBtn = browseMovies;
	}



	public JButton getVoucherBtn() {
		return voucherBtn;
	}



	public void setVoucherBtn(JButton voucherBtn) {
		this.voucherBtn = voucherBtn;
	}



	public JButton getLoginBtn() {
		return loginBtn;
	}
	
	public JButton getLotOutBtn() {
		return logoutBtn;
	}



	public void setLoginBtn(JButton loginBtn) {
		this.loginBtn = loginBtn;
	}



	public boolean isLoggedin() {
		return loggedin;
	}



	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}



	public JButton getRefundBtn() {
		return refundBtn;
	}



	public void setRefundBtn(JButton refundBtn) {
		this.refundBtn = refundBtn;
	}



	public String getMembershipExpiration() {
		return membershipExpiration;
	}



	public void setMembershipExpiration(String membershipExpiration) {
		this.membershipExpiration = membershipExpiration;
	}
}
