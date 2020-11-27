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

public class TheaterGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JRadioButton toolIdAdo =null;
	private JRadioButton toolNameAdo=null;
	private JTextField searchTime=null;
	private JButton searchBtn =null;
	private JButton updateBtn =null;
	private JButton queryAllBtn=null;
	private JButton selectBtn=null;
	private JTextField theaterTxt=null;
	private JTextField movieNameTxt=null;
	private JTextField timeTxt=null;
	private JTextField quantityTxt=null;
	private JTextField priceTxt=null;
	private JTextField sidTxt=null;
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
		JLabel searchtitle=new JLabel("Search Options");
		searchtitle.setFont(new Font("Courier New", Font.BOLD, 24));
		searchtitle.setBounds(150, 5, 260, 40);
		leftPanel.add(searchtitle);
		
		JLabel searchTip=new JLabel("Select to search by Theaters, Movies, or Times");
		searchTip.setFont(new Font("Courier New", Font.BOLD, 16));
		searchTip.setBounds(5, 55, 500, 30);
		leftPanel.add(searchTip);
		
		toolIdAdo = new JRadioButton("View Theaters");
		toolIdAdo.setFont(new Font("Courier New", Font.BOLD, 16));
		toolIdAdo.setBounds(10, 80, 200, 30);
		toolIdAdo.setSelected(true);
		leftPanel.add(toolIdAdo);
		toolNameAdo = new JRadioButton("Search Movies");
		toolNameAdo.setFont(new Font("Courier New", Font.BOLD, 16));
		toolNameAdo.setBounds(10, 110, 200, 30);
		leftPanel.add(toolNameAdo);
		
		ButtonGroup radioGrupu = new ButtonGroup();
		radioGrupu.add(toolIdAdo);
		radioGrupu.add(toolNameAdo);
		
		JLabel searchTip2=new JLabel("Search by Time: ");
		searchTip2.setFont(new Font("Courier New", Font.BOLD, 16));
		searchTip2.setBounds(5, 160, 400, 30);
		leftPanel.add(searchTip2);
		searchTime = new JTextField();
		searchTime.setBounds(15, 210, 150, 20);
		leftPanel.add(searchTime);
		
		searchBtn = new JButton("Search");
		searchBtn.setBounds(170, 210, 100, 20);
		leftPanel.add(searchBtn);
		
		JButton searchClearBtn = new JButton("Clear Search");
		searchClearBtn.setBounds(278, 210, 120, 20);
		leftPanel.add(searchClearBtn);
		searchClearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchTime.setText("");
			}
		});
		
		JLabel resultTip=new JLabel("Movies at Time Selected:");
		resultTip.setFont(new Font("Courier New", Font.BOLD, 16));
		resultTip.setBounds(15,300, 250, 30);
		this.add(resultTip);
		
		
		JScrollPane resultScroll = new JScrollPane();
		resultScroll.setBounds(5, 330, 492, 225);
		dataListBox = new JList<String>();
		dataListBox.setBounds(5, 0, 500, 237);
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
		JPanel rightPanel=new JPanel(); 
		rightPanel.setLayout(null);
		rightPanel.setBounds(502, 60, 500, 540);
		rightPanel.setBorder(BorderFactory.createEtchedBorder());
		JLabel Title=new JLabel("Choose a Movie Showing");
		Title.setFont(new Font("Courier New", Font.BOLD, 24));
		Title.setBounds(90, 5, 350, 40);
		rightPanel.add(Title);
		
		JLabel TheaterLab=new JLabel("Theater:");
		TheaterLab.setFont(new Font("Courier New", Font.BOLD, 15));
		TheaterLab.setBounds(80, 65, 120, 30);
		rightPanel.add(TheaterLab);
		theaterTxt=new JTextField();
		theaterTxt.setBounds(215, 65, 220, 27);
		rightPanel.add(theaterTxt);
		
		JLabel MovieLab=new JLabel("Movie Title:");
		MovieLab.setFont(new Font("Courier New", Font.BOLD, 15));
		MovieLab.setBounds(80, 115, 120, 30);
		rightPanel.add(MovieLab);
		movieNameTxt=new JTextField();
		movieNameTxt.setBounds(215, 115, 220, 27);
		rightPanel.add(movieNameTxt);
		
		JLabel toolTypeLab=new JLabel("Movie Time:");
		toolTypeLab.setFont(new Font("Courier New", Font.BOLD, 15));
		toolTypeLab.setBounds(80, 165, 120, 30);
		rightPanel.add(toolTypeLab);
		timeTxt=new JTextField();
		timeTxt.setBounds(215, 165, 220, 27);
		rightPanel.add(timeTxt);
		
		JButton selectBtn = new JButton("Select");
		selectBtn.setBounds(355, 215, 80, 30);
		rightPanel.add(selectBtn);
		selectBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SeatSelectionGUI().init();
				//this.setVisible(false);
				
				
				//make a JList for movie display

			}
		});
		
		this.add(rightPanel);
		
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

	public JTextField getTheaterTxt() {
		return theaterTxt;
	}

	public void setTheaterTxt(JTextField theaterTxt) {
		this.theaterTxt = theaterTxt;
	}

	public JTextField getTimeTxt() {
		return timeTxt;
	}

	public void setTimeTxt(JTextField timeTxt) {
		this.timeTxt = timeTxt;
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
	
	public JTextField getMovieNameTxt() {
		return movieNameTxt;
	}

	public void setMovieNameTxt(JTextField movieNameTxt) {
		this.movieNameTxt = movieNameTxt;
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
		new TheaterGUI().init();
	}
}
