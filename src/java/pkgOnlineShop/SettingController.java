/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Milan
 */
@ManagedBean
@SessionScoped
public class SettingController {
    private Database db;
    
    private Person person;
    
    private String vorname;
    private String nachname;
    private String strasse;
    private String hausnr;
    private String plz;
    private String ort;
    private String land;
    private String email;
    private String pass;
    
    private String message="";

    public SettingController() {

    }
    
    private void fillTextfields() {
        vorname = person.getVorname();
        nachname = person.getNachname();
        strasse = person.getStrasse();
        hausnr = ""+person.getHausnr();
        plz = ""+person.getPlz();
        ort = person.getOrt();
        email = person.getEmail();
        pass = person.getPass();
        land = person.getLand();
    }
    
    public void update(){
        if(email.equals("") || pass.equals("")){
            message = "Passwort und Email dürfen nicht leer sein";
        }
        else{
            try{
                db = new Database();
                db.updatePerson(person.getId(),vorname, nachname,strasse,hausnr,plz,ort,land,email,pass);
                message = "erfolgreich";
            }catch(Exception ignore){message = ignore.toString();}
        }
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
        fillTextfields();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHausnr() {
        return hausnr;
    }

    public void setHausnr(String hausnr) {
        this.hausnr = hausnr;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }    
}
