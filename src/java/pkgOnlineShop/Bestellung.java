/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import java.sql.Date;



/**
 *
 * @author Milan
 */
public class Bestellung {
    private int id;
    private Date datum;
    private String knr;
    private String cvc;
    private String monat;
    private String jahr;
    private Person person;
    private Date shipped;

    public Bestellung(int id, Date datum, String knr, String cvc, String monat, String jahr, Person person, Date shipped) {
        this.id = id;
        this.datum = datum;
        this.knr = knr;
        this.cvc = cvc;
        this.monat = monat;
        this.jahr = jahr;
        this.person = person;
        this.shipped = shipped;
    }


    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJahr() {
        return jahr;
    }

    public void setJahr(String jahr) {
        this.jahr = jahr;
    }

    public String getKnr() {
        return knr;
    }

    public void setKnr(String knr) {
        this.knr = knr;
    }

    public String getMonat() {
        return monat;
    }

    public void setMonat(String monat) {
        this.monat = monat;
    }

    public Date getShipped() {
        return shipped;
    }

    public void setShipped(Date shipped) {
        this.shipped = shipped;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    
    
}
