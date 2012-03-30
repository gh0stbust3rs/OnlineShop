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
 * @author Andreas
 */
@ManagedBean
@SessionScoped
public class ManageCategoriesController {

    private Database db;
    private String msg;
    private List kategorien;
    
    private String kategorie;
    
    public ManageCategoriesController() {
       try{
            db = new Database();
            kategorien = db.getKategorien();
       }catch(Exception ex){
           msg=ex.toString();
       }
    }
    
    public void newCategory()
    {
        try{
            db.newCategory(kategorie);
            kategorien = db.getKategorien();
            kategorie="";
            
            msg = "Erfolgreich Hinzugefügt!";
        }catch(Exception ex){
            msg = "Hinzufügen fehlgeschlagen! -> " + ex.toString();
        }
    }
    
    public void deleteCategory()
    {
        try{
            db.deleteCategory(kategorie);
            kategorien = db.getKategorien();
            kategorie="";
            
            msg = "Erfolgreich Gelöscht!";
        }catch(Exception ex){
            msg = "Löschen fehlgeschlagen! -> " + ex.toString();
        }
    }

    public List getKategorien() {
        return kategorien;
    }

    public void setKategorien(List kategorien) {
        this.kategorien = kategorien;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    
    
}
