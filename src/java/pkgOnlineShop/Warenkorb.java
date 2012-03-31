/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

/**
 *
 * @author Milan
 */
public class Warenkorb {
    private int id;
    private int produktID;
    private int personID;
    private int quantity;

    public Warenkorb(int id, int produktID, int personID, int quantity) {
        this.id = id;
        this.produktID = produktID;
        this.personID = personID;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public int getProduktID() {
        return produktID;
    }

    public void setProduktID(int produktID) {
        this.produktID = produktID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
