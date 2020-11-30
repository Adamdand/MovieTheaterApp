package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class PaymentGUI extends JFrame{

	private double totalCost;
	
	private JFrame frame;
	private JTextField voucherTxt;
	private JTextField creditCardTxt;
	private JTextField emailTxt;
	private JCheckBox chckbxNewCheckBox;
	private JButton cancelBtn;
	private JButton redeemBtn;
	private JButton payBtn;
	private JLabel totalCostLabel;
	private JLabel voucherCodeLabel;


	/**
	 * Initialize the contents of the frame.
	 */
	public PaymentGUI(double price) {
		
		setTotalCost(price);
		
		//frame = new JFrame();
		//frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 15));
		//frame.setBounds(100, 100, 980, 674);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 15));
		setBounds(100, 100, 980, 674);
		
		payBtn = new JButton("Pay Now");
		payBtn.setBounds(403, 400, 109, 23);
		payBtn.setFont(new Font("Dialog", Font.PLAIN, 15));
		payBtn.setBackground(new Color(240, 255, 240));
		
		cancelBtn = new JButton("Cancel Transaction");
		cancelBtn.setBounds(744, 571, 167, 23);
		cancelBtn.setFont(new Font("Dialog", Font.PLAIN, 15));
		cancelBtn.setBackground(new Color(255, 182, 193));
		
		redeemBtn = new JButton("Redeem");
		redeemBtn.setFont(new Font("Dialog", Font.PLAIN, 15));
		redeemBtn.setBounds(598, 387, 109, 23);
		redeemBtn.setEnabled(false);
		
		chckbxNewCheckBox = new JCheckBox("Have a discount Voucher?");
		chckbxNewCheckBox.setFont(new Font("Dialog", Font.BOLD, 16));
		chckbxNewCheckBox.setBounds(598, 330, 257, 23);
		
		voucherTxt = new JTextField();
		voucherTxt.setBounds(598, 360, 109, 20);
		voucherTxt.setColumns(10);
		voucherTxt.setEditable(false);
		
		totalCostLabel = new JLabel("Total Cost: $" + totalCost);
		totalCostLabel.setBounds(350, 358, 204, 19);
		totalCostLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		
		voucherCodeLabel = new JLabel("Enter Voucher Code");
		voucherCodeLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		voucherCodeLabel.setBounds(719, 357, 180, 20);
		
		
		getContentPane().setLayout(null);
		getContentPane().add(payBtn);
		getContentPane().add(cancelBtn);
		getContentPane().add(chckbxNewCheckBox);
		getContentPane().add(voucherTxt);
		getContentPane().add(totalCostLabel);
		getContentPane().add(voucherCodeLabel);
		getContentPane().add(redeemBtn);
		
		JLabel lblNewLabel_2 = new JLabel("Payment Information");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(350, 214, 180, 23);
		getContentPane().add(lblNewLabel_2);
		
		creditCardTxt = new JTextField();
		creditCardTxt.setBounds(372, 248, 134, 20);
		getContentPane().add(creditCardTxt);
		creditCardTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Credit Card Number:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(195, 251, 167, 17);
		getContentPane().add(lblNewLabel_3);
		
		emailTxt = new JTextField();
		emailTxt.setColumns(10);
		emailTxt.setBounds(372, 282, 134, 19);
		getContentPane().add(emailTxt);
		
		JLabel lblEmail = new JLabel("email:");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(239, 284, 125, 17);
		getContentPane().add(lblEmail);
		
		JLabel lblNewLabel_4 = new JLabel("Almost There!");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_4.setBounds(139, 11, 665, 57);
		getContentPane().add(lblNewLabel_4);
		
		updateTotalCost(totalCostLabel);
		
		//this.setVisible(true);
	}

	public double getTotalCost() {
		return totalCost;
	}
	
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	public void updateTotalCost(JLabel cost) {
		DecimalFormat df = new DecimalFormat("####.##");
		cost.setText("Total Cost = $" + df.format(getTotalCost()));
	}

	
	public void changeTextFieldVisibility(JTextField thisText) {
		if (thisText.isEditable()){
			thisText.setEditable(false);
		}
		else {
			thisText.setEditable(true);
		}
	}
	
	public void changeButtonVisibility(JButton thisButton) {
		if(thisButton.isEnabled()) {
			thisButton.setEnabled(false);
		}else {
			thisButton.setEnabled(true);
		}
	}
	
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	public JButton getCancelBtn() {
		return cancelBtn;
	}
	
	public JButton getRedeemBtn() {
		return redeemBtn;
	}
	
	public JButton getPayBtn() {
		return payBtn;
	}
	
	public JCheckBox getCheckBox() {
		return chckbxNewCheckBox;
	}
	
	public JTextField getvoucherTxt() {
		return voucherTxt;
	}
	
	public JLabel getTotalCostLabel() {
		return totalCostLabel;
	}
	
	public JTextField getVoucherTxt() {
		return voucherTxt;
	}
	
	public JTextField getEmailTxt() {
		return emailTxt;
	}
	
	public JTextField getCreditCardTxt() {
		return creditCardTxt;
	}
}
