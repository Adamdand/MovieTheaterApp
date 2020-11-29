package TicketReservationModel;

public class Theater {
	private String theaterName;
	private String theaterLocation;
	
	public Theater (String theaterName, String theaterLocation) {
		setTheaterName(theaterName);
		setTheaterLocation(theaterLocation);
	}
	
	public String printTheater() {
		String test="";
		return test;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getTheaterLocation() {
		return theaterLocation;
	}

	public void setTheaterLocation(String theaterLocation) {
		this.theaterLocation = theaterLocation;
	}
	
	@Override
	public String toString() {
		return theaterName + " at " + theaterLocation;
	}
	
}
