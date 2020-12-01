package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SeatSelectionGUI extends JFrame {
	
	
	
	private double totalCost = 0;
//	private double priceOfSeat = (13.50)*1.05;
	private double priceOfSeat = 14.18;
	
	private static final long serialVersionUID = 1L;
	private JButton checkOutBtn;
	private JButton updateBtn;
	private JButton queryAllBtn;
	private JButton resetBtn;
	private JTextField theaterName;
	private JTextField movieName;
	private JTextField movieTime;
	private JTextField priceTxt;
	private JLabel dataCountTip;
	private JLabel Balance;
	private JList<String> dataListBox = null;
	
	private JButton A1;
	private JButton A2;
	private JButton A3;
	private JButton A4;
	private JButton A5;
	
	private JButton B1;
	private JButton B2;
	private JButton B3;
	private JButton B4;
	private JButton B5;
	
	private JButton C1;
	private JButton C2;
	private JButton C3;
	private JButton C4;
	private JButton C5;
	
	private JButton D1;
	private JButton D2;
	private JButton D3;
	private JButton D4;
	private JButton D5;
	private ArrayList<JButton> testButton = new ArrayList<JButton>();


	public SeatSelectionGUI() {
		this.setSize(1000, 600);
		this.setLayout(null);
		this.setLocation(217, 69);
		JPanel titlePanel=new JPanel();
		JLabel title=new JLabel("Choose Your Seat!!!");
		title.setFont(new Font("Courier New", Font.BOLD, 30));
		title.setForeground(Color.WHITE);
		titlePanel.setBounds(0, 0, 1000, 60);
		titlePanel.setBackground(Color.DARK_GRAY);
		titlePanel.add(title,JLabel.CENTER);
		this.add(titlePanel);
		
		JPanel screen=new JPanel();
		JLabel screenDisplay=new JLabel("The Screen");
		screenDisplay.setFont(new Font("Courier New", Font.BOLD, 25));
		screenDisplay.setForeground(Color.BLACK);
		screen.setBounds(400, 85, 200, 30);
		screen.setBackground(Color.YELLOW);
		screen.add(screenDisplay,JLabel.CENTER);
		add(screen);
		
		JPanel leftPanel=new JPanel();
		leftPanel.setLayout(null);
		leftPanel.setBounds(0, 0, 1000, 561);
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		JLabel searchOptions=new JLabel("Seat Options:");
		searchOptions.setFont(new Font("Courier New", Font.BOLD, 24));
		searchOptions.setBounds(5, 60, 260, 40);
		leftPanel.add(searchOptions);

		Balance=new JLabel("Current Cost = $" + totalCost);
		Balance.setFont(new Font("Courier New", Font.BOLD, 30));
		Balance.setBounds(250, 480, 400, 30);
		leftPanel.add(Balance);
		
		JLabel searchTip2=new JLabel("Preceed to Checkout: ");
		searchTip2.setFont(new Font("Courier New", Font.BOLD, 16));
		searchTip2.setBounds(250, 520, 400, 30);
		leftPanel.add(searchTip2);
		
		checkOutBtn = new JButton("Check Out");
		checkOutBtn.setBounds(450, 525, 100, 20);
		leftPanel.add(checkOutBtn);

		resetBtn = new JButton("Reset");
		resetBtn.setFont(new Font("RESET", Font.BOLD, 16));
		resetBtn.setBounds(365, 370, 270, 30);
		leftPanel.add(resetBtn);

		A1 = new JButton("A1");
		A1.setBounds(365, 150, 50, 50);
		leftPanel.add(A1);

		
		
		A2 = new JButton("A2");
		A2.setBounds(420, 150, 50, 50);
		leftPanel.add(A2);

		A3 = new JButton("A3");
		A3.setBounds(475, 150, 50, 50);
		leftPanel.add(A3);


		A4 = new JButton("A4");
		A4.setBounds(530, 150, 50, 50);
		leftPanel.add(A4);

		A5 = new JButton("A5");
		A5.setBounds(585, 150, 50, 50);
		leftPanel.add(A5);

		
		B1 = new JButton("B1");
		B1.setBounds(365, 205, 50, 50);
		leftPanel.add(B1);

		B2 = new JButton("B2");
		B2.setBounds(420, 205, 50, 50);
		leftPanel.add(B2);

		
		B3 = new JButton("B3");
		B3.setBounds(475, 205, 50, 50);
		leftPanel.add(B3);

		B4 = new JButton("B4");
		B4.setBounds(530, 205, 50, 50);
		leftPanel.add(B4);

		B5 = new JButton("B5");
		B5.setBounds(585, 205, 50, 50);
		leftPanel.add(B5);

		
		C1 = new JButton("C1");
		C1.setBounds(365, 260, 50, 50);
		leftPanel.add(C1);

		C2 = new JButton("C2");
		C2.setBounds(420, 260, 50, 50);
		leftPanel.add(C2);

		C3 = new JButton("C3");
		C3.setBounds(475, 260, 50, 50);
		leftPanel.add(C3);


		C4 = new JButton("C4");
		C4.setBounds(530, 260, 50, 50);
		leftPanel.add(C4);

		C5 = new JButton("C5");
		C5.setBounds(585, 260, 50, 50);
		leftPanel.add(C5);

		D1 = new JButton("D1");
		D1.setBounds(365, 315, 50, 50);
		leftPanel.add(D1);

		D2 = new JButton("D2");
		D2.setBounds(420, 315, 50, 50);
		leftPanel.add(D2);

		D3 = new JButton("D3");
		D3.setBounds(475, 315, 50, 50);
		leftPanel.add(D3);


		D4 = new JButton("D4");
		D4.setBounds(530, 315, 50, 50);
		leftPanel.add(D4);

		D5 = new JButton("D5");
		D5.setBounds(585, 315, 50, 50);
		leftPanel.add(D5);

		this.add(leftPanel);
		
		this.setResizable(false);
	}
	 

	//disable buttons
	public void dissableButton(JButton thisButton) {
		thisButton.setEnabled(false);
		totalCost = totalCost + priceOfSeat;
	}
	
	public void enableButton(JButton thisButton) {
		thisButton.setEnabled(true);
		totalCost = totalCost - priceOfSeat;
		
	}
	
	public void OnOffSwitch(JButton thisButton) {
		if(thisButton.isEnabled()) {
			dissableButton(thisButton);
		}else {
			enableButton(thisButton);
		}
	}
	
	public void joinButtons(){
		testButton.add(A1);
		testButton.add(A2);
		testButton.add(A3);
		testButton.add(A4);
		testButton.add(A5);
		
		testButton.add(B1);
		testButton.add(B2);
		testButton.add(B3);
		testButton.add(B4);
		testButton.add(B5);
		
		testButton.add(C1);
		testButton.add(C2);
		testButton.add(C3);
		testButton.add(C4);
		testButton.add(C5);
		
		testButton.add(D1);
		testButton.add(D2);
		testButton.add(D3);
		testButton.add(D4);
		testButton.add(D5);
	}
	
	public JLabel getBalance() {
		return Balance;
	}
	
	public void resetAllButtons() {
		joinButtons();

		for (JButton b : testButton) {
			b.setEnabled(true);	
		}
		totalCost = 0;
		updateBalance(getBalance());
	}
	
	public void addQueryAllListener(ActionListener actionListener) {
		queryAllBtn.addActionListener(actionListener);
	}

    public void updateItemListener(ActionListener actionListener) {
    	updateBtn.addActionListener(actionListener);
	}
    
    //Update CurrentBallance
    public void updateBalance(JLabel thisText) {
    	DecimalFormat df = new DecimalFormat("####.##");
    	thisText.setText("Current Cost = $" + df.format(getTotalCost()));
    }
     
    public JButton getCheckOutBtn() {
    	return checkOutBtn;
    }
    
    public JButton getResetBtn() {
    	return resetBtn;
    }

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

	public JTextField getTheaterName() {
		return theaterName;
	}

	public void setItemIdTxt(JTextField theaterName) {
		this.theaterName = theaterName;
	}

	public JTextField getMovieName() {
		return movieName;
	}

	public void setToolNameTxt(JTextField movieName) {
		this.movieName = movieName;
	}

	public JTextField getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(JTextField movieTime) {
		this.movieTime = movieTime;
	}

	public JTextField getPriceTxt() {
		return priceTxt;
	}

	public void setPriceTxt(JTextField priceTxt) {
		this.priceTxt = priceTxt;
	}
	

	public void displayErrorMessage (String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	

	public double getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	public double getPriceOfSeat() {
		return priceOfSeat;
	}


	public void setpriceOfSeat(double price) {
		this.priceOfSeat = price;
	}
	
	public JButton getA1() {
		return A1;
	}
	public void setA1(JButton A1) {
		this.A1 = A1;
	}
	public JButton getA2() {
		return A2;
	}
	public void setA2(JButton A2) {
		this.A2 = A2;
	}
	public JButton getA3() {
		return A3;
	}
	public void setA3(JButton A3) {
		this.A3 = A3;
	}
	public JButton getA4() {
		return A4;
	}
	public void setA4(JButton A4) {
		this.A4 = A4;
	}
	public JButton getA5() {
		return A5;
	}
	public void setA5(JButton A5) {
		this.A5 = A5;
	}
	
	
	public JButton getB1() {
		return B1;
	}
	public void setB1(JButton B1) {
		this.B1 = B1;
	}
	public JButton getB2() {
		return B2;
	}
	public void setB2(JButton B2) {
		this.B2 = B2;
	}
	public JButton getB3() {
		return B3;
	}
	public void setB3(JButton B3) {
		this.B3 = B3;
	}
	public JButton getB4() {
		return B4;
	}
	public void setB4(JButton B4) {
		this.B4 = B4;
	}
	public JButton getB5() {
		return B5;
	}
	public void setB5(JButton B5) {
		this.B5 = B5;
	}
	
	
	public JButton getC1() {
		return C1;
	}
	public void setC1(JButton C1) {
		this.C1 = C1;
	}
	public JButton getC2() {
		return C2;
	}
	public void setC2(JButton C2) {
		this.C2 = C2;
	}
	public JButton getC3() {
		return C3;
	}
	public void setC3(JButton C3) {
		this.C3 = C3;
	}
	public JButton getC4() {
		return C4;
	}
	public void setC4(JButton C4) {
		this.C4 = C4;
	}
	public JButton getC5() {
		return C5;
	}
	public void setC5(JButton C5) {
		this.C5 = C5;
	}
	
	
	public JButton getD1() {
		return D1;
	}
	public void setD1(JButton D1) {
		this.D1 = D1;
	}
	public JButton getD2() {
		return D2;
	}
	public void setD2(JButton D2) {
		this.D2 = D2;
	}
	public JButton getD3() {
		return D3;
	}
	public void setD3(JButton D3) {
		this.D3 = D3;
	}
	public JButton getD4() {
		return D4;
	}
	public void setD4(JButton D4) {
		this.D4 = D4;
	}
	public JButton getD5() {
		return D5;
	}
	public void setD5(JButton D5) {
		this.D5 = D5;
	}
	
}
