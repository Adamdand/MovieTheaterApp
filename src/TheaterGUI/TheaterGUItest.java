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

public class TheaterGUItest extends JFrame {
	private static final long serialVersionUID = 1L;
	private JRadioButton theaterNameAdo =null;
	private JRadioButton movieNameAdo=null;
	private JTextField searchTime=null;
	private JButton searchBtn =null;
	private JButton updateBtn =null;
	private JButton queryAllBtn=null;
	private JTextField theaterName=null;
	private JTextField movieName=null;
	private JTextField movieTime=null;
	private JTextField quantityTxt=null;
	private JTextField priceTxt=null;
	private JLabel dataCountTip=null;
	private JList<String> dataListBox = null;

	public void init() {
		this.setSize(1000, 600);
		this.setLayout(null);
		this.setLocation(217, 69);
		JPanel titlePanel=new JPanel();
		JLabel title=new JLabel("Choose Your Movie!!!");
		title.setFont(new Font("Courier New", Font.BOLD, 30));
		title.setForeground(Color.WHITE);
		titlePanel.setBounds(0, 0, 1000, 60);
		titlePanel.setBackground(Color.DARK_GRAY);
		titlePanel.add(title,JLabel.CENTER);
		this.add(titlePanel);
		JPanel leftPanel=new JPanel();
		leftPanel.setLayout(null);
		leftPanel.setBounds(0, 60, 500, 240);
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		JLabel searchOptions=new JLabel("Search Options");
		searchOptions.setFont(new Font("Courier New", Font.BOLD, 24));
		searchOptions.setBounds(150, 5, 260, 40);
		leftPanel.add(searchOptions);
		
		JLabel searchTip=new JLabel("Select to search by Theaters, Movies, or Times");
		searchTip.setFont(new Font("Courier New", Font.BOLD, 16));
		searchTip.setBounds(5, 55, 500, 30);
		leftPanel.add(searchTip);
		
		theaterNameAdo = new JRadioButton("View Theaters");
		theaterNameAdo.setFont(new Font("Courier New", Font.BOLD, 16));
		theaterNameAdo.setBounds(10, 80, 200, 30);
		theaterNameAdo.setSelected(true);
		leftPanel.add(theaterNameAdo);
		movieNameAdo = new JRadioButton("Search Movies");
		movieNameAdo.setFont(new Font("Courier New", Font.BOLD, 16));
		movieNameAdo.setBounds(10, 110, 200, 30);
		leftPanel.add(movieNameAdo);
		
		ButtonGroup radioGrupu = new ButtonGroup();
		radioGrupu.add(theaterNameAdo);
		radioGrupu.add(movieNameAdo);
		
		JLabel searchTip2=new JLabel("Search by Time: ");
		searchTip2.setFont(new Font("Courier New", Font.BOLD, 16));
		searchTip2.setBounds(5, 160, 400, 30);
		leftPanel.add(searchTip2);
		searchTime = new JTextField();
		searchTime.setBounds(15, 200, 150, 20);
		leftPanel.add(searchTime);
		
		searchBtn = new JButton("Search");
		searchBtn.setBounds(170, 200, 100, 20);
		leftPanel.add(searchBtn);
		
		JButton searchClearBtn = new JButton("Clear Search");
		searchClearBtn.setBounds(278, 200, 120, 20);
		leftPanel.add(searchClearBtn);
		searchClearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchTime.setText("");
			}
		});
		
		JLabel resultTip=new JLabel("Browse Results:");
		resultTip.setFont(new Font("Courier New", Font.BOLD, 30));
		resultTip.setBounds(550,80, 300, 30);
		this.add(resultTip);
		
		JScrollPane resultScroll = new JScrollPane();
		resultScroll.setBounds(540, 110, 396, 400);
		dataListBox = new JList<String>();
		dataListBox.setBounds(540, 0, 400, 400);
		dataListBox.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) { 
		        String desc = String.format("You clicked on the %d item，Data %s",
		        		dataListBox.getSelectedIndex(), dataListBox.getSelectedValue());
		        System.out.println(desc);
		        selectListItem(dataListBox.getSelectedValue());
			}

			private void selectListItem(String selectedValue) {
				// TODO Auto-generated method stub
				
			}
		});
		resultScroll.getViewport().add(dataListBox, null);

		this.add(leftPanel);
		this.add(resultScroll);
		
		
		
		JPanel bottomPanel=new JPanel(); 
		bottomPanel.setLayout(null);
		bottomPanel.setBounds(0, 300, 500, 540);
		bottomPanel.setBorder(BorderFactory.createEtchedBorder());
		JLabel clentTitle=new JLabel("Choose a Movie Showing");
		clentTitle.setFont(new Font("Courier New", Font.BOLD, 20));
		clentTitle.setBounds(130, 20, 350, 40);
		bottomPanel.add(clentTitle);
		
		JLabel theaterNameLab=new JLabel("Theater:");
		theaterNameLab.setFont(new Font("Courier New", Font.BOLD, 15));
		theaterNameLab.setBounds(30, 70, 120, 30);
		bottomPanel.add(theaterNameLab);
		theaterName=new JTextField();
		theaterName.setBounds(150, 70, 220, 27);
		bottomPanel.add(theaterName);
		
		JLabel MovieNameLab=new JLabel("Movie Title:");
		MovieNameLab.setFont(new Font("Courier New", Font.BOLD, 15));
		MovieNameLab.setBounds(30, 120, 120, 30);
		bottomPanel.add(MovieNameLab);
		movieName=new JTextField();
		movieName.setBounds(150, 120, 220, 27);
		bottomPanel.add(movieName);
		
		JLabel movieTimeLab=new JLabel("Movie Time:");
		movieTimeLab.setFont(new Font("Courier New", Font.BOLD, 15));
		movieTimeLab.setBounds(30, 170, 120, 30);
		bottomPanel.add(movieTimeLab);
		movieTime=new JTextField();
		movieTime.setBounds(150, 170, 220, 27);
		bottomPanel.add(movieTime);
		
		JButton clearBtn = new JButton("Select");
		clearBtn.setBounds(290, 220, 80, 30);
		bottomPanel.add(clearBtn);
		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				priceTxt.setText("");
				quantityTxt.setText("");
				theaterName.setText("");
				movieName.setText("");
				movieTime.setText("");
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
	
	public static void main(String[] args) {
		new TheaterGUItest().init();
	}
}
