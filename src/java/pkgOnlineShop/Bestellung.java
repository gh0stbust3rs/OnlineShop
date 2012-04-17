/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import java.util.Date;



/**
 *
 * @author matthias
 */
public class Bestellung {
    private int id;
    private Person person;
    private Date datum;
    private Date shipped;
    private String knr;
    private String cvc;
    private int monat;
    private int jahr;

    public Bestellung() {
    	
    }

    public Bestellung(int id, Person person, Date datum, Date shipped, String knr, String cvc, int monat, int jahr) {
        this.id = id;
        this.person = person;
        this.datum = datum;
        this.shipped = shipped;
        this.knr = knr;
        this.cvc = cvc;
        this.monat = monat;
        this.jahr = jahr;
    }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	public Date getDatum() {
		return datum;
	}


	public void setDatum(Date datum) {
		this.datum = datum;
	}


	public Date getShipped() {
		return shipped;
	}


	public void setShipped(Date shipped) {
		this.shipped = shipped;
	}


	public String getKnr() {
		return knr;
	}


	public void setKnr(String knr) {
		this.knr = knr;
	}


	public String getCvc() {
		return cvc;
	}


	public void setCvc(String cvc) {
		this.cvc = cvc;
	}


	public int getMonat() {
		return monat;
	}


	public void setMonat(int monat) {
		this.monat = monat;
	}


	public int getJahr() {
		return jahr;
	}


	public void setJahr(int jahr) {
		this.jahr = jahr;
	}

}
