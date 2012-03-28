/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<String> getKategorien() throws SQLException
    {
        List<String> kategorien = new ArrayList<String>();
        String sql="select * from kategorie";
        
        PreparedStatement pstm = con.prepareStatement(sql);            
        ResultSet rs = pstm.executeQuery();
        
        while(rs.next())
        {
            kategorien.add(rs.getString("KAT_BEZEICHNUNG"));
        }
        
        return kategorien;
    }
    
    public boolean tryLogin(String login, String pw)
    {
        
        return true;
    }
}
