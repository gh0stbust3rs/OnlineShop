/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author matthias
 */
@ManagedBean
@SessionScoped
public class ProductsController {
    
    private ArrayList<Produkt> products;
    private Produkt selectedProduct;
    private int amount;
    
    @ManagedProperty(value="#{database}")
    private Database db;
    
    @ManagedProperty(value="#{mainController}")
    private MainController mainController;
    
    public ProductsController() {
        
    }

    public void addToCart() {
        try {
            db.addToCart(amount, selectedProduct.getId(), mainController.getUser().getId());
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
    }

    public ArrayList<Produkt> getProducts() {
        try {
            products = db.getProductsForCategory(mainController.getSelectedKategorie());
        }
        catch (Exception e) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.INFO, "####"+e.toString());
        }
        return products;
    }

    public void setProducts(ArrayList<Produkt> products) {
        this.products = products;
    }

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public Produkt getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Produkt selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
