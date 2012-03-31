/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Milan
 */
@ManagedBean
@SessionScoped
public class WarenkorbController {    
    private Database db;
    
    private List warenkorb;
    private Person person;
    private int wid;

    private String msg; 
    
    public WarenkorbController(){
        
    }
    
    private void loadcart(){
        try{           
            db = new Database();
            warenkorb = db.getWarenkorb(person);
        }catch(Exception ignore){
            msg = ignore.toString();
        }
    }
    
    public int getWarenzanzahl(){
        if(warenkorb != null)
            return warenkorb.size();
        return 0;
    }
    
    public void delete(){
        try{
            db.deleteWarenkorb(wid);
            loadcart();
        }catch(Exception ignore){
            msg = ignore.toString();
        }
    }
    
    public String order(){
        return "order";
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        loadcart();
    }

    public List getWarenkorb() {
        return warenkorb;
    }

    public void setWarenkorb(List warenkorb) {
        this.warenkorb = warenkorb;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }
}
