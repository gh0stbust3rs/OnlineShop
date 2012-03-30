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
<<<<<<< HEAD
    
=======
>>>>>>> origin/master
    private Person user;
    
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
    
    public String register()
    {
        return "register";
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
 
   
}
