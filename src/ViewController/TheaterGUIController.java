package ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import View.SeatSelectionGUI;
import View.TheaterGUI;
import ViewModel.LoginGUIModel;
import ViewModel.TheaterGUIModel;

public class TheaterGUIController implements ActionListener {
	
	private TheaterGUI gui;
	private TheaterGUIModel model;
	private MouseListener mouse;
	
	public TheaterGUIController (TheaterGUI gui, TheaterGUIModel model) {
		this.setGui(gui);
		this.setModel(model);
		
		gui.getSearchClearBtn().addActionListener(this);
		gui.getSearchBtn().addActionListener(this);
		gui.getSelectBtn().addActionListener(this);
		//gui.getResultScroll().addActionListener(this); //can we put this in here?
		
		/*
		mouse = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() ==1) {
					movieOffering thisOffiering = gui.getMovieOffering().getSelectedValue();
					gui.getMovieNameTxt().setText(thisOffering.getMovieName());
					gui.getTheaterTxt().setText(thisOffering.getTheaterName());
					gui.getTimeTxt().setText(thisOffering.getMovieTime());
				}
			}
		}*/


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
