package ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import View.SeatSelectionGUI;
import View.TheaterGUI;
import ViewModel.LoginGUIModel;
import ViewModel.TheaterGUIModel;

public class TheaterGUIController implements ActionListener {
	
	private TheaterGUI gui;
	private TheaterGUIModel model;
	
	public TheaterGUIController (TheaterGUI gui, TheaterGUIModel model) {
		this.setGui(gui);
		this.setModel(model);
		
		gui.getSearchClearBtn().addActionListener(this);
		gui.getSearchBtn().addActionListener(this);
		gui.getSelectBtn().addActionListener(this);
		//gui.getResultScroll().addActionListener(this); //can we put this in here?


	}
	

	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == gui.getResultScroll()) {
			//TODO select movie from scroll pane
			String desc = String.format("You clicked on the %d item，Data %s",
	        		gui.getDataListBox().getSelectedIndex(), gui.getDataListBox().getSelectedValue());
	        System.out.println(desc);
	        //gui.selectListItem(gui.getDataListBox().getSelectedValue());
		}
		
		if(e.getSource() == gui.getSearchClearBtn()) {
			//start up next GUI if clicked
			gui.getSearchTime().setText("");
		}
		
		if(e.getSource() == gui.getSelectBtn()) {
			//go to next GUI
			SeatSelectionGUI seatView = new SeatSelectionGUI();
			SeatGUIController seatController = new SeatGUIController(seatView, null);
			seatView.setVisible(true);
		}

		
		if(e.getSource() == gui.getSearchBtn()) {
			//TODO impliment searching my movie/theater/or time
		}
	}
		
	
	
	public TheaterGUI getGui() {
		return gui;
	}

	public void setGui(TheaterGUI gui) {
		this.gui = gui;
	}

	public TheaterGUIModel getModel() {
		return model;
	}

	public void setModel(TheaterGUIModel model) {
		this.model = model;
	}

}
