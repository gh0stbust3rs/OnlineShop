/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.UploadedFile;
/*
 *
 * @author Andreas
 */
@ManagedBean
@SessionScoped
public class ManageProductsController {

    private Database db;
    private List kategorien;
    private String msg;
    
    private String bezeichnung;
    private int preis;
    private int bestand;
    private String beschreibung;
    private String kategorie;
    private String imagePath;
    private String imageName;
    private UploadedFile file; 
  
    
    public ManageProductsController() {
        try{
            db = new Database();
            kategorien = db.getKategorien();
       }catch(Exception ex){
           msg=ex.toString();
       }
    }
    
    public void addProduct()
    {

    }
    
     public void upload() {  
         if(file==null)
             msg="fick";
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }    
    
    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public int getBestand() {
        return bestand;
    }

    public void setBestand(int bestand) {
        this.bestand = bestand;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List getKategorien() {
        return kategorien;
    }

    public void setKategorien(List kategorien) {
        this.kategorien = kategorien;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

        
}
