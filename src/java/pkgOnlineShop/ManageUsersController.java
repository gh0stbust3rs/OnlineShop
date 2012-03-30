/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import java.util.List;
import javax.faces.bean.ManagedBean;
<<<<<<< HEAD
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
=======
import javax.faces.bean.SessionScoped;
>>>>>>> origin/master

/**
 *
 * @author Andreas
 */
@ManagedBean
@SessionScoped
public class ManageUsersController {

    private Database db;
    
    private List personen;
    private int userCount;
    private int userId;
    
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
    
    public ManageUsersController() {
        try{           
            db = new Database();
            personen = db.getPersonen();
<<<<<<< HEAD
            
        }catch(Exception ignore){
        }
    }

    public void reload()
    {
        vorname="";nachname="";strasse="";hausnr=0;plz=0;ort="";land="Deutschland";email="";pass="";
=======
        }catch(Exception ignore){}
>>>>>>> origin/master
    }
    
    public void addNewUser()
    {
        try{
            db.register(vorname, nachname, strasse, hausnr, plz, ort, land, email, pass);   
            vorname="";nachname="";strasse="";hausnr=0;plz=0;ort="";land="";email="";pass="";
            personen = db.getPersonen();
            
            msg = "Erfolgreich Hinzugefügt!";
        }catch(Exception ex){
            msg = "Hinzufügen fehlgeschlagen! -> " + ex.toString();
        }
    }
    
    public void deleteUser()
    {
        try{
            db.deleteUser(userId);
            personen = db.getPersonen();
            
            msg = "Erfolgreich Gelöscht!";
        }catch(Exception ex){
            msg = "Löschen fehlgeschlagen! -> " + ex.toString();
        }
    }
   

    public List getPersonen() {
        return personen;
    }

    public void setPersonen(List personen) {
        this.personen = personen;
    }

    public int getUserCount() {
        return personen.size();
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
