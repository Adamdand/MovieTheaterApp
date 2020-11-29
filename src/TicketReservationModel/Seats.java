package TicketReservationModel;

public class Seats {
	private char Row;
	private int Column;
	
	public Seats(char row, int col) {
		setRow(row);
		setColumn(col);
	}

	public int getColumn() {
		return Column;
	}

	public void setColumn(int column) {
		Column = column;
	}

	public char getRow() {
		return Row;
	}

	public void setRow(char row) {
		Row = row;
	}
	
	public String toString(){
		String str = "";
		str = str + Row + "" + Column + "";
		
		return str;
	}

}
