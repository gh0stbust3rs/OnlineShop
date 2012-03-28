/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import java.util.List;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Andreas
 */
public class MainController {
    
    private Database db;
    
    private String loginName;    
    private String pw;    
    private String message;
    
    private List kategorien;
    
    public MainController()
    {
       try{
        db = new Database();
        kategorien = db.getKategorien();
       }catch(Exception ignore){
           message=ignore.toString();
       }
    }
    
    public String login()
    {
        try{
        boolean ok = db.tryLogin(loginName, pw);
        
        if(ok)
        {
            return "signedIn";
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
    
    
}
