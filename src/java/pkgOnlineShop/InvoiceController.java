package pkgOnlineShop;

import java.util.ArrayList;

public class InvoiceController {
	private Database db;
	private MainController mainController;
	
	private Rechnung selectedRechnung;
	private Person person;
	
	public InvoiceController() {
		
	}
	
	public ArrayList<Rechnung> getRechnungen() {
		ArrayList<Rechnung> rechnungen = new ArrayList<Rechnung>();
		
		try {
			rechnungen = db.getRechnungenForCustomer(mainController.getUser());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return rechnungen;
	}
	
	public String getRechnungssumme(Rechnung r) {
		String retVal = "";
		
		try {
			retVal = db.getRechnungssumme(r);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return retVal;
	}
	
	public String getQuantityForProduct(Produkt p) {
		String retVal = "";
		
		try {
			retVal = db.getQuantityForProduct(p);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return retVal;
	}
	
	public String getPreisForMenge(Produkt p) {
		String retVal = "";
		
		int menge = Integer.parseInt(getQuantityForProduct(p));
		int preis = p.getPreis() * menge;
		retVal = Integer.toString(preis);
		
		return retVal;
	}
	
	public ArrayList<Produkt> getProductsForSelectedRechnung() {
		ArrayList<Produkt> produkte = new ArrayList<Produkt>();
		if(selectedRechnung != null) {
			try {
				produkte = db.getProductsForSelectedRechnung(selectedRechnung);
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
			int summe = Integer.parseInt(getRechnungssumme(selectedRechnung));
			int summeNo = summe / 1;
			retVal = Integer.toString(summeNo);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		return retVal;
	}
	
	public String getRechnungMWSt() {
		String retVal = "";
		
		try {
			int summe = Integer.parseInt(getRechnungssumme(selectedRechnung));
			int summeNo = summe / 1;
			retVal = Integer.toString(summe - summeNo);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return retVal;
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

	public Rechnung getSelectedRechnung() {
		return selectedRechnung;
	}

	public void setSelectedRechnung(Rechnung selectedRechnung) {
		this.selectedRechnung = selectedRechnung;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
