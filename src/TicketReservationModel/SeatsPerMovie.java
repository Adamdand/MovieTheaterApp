package TicketReservationModel;

import java.util.ArrayList;
import java.util.Arrays;


public class SeatsPerMovie {
	
	private ArrayList<ArrayList<Seats>> allSeats;
	
	public SeatsPerMovie() {
		allSeats = new ArrayList<ArrayList<Seats>>();
		createRoom();
		
	}
	
	public void createRoom(){
		System.out.println("creating room");

		
		 for(char row = 'A'; row < 'E'; row++){
			 ArrayList<Seats> seatRow = new ArrayList<Seats>();
			 for(int col = 1; col < 6; col++){
				 Seats mySeat = new Seats(row,col);
				 seatRow.add(mySeat);
		        }
			 allSeats.add(seatRow);
		    }	
	}
	
	public Seats[][] getRoom(){
		return null;
	}
	
	
	
	   @Override
	    public String toString(){
	        String str="";
	        for (int i = 0; i < allSeats.size(); i++) { 
	            for (int j = 0; j < allSeats.get(i).size(); j++) { 
	            	str = str + allSeats.get(i).get(j).toString(); 
	            } 

	        }
			return str; 
	    }
	
	public static void main(String[] args) {
		
		SeatsPerMovie myMovie = new SeatsPerMovie();
		
		System.out.println("start");
		System.out.println(myMovie.allSeats.toString());
		
		   for (int i = 0; i < myMovie.allSeats.size(); i++) { 
	            for (int j = 0; j < myMovie.allSeats.get(i).size(); j++) { 
	                System.out.print(myMovie.allSeats.get(i).get(j).toString() + " "); 
	            } 
	            System.out.println(); 
	        } 
		   
		   System.out.println("end");

		
	}
}

