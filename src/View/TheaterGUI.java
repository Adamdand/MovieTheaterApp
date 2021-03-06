package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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

import TicketReservationModel.MovieOffering;

public class TheaterGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JRadioButton searchTheatersAdo =null;
	private JRadioButton searchMoviesAdo=null;
	private JRadioButton searchTimesAdo=null;
	private JButton searchBtn =null;
	private JButton queryAllBtn=null;
	private JButton selectBtn=null;
	private JButton searchClearBtn=null;
	private JTextField theaterTxt=null;
	private JTextField movieNameTxt=null;
	private JTextField timeTxt=null;
	private JTextField quantityTxt=null;
	private JTextField priceTxt=null;
	private JTextField sidTxt=null;
	private JLabel dataCountTip=null;
	private JScrollPane resultScroll;
	private JList<MovieOffering> dataListBox = null;
	private JTextField searchParameterField;

	public TheaterGUI() {
		this.setSize(1000, 600);
		getContentPane().setLayout(null);
		this.setLocation(217, 69);
		JPanel titlePanel=new JPanel();
		JLabel title=new JLabel("Choose Your Movie!!!");
		title.setFont(new Font("Courier New", Font.BOLD, 30));
		title.setForeground(Color.WHITE);
		titlePanel.setBounds(0, 0, 1000, 60);
		titlePanel.setBackground(Color.DARK_GRAY);
		titlePanel.add(title,JLabel.CENTER);
		getContentPane().add(titlePanel);
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
		
		searchTheatersAdo = new JRadioButton("View Theaters");
		searchTheatersAdo.setFont(new Font("Courier New", Font.BOLD, 16));
		searchTheatersAdo.setBounds(10, 80, 200, 30);
		searchTheatersAdo.setSelected(true);
		leftPanel.add(searchTheatersAdo);
		searchMoviesAdo = new JRadioButton("Search Movies");
		searchMoviesAdo.setFont(new Font("Courier New", Font.BOLD, 16));
		searchMoviesAdo.setBounds(10, 110, 200, 30);
		leftPanel.add(searchMoviesAdo);
		searchTimesAdo = new JRadioButton("Search Times (HH:MM AM/PM)");
		searchTimesAdo.setFont(new Font("Courier New", Font.BOLD, 16));
		searchTimesAdo.setBounds(10, 140, 400, 30);
		leftPanel.add(searchTimesAdo);
		
		ButtonGroup radioGrupu = new ButtonGroup();
		radioGrupu.add(searchTheatersAdo);
		radioGrupu.add(searchMoviesAdo);
		radioGrupu.add(searchTimesAdo);
		
		searchBtn = new JButton("Search");
		searchBtn.setBounds(170, 180, 100, 20);
		leftPanel.add(searchBtn);
		
		searchClearBtn = new JButton("Clear Search");
		searchClearBtn.setBounds(278, 180, 120, 20);
		leftPanel.add(searchClearBtn);

		JLabel resultTip=new JLabel("Movies at Time Selected:");
		resultTip.setFont(new Font("Courier New", Font.BOLD, 16));
		resultTip.setBounds(15,300, 250, 30);
		getContentPane().add(resultTip);
		
		
		resultScroll = new JScrollPane();
		resultScroll.setBounds(5, 330, 492, 225);
		
		
		dataListBox = new JList<MovieOffering>();
		dataListBox.setBounds(5, 0, 500, 237);
		
		resultScroll.setViewportView(dataListBox);

		getContentPane().add(leftPanel);
		
		searchParameterField = new JTextField();
		searchParameterField.setBounds(20, 181, 142, 19);
		leftPanel.add(searchParameterField);
		searchParameterField.setColumns(10);
		getContentPane().add(resultScroll);
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
		
		selectBtn = new JButton("Select");
		selectBtn.setBounds(355, 215, 80, 30);
		rightPanel.add(selectBtn);
		
		getContentPane().add(rightPanel);
		
		this.setResizable(false);
		//this.setVisible(true);
	}
	public String searchSelection() {
		if(searchTheatersAdo.isSelected()) {
			return "Theater";
		}else if(searchMoviesAdo.isSelected()) {
			return "Movie";
		}else if(searchTimesAdo.isSelected()) {
			return "Time";
		}else{
			return null;
		}
	}
	public void displayMovieOfferings(ArrayList<MovieOffering> offerings) {
		MovieOffering[] movieOfferings = offerings.toArray(new MovieOffering[offerings.size()]);
		dataListBox.setListData(movieOfferings);
	}
	public void searchListener(ActionListener actionListener) {
		searchBtn.addActionListener(actionListener);
	}
	public void selectListener(ActionListener actionListener) {
		selectBtn.addActionListener(actionListener);
	}
	public void addQueryAllListener(ActionListener actionListener) {
		queryAllBtn.addActionListener(actionListener);
	}
    public void addListListener(MouseListener listenForClick) {
    	dataListBox.addMouseListener(listenForClick);
	}
    public void addSearchClearListener(ActionListener actionListener) {
    	searchClearBtn.addActionListener(actionListener);
    }

	public JLabel getDataCountTip() {
		return dataCountTip;
	}

	public void setDataCountTip(JLabel dataCountTip) {
		this.dataCountTip = dataCountTip;
	}

	public JList<MovieOffering> getDataListBox() {
		return dataListBox;
	}

	public void setDataListBox(JList<MovieOffering> dataListBox) {
		this.dataListBox = dataListBox;
	}

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
	
	

	public JButton getSelectBtn() {
		return selectBtn;
	}

	public void setSelectBtn(JButton selectBtn) {
		this.selectBtn = selectBtn;
	}

	public JButton getSearchBtn() {
		return searchBtn;
	}
	public void setSearchBtn(JButton searchBtn) {
		this.searchBtn = searchBtn;
	}	
	public JButton getSearchClearBtn() {
		return searchClearBtn;
	}

	public void setSearchClearBtn(JButton searchClearBtn) {
		this.searchClearBtn = searchClearBtn;
	}

	public JTextField getSearchParameter() {
		return searchParameterField;
	}

	public void setSearchParameter(JTextField searchParameter) {
		this.searchParameterField = searchParameter;
	}

	public JScrollPane getResultScroll() {
		return resultScroll;
	}

	public void setResultScroll(JScrollPane resultScroll) {
		this.resultScroll = resultScroll;
	}
}
