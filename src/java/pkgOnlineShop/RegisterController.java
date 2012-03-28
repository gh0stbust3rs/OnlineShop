/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Andreas
 */
@ManagedBean
@SessionScoped
public class RegisterController {

    private String vorname;
    private String nachname;
    private String strasse;
    private int hausnr;
    private int plz;
    private String ort;
    private String land;
    private String email;
    private String pass;
    
    private String msg;
    private Database db;
    
    public RegisterController() {
        try{
            db = new Database();
        }catch(Exception ex){
            msg = ex.toString();
        }
    }
    
    public void register()
    {
        try{
            db.register(vorname, nachname, strasse, hausnr, plz, ort, land, email, pass);
            vorname="";nachname="";strasse="";hausnr=0;plz=0;ort="";land="";email="";pass="";
            
            msg = "Die Registrierung war erfolgreich!";
        }catch(Exception ex){
            msg = "Registrierung fehlgeschlagen! -> " + ex.toString();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHausnr() {
        return hausnr;
    }

    public void setHausnr(int hausnr) {
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

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
