/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import java.sql.Connection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author matthias
 */

@ManagedBean
@SessionScoped
public class Database {
    Connection con = null;
    
    public Database() throws Exception {
        Context ctx = new InitialContext();
        Context envContext = (Context) ctx.lookup("java:/comp/env");
        DataSource ds = (DataSource) envContext.lookup("jdbc/resOnlineShop");
        con = ds.getConnection();
    }
}
