/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import java.io.IOException;
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

    @ManagedProperty(value="#{mainController}")
    private MainController ctrl;
    
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
    
    public void checkUser()
    {
        try{
          if(ctrl.getUser()==null || ctrl.getUser().getAnbieter() == 0)
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }catch(Exception ignore){}
    }
    
    public String logout()
    {
        ctrl.setUser(null);
        ctrl.setSignedin(false);
        return "index";
    }

    public MainController getCtrl() {
        return ctrl;
    }

    public void setCtrl(MainController ctrl) {
        this.ctrl = ctrl;
    }
    
    

}
