package pkgOnlineShop;

public class DetailController {
	private Database db;
	private MainController mainController;
	
	private int amount;
	
	public DetailController() {
		
	}
	
	public String addToCart() {
		String retVal = "";
		try {
			db.addToCart(amount, mainController.getSelectedProduct().getId(), mainController.getUser().getId());
			retVal = "cart";
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
