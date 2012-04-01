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
public class FinishControll {
    
    private String message;
    private List bestellung;
    private Person person;
    private int bestellungzahl;
    private Database db;

    public FinishControll() {
        try{
            db = new Database();
            bestellung = db.getBestellungen(person);
        }catch(Exception ex){message = ex.toString();}
    }
    
    public void reload(){
        try{
            bestellung = db.getBestellungen(person);
        }catch(Exception ex){message = ex.toString();}
    }

    public List getBestellung() {
        return bestellung;
    }

    public int getBestellungzahl() {
        if(bestellung != null)
            return bestellung.size();
        return 0;
    }

    public void setBestellungzahl(int bestellungzahl) {
        this.bestellungzahl = bestellungzahl;
    }

    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        message = person.getId()+"";
        reload();
    }

    public void setBestellung(List bestellung) {
        this.bestellung = bestellung;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
