/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

/**
 *
 * @author Andreas
 */
public class Produkt {
    private int id;
    private String bezeichnung;
    private int preis;
    private String kategorie;
    private String beschreibung;
    private int bestand;
    private String bild;

    public Produkt(int id,String bezeichnung, int preis, String kategorie, String beschreibung, int bestand, String bild) {
        this.bezeichnung = bezeichnung;
        this.preis = preis;
        this.kategorie = kategorie;
        this.beschreibung = beschreibung;
        this.bestand = bestand;
        this.bild = bild;

        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public int getBestand() {
        return bestand;
    }

    public void setBestand(int bestand) {
        this.bestand = bestand;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getBild() {
        return bild;
    }

    public void setBild(String bild) {
        this.bild = bild;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }
    
    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }
    
    
}
