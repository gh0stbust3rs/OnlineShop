/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Andreas
 */
@ManagedBean
@SessionScoped
public class AdminController {

    public AdminController() {
    }
   
    public String gotoUserManagement()
    {
        return "adminManageUsers";
    }
    
    public String gotoNewCategory()
    {
        return "adminManageCategories";
    }
    
    public String gotoNewProduct()
    {
        return "adminManageProducts";
    }
    
    public String logout()
    {
        return "index";
    }

}
