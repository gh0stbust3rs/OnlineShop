/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Milan
 */
@ManagedBean
@SessionScoped
public class SettingController {
    private Person person;
    private String message;
    
    private Database db;

    public SettingController() {
        try{
            db = new Database();
        }catch(Exception ignore){message = ignore.toString();}
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
    
    
}
