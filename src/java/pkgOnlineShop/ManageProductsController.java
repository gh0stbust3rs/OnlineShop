/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
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
    private String detailMsg;
    
    private String bezeichnung;
    private int preis;
    private int bestand;
    private String beschreibung;
    private String kategorie;
    private String imagePath;
    private UploadedFile file; 
    
    private int selectedID;
    private Produkt selectedProduct;
    
    private List products;
  
    
    public ManageProductsController() {
        try{
            db = new Database();
            kategorien = db.getKategorien();
            imagePath = "default.png";
            products = db.getProducts();
       }catch(Exception ex){
           msg=ex.toString();
       }
    }
    
    public void reload()
    {
        try{
            bezeichnung="";preis=0;kategorie="PC";beschreibung="";bestand=0;
            products = db.getProducts();
        }
        catch(Exception ex)
        {
            msg = ex.toString();
        }
    }
    
    public void checkSelectedProduct()
    {
        try{
            if(selectedProduct==null)
            {
                FacesContext.getCurrentInstance().getExternalContext().redirect("adminManageProducts.xhtml");
            }
        }
        catch(Exception ignore)
        {}       
    }
    
    public void addProduct()
    {
        try{
            db.newProduct(bezeichnung,preis,kategorie,beschreibung,bestand,imagePath);
            
            imagePath = "default.png";
            products = db.getProducts();
            msg = "Erfolgreich Hinzugefügt!";
        }
        catch(Exception ex)
        {
            msg = ex.toString();
        }
    }
    
    public void deleteProduct()
    {
        try{
            db.deleteProduct(selectedID);
            products = db.getProducts();
            msg = "Erfolgreich Gelöscht!";
        }
        catch(Exception ex)
        {
            msg = ex.toString();
        }
    }
    
    public String productDetail()
    {
        for(Object o : products)
        {
            if(((Produkt)o).getId() == selectedID)
               selectedProduct = (Produkt)o;
        }
        return "adminProductDetails";
    }
    
    public String saveChanges()
    {
        try{
          db.updateProduct(selectedProduct);
          bezeichnung="";preis=0;kategorie="PC";beschreibung="";bestand=0;imagePath="default.png";msg="";
        }
        catch(Exception ex){
            msg = ex.toString();
        }
        
        return "adminManageProducts";
    }
    
    public void changeImage()
    {
        try{
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("");
            
            UUID iuid = UUID.randomUUID();
            
            Scanner s = new Scanner(file.getFileName());
            s.useDelimiter("\\.");
            
            String fileEnd = "";
            
            while(s.hasNext())
                fileEnd = s.next();
            
            if(fileEnd.compareTo("png")==0 || fileEnd.compareTo("jpg")==0)
            {           
                this.createFileFromUpload(iuid.toString() + "." + fileEnd);
                
                if(selectedProduct.getBild().compareTo("default.png")!=0)
                {
                    File f = new File(path + "/resources/productImages/" + selectedProduct.getBild());
                    f.delete();
                }
                
                selectedProduct.setBild(iuid.toString() + "." + fileEnd);
            }
            else
            {
               detailMsg = "Bitte benutzen Sie nur Bilder vom Typ .png oder .jpg";
            }
         }
         catch(Exception ex){
             detailMsg = "oasch" + ex.toString();
         }
    }    
    
    public void upload() {  
         try{           
            UUID iuid = UUID.randomUUID();
            
            Scanner s = new Scanner(file.getFileName());
            s.useDelimiter("\\.");
            
            String fileEnd = "";
            
            while(s.hasNext())
                fileEnd = s.next();
            
            if(fileEnd.compareTo("png")==0 || fileEnd.compareTo("jpg")==0)
            {       
                imagePath = iuid.toString() + "." + fileEnd;
                this.createFileFromUpload(imagePath);
                msg="";
            }
            else
            {
                msg = "Bitte benutzen Sie nur Bilder vom Typ .png oder .jpg";
            }
         }
         catch(Exception ex){
             msg = ex.toString();
         }
    }
   
    private void createFileFromUpload(String image)
    {
        try{
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("");

            String filePath = path + "/resources/productImages/" + image;
            File f = new File(filePath);
            f.createNewFile();
            InputStream inputStream = file.getInputstream();            
            OutputStream out = new FileOutputStream(f);

            byte buf[]=new byte[1024];
            int len;

            while((len=inputStream.read(buf))>0)                
                out.write(buf,0,len);

            out.flush();
            out.close();
            inputStream.close();
        }
        catch(Exception ex){
            msg = ex.toString();
        }
    }

    public Produkt getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Produkt selectedProduct) {
        this.selectedProduct = selectedProduct;
    }
    
    public List getProducts() {
        return products;
    }

    public void setProducts(List products) {
        this.products = products;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getSelectedID() {
        return selectedID;
    }

    public void setSelectedID(int selectedID) {
        this.selectedID = selectedID;
    }

    public String getDetailMsg() {
        return detailMsg;
    }

    public void setDetailMsg(String detailMsg) {
        this.detailMsg = detailMsg;
    }
    
    
}
