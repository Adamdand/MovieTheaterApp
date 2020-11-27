package TheaterGUI;

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
	
	private static final long serialVersionUID = 1L;
	private JRadioButton toolIdAdo =null;
	private JRadioButton toolNameAdo=null;
	private JTextField searchTime=null;
	private JButton createLoginBtn =null;
	private JButton browseMovies =null;
	private JButton voucherBtn=null;
	private JButton loginBtn=null;
	private JTextField userNameInput=null;
	private JTextField passwordInput=null;
	private JTextField createPasswordInput=null;
	private JTextField createUserNameInput=null;
	private JLabel dataCountTip=null;
	private JList<String> dataListBox = null;

	public void init() {
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
		
		
		ButtonGroup radioGrupu = new ButtonGroup();
		radioGrupu.add(toolIdAdo);
		radioGrupu.add(toolNameAdo);
		
		JLabel createUserNameTxt=new JLabel("Create UserName:");
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
		
		JButton createLoginBtn = new JButton("Create");
		createLoginBtn.setBounds(355, 215, 80, 30);
		leftPanel.add(createLoginBtn);
		createLoginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//new SeatSelectionGUI().init();
				//this.setVisible(false);
				
				
				//make a JList for movie display

			}
		});
		

		
		JLabel voucherTxt=new JLabel("Get Refund (Voucher):");
		voucherTxt.setFont(new Font("Courier New", Font.BOLD, 16));
		voucherTxt.setBounds(50, 390, 250, 30);
		this.add(voucherTxt);
		this.add(leftPanel);
		
		JButton voucherBtn = new JButton("Refund");
		voucherBtn.setBounds(260, 330, 80, 30);
		leftPanel.add(voucherBtn);
		voucherBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//new SeatSelectionGUI().init();
				//this.setVisible(false);
				
				
				//make a JList for movie display

			}
		});
		
		

		
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
		
		JLabel userNameTxt=new JLabel("UserName:");
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
		
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(290, 215, 80, 30);
		rightPanel.add(loginBtn);
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//new SeatSelectionGUI().init();
				//this.setVisible(false);
				
				
				//make a JList for movie display

			}
		});

		JLabel getRefund=new JLabel("Get Full Refund:");
		getRefund.setFont(new Font("Courier New", Font.BOLD, 15));
		getRefund.setBounds(50, 330, 250, 30);
		rightPanel.add(getRefund);
		JButton refundBtn = new JButton("Refund");
		refundBtn.setBounds(195, 330, 80, 30);
		rightPanel.add(refundBtn);
		refundBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//new SeatSelectionGUI().init();
				//this.setVisible(false);
				
				
				//make a JList for movie display

			}
		});
		
		this.add(rightPanel);
		
		
		
		JPanel bottomPanel=new JPanel(); 
		bottomPanel.setLayout(null);
		bottomPanel.setBounds(0, 459, 985, 103);
		bottomPanel.setBorder(BorderFactory.createEtchedBorder());
		
		JLabel BrowseMovies=new JLabel("Browese Movies:");
		BrowseMovies.setFont(new Font("Courier New", Font.BOLD, 20));
		BrowseMovies.setBounds(250, 50, 250, 30);
		bottomPanel.add(BrowseMovies);
		
		JButton browseMovies = new JButton("Browse!");
		browseMovies.setBounds(450, 45, 100, 40);
		bottomPanel.add(browseMovies);
		browseMovies.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TheaterGUI().init();
				//this.setVisible(false);
				
				
				//make a JList for movie display

			}
		});
		
		
		this.add(bottomPanel);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	 
	public void searchListener(ActionListener actionListener) {
		searchBtn.addActionListener(actionListener);
	}
	
	public void addQueryAllListener(ActionListener actionListener) {
		queryAllBtn.addActionListener(actionListener);
	}

    public void updateItemListener(ActionListener actionListener) {
    	updateBtn.addActionListener(actionListener);
	}
    
    /**
	protected void selectListItem(String desc) {
		// TODO Displays the selected list data item to the right
		Gson gson = new Gson();
		Item item = null;
		int index=21;
		if(desc!=null) {
			while(true) {
				try {
					StringBuffer buffer = GsonUtils.addDoubleQuotationMarks(desc, index);
					item = gson.fromJson(buffer.toString(), Item.class);
					break;
				} catch (JsonSyntaxException e) {
					index=index+20;
				}
			}
		}
		if(item!=null) {
			this.itemIdTxt.setText(item.getItemId()+"");
			this.toolNameTxt.setText(item.getItemName());
			this.toolTypeTxt.setText(item.getType());
			this.quantityTxt.setText(item.getItemQuantity()+"");
			this.priceTxt.setText(item.getItemPrice()+"");
			this.sidTxt.setText(item.getSupplierID()+"");
		} 
	}*/

	public JLabel getDataCountTip() {
		return dataCountTip;
	}

	public void setDataCountTip(JLabel dataCountTip) {
		this.dataCountTip = dataCountTip;
	}

	public JList<String> getDataListBox() {
		return dataListBox;
	}

	public void setDataListBox(JList<String> dataListBox) {
		this.dataListBox = dataListBox;
	}

	public JRadioButton getToolIdAdo() {
		return toolIdAdo;
	}

	public void setToolIdAdo(JRadioButton toolIdAdo) {
		this.toolIdAdo = toolIdAdo;
	}

	public JRadioButton getToolNameAdo() {
		return toolNameAdo;
	}

	public void setToolNameAdo(JRadioButton toolNameAdo) {
		this.toolNameAdo = toolNameAdo;
	}
/**
	public JTextField getSerachTxt() {
		return serachTxt;
	}

	public void setSerachTxt(JTextField serachTxt) {
		this.serachTxt = serachTxt;
	}*/

	public JTextField getItemIdTxt() {
		return itemIdTxt;
	}

	public void setItemIdTxt(JTextField itemIdTxt) {
		this.itemIdTxt = itemIdTxt;
	}

	public JTextField getToolNameTxt() {
		return toolNameTxt;
	}

	public void setToolNameTxt(JTextField toolNameTxt) {
		this.toolNameTxt = toolNameTxt;
	}

	public JTextField getQuantityTxt() {
		return quantityTxt;
	}

	public void setQuantityTxt(JTextField quantityTxt) {
		this.quantityTxt = quantityTxt;
	}

	public JTextField getPriceTxt() {
		return priceTxt;
	}

	public void setPriceTxt(JTextField priceTxt) {
		this.priceTxt = priceTxt;
	}
	
	public JTextField getToolTypeTxt() {
		return toolTypeTxt;
	}

	public void setToolTypeTxt(JTextField toolTypeTxt) {
		this.toolTypeTxt = toolTypeTxt;
	}

	public JTextField getSidTxt() {
		return sidTxt;
	}

	public void setSidTxt(JTextField sidTxt) {
		this.sidTxt = sidTxt;
	}

	public void displayErrorMessage (String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
	public static void main(String[] args) {
		new LoginGUI().init();
	}
}
