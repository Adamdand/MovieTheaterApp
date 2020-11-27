package TheaterGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

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

public class SeatSelectionGUI extends JFrame {
	
	
	
	private double totalCost = 0;
	private double priceOfSeat = (13.50)*1.05;
	
	private static final long serialVersionUID = 1L;
	private JTextField searchTime=null;
	private JButton checkOutBtn =null;
	private JButton updateBtn =null;
	private JButton queryAllBtn=null;
	private JButton resetBtn=null;
	private JTextField theaterName=null;
	private JTextField movieName=null;
	private JTextField movieTime=null;
	private JTextField quantityTxt=null;
	private JTextField priceTxt=null;
	private JLabel dataCountTip=null;
	private JList<String> dataListBox = null;
	
	private JButton A1 =null;
	private JButton A2 =null;
	private JButton A3 =null;
	private JButton A4 =null;
	private JButton A5 =null;
	
	private JButton B1 =null;
	private JButton B2 =null;
	private JButton B3 =null;
	private JButton B4 =null;
	private JButton B5 =null;
	
	private JButton C1 =null;
	private JButton C2 =null;
	private JButton C3 =null;
	private JButton C4 =null;
	private JButton C5 =null;
	
	private JButton D1 =null;
	private JButton D2 =null;
	private JButton D3 =null;
	private JButton D4 =null;
	private JButton D5 =null;
	private ArrayList<JButton> testButton = new ArrayList<JButton>();


	public void init() {
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

		JLabel Balance=new JLabel("Current Cost = $" + totalCost);
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
		resetBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetAllButtons();
				updateBalance(Balance);
			}
		});
		
		A1 = new JButton("A1");
		A1.setBounds(365, 150, 50, 50);
		leftPanel.add(A1);
		A1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(A1);
				updateBalance(Balance);
				
			}
		});
		
		
		A2 = new JButton("A2");
		A2.setBounds(420, 150, 50, 50);
		leftPanel.add(A2);
		A2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(A2);
				updateBalance(Balance);
			}
		});
		A3 = new JButton("A3");
		A3.setBounds(475, 150, 50, 50);
		leftPanel.add(A3);
		A3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(A3);
				updateBalance(Balance);
			}
		});

		A4 = new JButton("A4");
		A4.setBounds(530, 150, 50, 50);
		leftPanel.add(A4);
		A4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(A4);
				updateBalance(Balance);
			}
		});
		A5 = new JButton("A5");
		A5.setBounds(585, 150, 50, 50);
		leftPanel.add(A5);
		A5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(A5);
				updateBalance(Balance);
			}
		});
		
		B1 = new JButton("B1");
		B1.setBounds(365, 205, 50, 50);
		leftPanel.add(B1);
		B1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(B1);
				updateBalance(Balance);
			}
		});
		B2 = new JButton("B2");
		B2.setBounds(420, 205, 50, 50);
		leftPanel.add(B2);
		B2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(B2);
				updateBalance(Balance);
			}
		});
		
		B3 = new JButton("B3");
		B3.setBounds(475, 205, 50, 50);
		leftPanel.add(B3);
		B3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(B3);
				updateBalance(Balance);
			}
		});
		B4 = new JButton("B4");
		B4.setBounds(530, 205, 50, 50);
		leftPanel.add(B4);
		B4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(B4);
				updateBalance(Balance);
			}
		});
		B5 = new JButton("B5");
		B5.setBounds(585, 205, 50, 50);
		leftPanel.add(B5);
		B5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(B5);
				updateBalance(Balance);
			}
		});
		
		C1 = new JButton("C1");
		C1.setBounds(365, 260, 50, 50);
		leftPanel.add(C1);
		C1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(C1);
				updateBalance(Balance);

			}
		});
		C2 = new JButton("C2");
		C2.setBounds(420, 260, 50, 50);
		leftPanel.add(C2);
		C2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(C2);
				updateBalance(Balance);
			}
		});
		C3 = new JButton("C3");
		C3.setBounds(475, 260, 50, 50);
		leftPanel.add(C3);
		C3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(C3);
				updateBalance(Balance);
			}
		});

		C4 = new JButton("C4");
		C4.setBounds(530, 260, 50, 50);
		leftPanel.add(C4);
		C4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(C4);
				updateBalance(Balance);
			}
		});
		C5 = new JButton("C5");
		C5.setBounds(585, 260, 50, 50);
		leftPanel.add(C5);
		C5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(C5);
				updateBalance(Balance);
			}
		});
		D1 = new JButton("D1");
		D1.setBounds(365, 315, 50, 50);
		leftPanel.add(D1);
		D1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(D1);
				updateBalance(Balance);
			}
		});
		D2 = new JButton("D2");
		D2.setBounds(420, 315, 50, 50);
		leftPanel.add(D2);
		D2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(D2);
				updateBalance(Balance);
			}
		});
		D3 = new JButton("D3");
		D3.setBounds(475, 315, 50, 50);
		leftPanel.add(D3);
		D3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(D3);
				updateBalance(Balance);
			}
		});

		D4 = new JButton("D4");
		D4.setBounds(530, 315, 50, 50);
		leftPanel.add(D4);
		D4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(D4);
				updateBalance(Balance);
			}
		});
		D5 = new JButton("D5");
		D5.setBounds(585, 315, 50, 50);
		leftPanel.add(D5);
		D5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dissableButton(D5);
				updateBalance(Balance);
			}
		});
		

		this.add(leftPanel);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
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
	
	public void resetAllButtons() {
		joinButtons();

		for (JButton b : testButton) {
			b.setEnabled(true);	
		}
		totalCost = 0;
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

	public JRadioButton getmovieNameAdo() {
		return movieNameAdo;
	}

	public void setMovieNameAdo(JRadioButton movieNameAdo) {
		this.movieNameAdo = movieNameAdo;
	}

	public JRadioButton getTheaterNameAdo() {
		return theaterNameAdo;
	}

	public void setTheaterNameAdo(JRadioButton theaterNameAdo) {
		this.theaterNameAdo = theaterNameAdo;
	}
/**
	public JTextField getSerachTxt() {
		return serachTxt;
	}

	public void setSerachTxt(JTextField serachTxt) {
		this.serachTxt = serachTxt;
	}*/

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
	
	public static void main(String[] args) {
		new SeatSelectionGUI().init();
	}


}
