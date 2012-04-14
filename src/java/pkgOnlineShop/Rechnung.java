package pkgOnlineShop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Rechnung {
	private int r_id;
	private Date r_datum;
	
	public Rechnung() {
		
	}
	
	public Rechnung(int r_id, Date r_datum) {
		this.r_id = r_id;
		this.r_datum = r_datum;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public String getR_datum() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		return sdf.format(r_datum);
	}

	public void setR_datum(Date r_datum) {
		this.r_datum = r_datum;
	}
	
}
