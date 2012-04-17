package pkgOnlineShop;

import java.util.ArrayList;

public class SearchController {
	private ArrayList<Produkt> products;
    private Produkt selectedProduct;
    private int amount;
    
    private Database db;
    
    private MainController mainController;
	private String userNotLoggedIn;
    
    public SearchController() {
        
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
    
    public String getUserNotLoggedIn() {
    		userNotLoggedIn = "true";
		
		if(mainController.getUser() != null) {
			userNotLoggedIn = "false";
		}
		    			
		return userNotLoggedIn;
		}
		
		public void setUserNotLoggedIn(String v) {
				this.userNotLoggedIn = v;
		}
    
    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
    }

    public ArrayList<Produkt> getProducts() throws Exception {
        products = db.getProductsForSearch(mainController.getSearch());
        mainController.setSearch("");
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
