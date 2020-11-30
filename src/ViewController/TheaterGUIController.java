package ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;

import Controller.ModelController;
import TicketReservationModel.MovieOffering;
import View.SeatSelectionGUI;
import View.TheaterGUI;


public class TheaterGUIController implements ActionListener, MouseListener {
	
	private TheaterGUI gui;
	private ModelController model;
	private MouseListener mouse;
	
	public TheaterGUIController (TheaterGUI gui, ModelController model) {
		this.setGui(gui);
		this.setModel(model);
		
		gui.searchListener(this);
		gui.selectListener(this);
		gui.addListListener(this);
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
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		gui.getTheaterTxt().setText(gui.getDataListBox().getSelectedValue().getTheater().getTheaterName());
		gui.getMovieNameTxt().setText(gui.getDataListBox().getSelectedValue().getMovie().getMovieName());
		gui.getTimeTxt().setText(gui.getDataListBox().getSelectedValue().getTime());
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		if(e.getSource() == gui.getResultScroll()) {
			//TODO select movie from scroll pane
			String desc = String.format("You clicked on the %d item，Data %s",
	        		gui.getDataListBox().getSelectedIndex(), gui.getDataListBox().getSelectedValue());
	        System.out.println(desc);
	        //gui.selectListItem(gui.getDataListBox().getSelectedValue());
		}
		*/
		if(e.getSource() == gui.getSearchClearBtn()) {
			//start up next GUI if clicked
			gui.getSearchParameter().setText("");
			MovieOffering[] empty = new MovieOffering[0];
			gui.getDataListBox().setListData(empty);
		}
		
		if(e.getSource() == gui.getSelectBtn()) {
			//go to next GUI
			SeatSelectionGUI seatView = new SeatSelectionGUI();
			SeatGUIController seatController = new SeatGUIController(gui.getDataListBox().getSelectedValue(), seatView, model);
			seatView.setVisible(true);
		}
		
		if(e.getSource() == gui.getSearchBtn()) {
			//TODO impliment searching my movie/theater/or time
			String option = gui.searchSelection();
			String parameter = gui.getSearchParameter().getText();
			ArrayList<MovieOffering> results = null;
			if(parameter.equals("")) {
				results = model.viewAllUniqueOfferings();
			}else {
				if(option.equals("Theater")) {
					results = model.viewTheater(parameter);
				}else if(option.equals("Movie")) {
					results = model.viewMovies(parameter);
				}else {
					//why is viewTimes taking a time object?
					results = model.viewTimes(parameter);
				}
			}
			gui.displayMovieOfferings(results);
		}
	}
		
	
	
	public TheaterGUI getGui() {
		return gui;
	}

	public void setGui(TheaterGUI gui) {
		this.gui = gui;
	}

	public ModelController getModel() {
		return model;
	}

	public void setModel(ModelController model) {
		this.model = model;
	}
}


