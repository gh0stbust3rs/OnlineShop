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
    
    public List<String> getKategorien() throws Exception
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
    
    public Person tryLogin(String login, String pw) throws Exception
    {
        Person p = null;
        String sql="select * from person where email=? and pass=?";
        
        PreparedStatement pstm = con.prepareStatement(sql);    
        pstm.setString(1, login);
        pstm.setString(2, pw);
        ResultSet rs = pstm.executeQuery();
        
        while(rs.next())
        {
            p = new Person(rs.getString("vorname"),rs.getString("nachname"),
                    rs.getString("strasse"),rs.getInt("hausnr"),rs.getInt("plz"),
                    rs.getString("ort"),rs.getString("land"),rs.getString("email"),
                    rs.getString("pass"),rs.getInt("anbieter"));
        }
        
        return p;
    }
    
    public void register(String vorname, String nachname, String strasse, int hausnr, int plz, String ort, String land, String email, String pass) throws Exception
    {
        String sql="insert into person(p_id,vorname,nachname,strasse,hausnr,plz,ort,land,email,pass,anbieter) values(SEQ_PERSON.nextval,?,?,?,?,?,?,?,?,?,0)";
        
        PreparedStatement pstm = con.prepareStatement(sql);   
        
        pstm.setString(1,vorname);
        pstm.setString(2,nachname);
        pstm.setString(3,strasse);
        pstm.setInt(4,hausnr);
        pstm.setInt(5,plz);
        pstm.setString(6,ort);
        pstm.setString(7,land);
        pstm.setString(8,email);
        pstm.setString(9,pass);
        
        pstm.execute();
    }
}
