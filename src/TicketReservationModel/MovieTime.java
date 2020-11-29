package TicketReservationModel;


public class MovieTime {
	private int day;
	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String printMovieTime() {
		String test="";
		return test;
	}
	
	@Override
	public String toString() {
		return "at " + time;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
}
