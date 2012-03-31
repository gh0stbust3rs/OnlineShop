/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import java.util.List;

/**
 *
 * @author Milan
 */
public class WarenkorbController {    
    private Database db;
    
    private List warenkorb;
    
    private int id;
    private int personID;
    private int produktID;
    private int quantity;

    private String msg;
    
    public WarenkorbController(){
        try{           
            db = new Database();
        }catch(Exception ignore){
            msg = ignore.toString();
        }
    }
}
