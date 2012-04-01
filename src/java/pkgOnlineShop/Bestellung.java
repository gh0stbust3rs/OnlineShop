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
    private Produkt produkt;
    private Date shipped;
    private int quantity;
    private int gesamtpreis;

    public Bestellung(int id, Date datum, String knr, String cvc, String monat, String jahr, Person person, Produkt produkt, Date shipped, int quantity) {
        this.id = id;
        this.datum = datum;
        this.knr = knr;
        this.cvc = cvc;
        this.monat = monat;
        this.jahr = jahr;
        this.person = person;
        this.produkt = produkt;
        this.shipped = shipped;
        this.quantity = quantity;
        this.gesamtpreis = this.produkt.getPreis() * this.quantity;
    }

    public int getGesamtpreis() {
        return gesamtpreis;
    }

    public void setGesamtpreis(int gesamtpreis) {
        this.gesamtpreis = gesamtpreis;
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

    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
