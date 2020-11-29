package BackEnd;

import java.util.Date;

public class MovieTime {
	private Date time;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
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
}
