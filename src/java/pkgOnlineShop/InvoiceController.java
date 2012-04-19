package pkgOnlineShop;

import java.util.ArrayList;

public class InvoiceController {
	private Database db;
	private MainController mainController;
	
	private Person person;
	
	public InvoiceController() {
		
	}
	
	
	public String getRechnungssumme() {
		String retVal = "";
		
		try {
			retVal = db.getRechnungssumme(mainController.getSelectedBestellung());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return retVal;
	}
	
	public String getQuantityForProduct(Produkt p) {
		String retVal = "";
		
		try {
			retVal = db.getQuantityForProduct(p,mainController.getSelectedBestellung());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return retVal;
	}
	
	public String getPreisForMenge(Produkt p) {
		String retVal = "";
		
		int menge = Integer.parseInt(getQuantityForProduct(p));
		float preis = p.getPreis() * menge;
		retVal = Float.toString(preis);
		
		return retVal;
	}
	
	public ArrayList<Produkt> getProductsForSelectedBestellung() {
		ArrayList<Produkt> produkte = new ArrayList<Produkt>();
		if(mainController.getSelectedBestellung() != null) {
			try {
				produkte = db.getProductsForSelectedBestellung(mainController.getSelectedBestellung());
			}
			catch(Exception e) {
				e.printStackTrace();
			}
                        
		}
		
		return produkte;
	}
	
	public String getRechnungssummeNetto() {
		String retVal = "";
		
		try {
			float summe = Integer.parseInt(getRechnungssumme());
			double summeNo = summe / 1.2;
			retVal = Double.toString(summeNo);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		return retVal;
	}
	
	public String getRechnungMWSt() {
		String retVal = "";
		
		try {
			float summe = Integer.parseInt(getRechnungssumme());
			double summeNo = summe / 1.2;
			retVal = Double.toString(summe - summeNo);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return retVal;
	}
        
        public String back()
        {
            return "orders";
        }

	public Database getDb() {
		return db;
	}

	public void setDb(Database db) {
		this.db = db;
	}

	public MainController getMainController() {
		return mainController;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
