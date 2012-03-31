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
    private Produkt produkt;
    private Person person;
    private int quantity;

    public Warenkorb(int id, int quantity, Produkt produkt, Person person) {
        this.id = id;
        this.produkt = produkt;
        this.person = person;
        this.quantity = quantity;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
