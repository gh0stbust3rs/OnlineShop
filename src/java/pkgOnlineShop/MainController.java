/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author Andreas
 */
@ManagedBean
@SessionScoped
public class MainController {
    
    private Database db;
    
    private String loginName;    
    private String pw;    
    private String message;
    private Person user;
    private String selectedKategorie;
    private boolean signedin = false;
    
    private List kategorien;
    
    public MainController()
    {
       try{
        db = new Database();
        kategorien = db.getKategorien();
       }catch(Exception ex){
           message=ex.toString();
       }
    }
    
    public String login()
    {
        try{
            user = db.tryLogin(loginName, pw);

            if(user != null)
            {
                if(user.getAnbieter() == 1)
                {
                    return "adminManageUsers";
                }
                else
                {
                    return "signedIn";
                }
            }
            else
            {
                message = "Login Failed";
                return "index";
            }
        }
        catch(Exception ignore){
            message=ignore.toString();
            return "index";
        }
    }
    
    public void reload()
    {
        try{
        kategorien = db.getKategorien();
       }catch(Exception ex){
           message=ex.toString();
       }
    }
    
    public String changeKategorie(Kategorie k) {
        this.selectedKategorie = k.getBezeichnung();
        return "products";
    }
    
    public String register()
    {
        return "register";
    }
    
    public boolean isadmin(){
        if(user != null){
            if(user.getAnbieter()==1)
                return true;
        }
        return false;
    }
    
    public boolean isnotadmin(){
        if(user != null){
            if(user.getAnbieter()==1)
                return false;
        }
        return true;
    }

    public boolean getsignedin(){
        return signedin;
    }
    
    public boolean getnotsignedin(){
        return !signedin;
    }

    public List getKategorien() {
        return kategorien;
    }

    public void setKategorien(List kategorien) {
        this.kategorien = kategorien;
    } 

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String login) {
        this.loginName = login;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    public String getSelectedKategorie() {
        return selectedKategorie;
    }

    public void setSelectedKategorie(String selectedKategorie) {
        this.selectedKategorie = selectedKategorie;
    }
 
    
   
}
