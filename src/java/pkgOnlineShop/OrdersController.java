/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Andreas
 */

public class OrdersController {

    private Database db;
    private List<Bestellung> orders;
    private ArrayList<Bestellung> adminOrders;
    private String msg;
    private MainController mainController;
    
    private int selectedOrder;
            
    public OrdersController(){
        
    }
    
    public void loadOrders()
    {
         try{
             orders = db.getOrders(mainController.getUser());
        }
        catch(Exception ex){msg = ex.toString();}
    }
    
    public String generateInvoice()
    {
        mainController.setSelectedBestellung(this.getSOrder());
        
        return "invoice";
    }
    
    private Bestellung getSOrder()
    {
        for(Bestellung b:orders)
        {
            if(b.getId()==selectedOrder)
            {
                return b;
            }
        }
        
        return null;
    }

    public List<Bestellung> getOrders() {
        this.loadOrders();
        return orders;
    }

    public void setOrders(List<Bestellung> orders) {
        this.orders = orders;
    }

    public ArrayList<Bestellung> getAdminOrders() {
    		try {
    			adminOrders = db.getAdminOrders();
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
		return adminOrders;
	}

    public String ship() {
    		try {
    			db.shipOrder(selectedOrder);
    		}
    		catch(Exception e) {
    			System.out.println(e);
    		}
    		return "adminOrders";
    }
    
	public void setAdminOrders(ArrayList<Bestellung> adminOrders) {
		this.adminOrders = adminOrders;
	}

	public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getSelectedOrder() {
        return selectedOrder;
    }

    public void setSelectedOrder(int selectedOrder) {
        this.selectedOrder = selectedOrder;
    }

    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
    }

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    
    

    
    
}
