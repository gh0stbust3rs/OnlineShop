/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author matthias
 */

public class ProductsController {
    
    private ArrayList<Produkt> products;
    private Produkt selectedProduct;
    private int amount;
    
    private Database db;
    
    private MainController mainController;
    
    public ProductsController() {
        
    }

    public String addToCart() {
    		String retVal = "";
        try {
             db.addToCart(amount, selectedProduct.getId(), mainController.getUser().getId());
        		retVal = "cart";
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return retVal;
    }
    
    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
    }

    public ArrayList<Produkt> getProducts() throws Exception {
        products = db.getProductsForCategory(mainController.getSelectedKategorie());
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
        System.out.println("selectedProduct: "+selectedProduct.toString());
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
