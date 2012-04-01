/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Milan
 */
@ManagedBean
@SessionScoped
public class OrderController {
    
    private String kreditnummer;
    private int sichernummer;
    private int monat;
    private int jahr;
    private boolean enable = false;

    private String email;
    private String pass;
    private Person person;
    private Warenkorb warenkorb;
    
    private String message;
    
    private Database db = null;

    public OrderController() {
    }
    
    public String bestellen(){
        if(person.getPass().equals(pass) && person.getEmail().equals(email)){
            try{
                db = new Database();
                db.fillOrders(warenkorb);
                enable = false;
                return "finish";
            }catch(Exception ignore){message = ignore.toString();}
        }
        return null;
    }
    
    public void kreditcheck(){
        enable = true;
    } 

    public int getJahr() {
        return jahr;
    }

    public String getKreditnummer() {
        return kreditnummer;
    }

    public int getMonat() {
        return monat;
    }

    public int getSichernummer() {
        return sichernummer;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    public void setKreditnummer(String kreditnummer) {
        this.kreditnummer = kreditnummer;
    }

    public void setMonat(int monat) {
        this.monat = monat;
    }

    public void setSichernummer(int sichernummer) {
        this.sichernummer = sichernummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Warenkorb getWarenkorb() {
        return warenkorb;
    }

    public void setWarenkorb(Warenkorb warenkorb) {
        this.warenkorb = warenkorb;
    }
    
    private SelectItem[] allemonate = {new SelectItem(1,"1"),new SelectItem(2,"2"),new SelectItem(3,"3"),
                                       new SelectItem(4,"4"),new SelectItem(5,"5"),new SelectItem(6,"6"),
                                       new SelectItem(7,"7"),new SelectItem(8,"8"),new SelectItem(9,"9"),
                                       new SelectItem(10,"10"),new SelectItem(11,"11"),new SelectItem(12,"12")};
     
    private SelectItem[] allejahre = {new SelectItem(1,"2012"),new SelectItem(2,"2013"),new SelectItem(3,"2014"),
                                      new SelectItem(4,"2015"),new SelectItem(5,"2016"),new SelectItem(6,"2017"),
                                      new SelectItem(7,"2018"),new SelectItem(8,"2019"),new SelectItem(9,"2020")};
    public SelectItem[] getAllejahre() {
        return allejahre;
    }

    public SelectItem[] getAllemonate() {
        return allemonate;
    }
}

