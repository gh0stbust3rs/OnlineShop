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
    private String sichernummer;
    private String monat;
    private String jahr;
    private boolean enable = false;

    private String email;
    private String pass;
    private Person person;
    private List warenkorb;
    
    private String kreditkarte = "0123456789012345";
    private String cvc = "012";
    private String valid_month = "12";
    private String valid_year = "14";
    
    private String message = "default wert";
    
    private Database db = null;

    public OrderController() {
    }
    
    public String bestellen(){
        if(person.getPass().equals(pass) && person.getEmail().equals(email)){
            try{
                db = new Database();
                db.fillOrders(warenkorb, kreditkarte, cvc, valid_month, valid_year);
                enable = false;
                return "finish";
            }catch(Exception ignore){message += ignore.toString();}
        }
        else
            message += "EMail oder Passwort stimmen nicht über ein "+email+" "+pass+" "+person.getPass()+" "+person.getEmail();
        return null;
    }
    
    public void kreditcheck(){
        enable = true;
    }

    public void setJahr(String jahr) {
        this.jahr = jahr;
    }

    public String getMonat() {
        return monat;
    }
    
    public String getJahr() {
        return jahr;
    }

    public void setMonat(String monat) {
        this.monat = monat;
    }

    public String getSichernummer() {
        return sichernummer;
    }

    public void setSichernummer(String sichernummer) {
        this.sichernummer = sichernummer;
    }

    public String getKreditnummer() {
        return kreditnummer;
    }

    public void setKreditnummer(String kreditnummer) {
        this.kreditnummer = kreditnummer;
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

    public List getWarenkorb() {
        return warenkorb;
    }

    public void setWarenkorb(List warenkorb) {
        this.warenkorb = warenkorb;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getKreditkarte() {
        return kreditkarte;
    }

    public void setKreditkarte(String kreditkarte) {
        this.kreditkarte = kreditkarte;
    }

    public String getValid_month() {
        return valid_month;
    }

    public void setValid_month(String valid_month) {
        this.valid_month = valid_month;
    }

    public String getValid_year() {
        return valid_year;
    }

    public void setValid_year(String valid_year) {
        this.valid_year = valid_year;
    }
    
    private SelectItem[] allemonate = {new SelectItem(1,"1"),new SelectItem(2,"2"),new SelectItem(3,"3"),
                                       new SelectItem(4,"4"),new SelectItem(5,"5"),new SelectItem(6,"6"),
                                       new SelectItem(7,"7"),new SelectItem(8,"8"),new SelectItem(9,"9"),
                                       new SelectItem(10,"10"),new SelectItem(11,"11"),new SelectItem(12,"12")};
     
    private SelectItem[] allejahre = {new SelectItem(1,"12"),new SelectItem(2,"13"),new SelectItem(3,"14"),
                                      new SelectItem(4,"15"),new SelectItem(5,"16"),new SelectItem(6,"17"),
                                      new SelectItem(7,"18"),new SelectItem(8,"19"),new SelectItem(9,"20")};
    public SelectItem[] getAllejahre() {
        return allejahre;
    }

    public SelectItem[] getAllemonate() {
        return allemonate;
    }
}

