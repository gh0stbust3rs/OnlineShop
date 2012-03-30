/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public List<Kategorie> getKategorien() throws Exception
    {
        List<Kategorie> kategorien = new ArrayList<Kategorie>();
        String sql="select * from kategorie";
        
        PreparedStatement pstm = con.prepareStatement(sql);            
        ResultSet rs = pstm.executeQuery();
        
        Kategorie k = null;        
        while(rs.next())
        {
            k = new Kategorie(rs.getInt("KAT_ID"),rs.getString("KAT_BEZEICHNUNG"));
            kategorien.add(k);
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
            p = new Person(rs.getInt("p_id"),rs.getString("vorname"),rs.getString("nachname"),
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
    
    public List<Person> getPersonen() throws Exception
    {
        List<Person> persons = new ArrayList<Person>();
        
        String sql="select * from person where anbieter=0";
        
        PreparedStatement pstm = con.prepareStatement(sql);    
        ResultSet rs = pstm.executeQuery();
        
        Person p;
        while(rs.next())
        {
            p = new Person(rs.getInt("p_id"),rs.getString("vorname"),rs.getString("nachname"),
                    rs.getString("strasse"),rs.getInt("hausnr"),rs.getInt("plz"),
                    rs.getString("ort"),rs.getString("land"),rs.getString("email"),
                    rs.getString("pass"),rs.getInt("anbieter"));
            persons.add(p);
        }
        
        return persons;
    }
    
    public List<Produkt> getProducts() throws Exception
    {
        String sql = "select * from produkt";
        List<Produkt> products = new ArrayList<Produkt>();
        
        PreparedStatement pstm = con.prepareStatement(sql);    
        ResultSet rs = pstm.executeQuery();
        
        Produkt p;
        while(rs.next())
        {
            p = new Produkt(rs.getInt("pr_id"),rs.getString("bezeichnung"),rs.getInt("preis"),rs.getString("kat"),
                    rs.getString("beschreibung"),rs.getInt("bestand"),rs.getString("bild"));
            
            products.add(p);
        }
        
        return products;
    }
    
    public void deleteUser(int id) throws Exception
    {
        String sql="delete from person where p_id=?";
        
        PreparedStatement pstm = con.prepareStatement(sql);    
        pstm.setInt(1,id);
        pstm.execute();
    }
    
    public void newCategory(String name) throws Exception
    {
        String sql="insert into kategorie(kat_id,kat_bezeichnung) values(seq_kategorie.nextval,?)";
        
        PreparedStatement pstm = con.prepareStatement(sql);    
        pstm.setString(1,name);
        pstm.execute();
    }
    
    public void deleteCategory(String name) throws Exception
    {
        String sql="delete from kategorie where kat_bezeichnung=? ";
        
        PreparedStatement pstm = con.prepareStatement(sql);    
        pstm.setString(1,name);
        pstm.execute();
    }
    
    public void newProduct(String bezeichnung,int preis,String kategorie,String beschreibung,int bestand,String imagePath) throws Exception
    {
        String sql="insert into produkt values(seq_produkt.nextval,?,?,?,?,?,?)";
        
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,bezeichnung);
        pstm.setFloat(2,preis);
        pstm.setString(3,beschreibung);
        pstm.setFloat(4,bestand);
        pstm.setString(5,imagePath);
        pstm.setString(6,kategorie);
        
        pstm.execute();
    }
    
    public void deleteProduct(int id) throws Exception
    {
        String sql="delete from produkt where pr_id=?";
        
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setInt(1,id);
        pstm.execute();
    }
    
    public void updateProduct(Produkt p) throws Exception
    {
        String sql="update produkt set bezeichnung=? and preis=? and bestand=? and beschreibung=? and bild=? and kat=? where pr_id=?";
        
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,p.getBezeichnung());
        pstm.setFloat(2,p.getPreis());
        pstm.setFloat(3,p.getBestand());
        pstm.setString(4,p.getBeschreibung());
        pstm.setString(5,p.getBild());
        pstm.setString(6,p.getKategorie());
        pstm.setInt(7,p.getId());
        pstm.execute();
    }
}
