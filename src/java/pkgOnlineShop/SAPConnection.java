/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import com.sap.mw.jco.JCO;

/**
 *
 * @author Andreas
 */
public class SAPConnection {
    	private static JCO.Client mConnection = null;

	private static JCO.Repository mRepository = null;

//	private static JCO.Structure mReturn = null;
	
	public JCO.Client connect() {
		try {
			createConnection();
			printConnectionDetails();
			return mConnection;
		} catch (Exception _ex) {
		}
		return null;
	}
	
	public JCO.Client closeConnection(){
		try {
			deleteConnection();
			return null;
		} catch (Exception _ex) {
			// TODO Auto-generated catch block
		}
		return null;
	}
	
	private static void createConnection() throws Exception {
		String mandant = "000";
		String userID = "BCUSER";
		String password = "MINISAP";
		String language = "EN";
		String hostname = "192.168.0.10";
		String systemNumber = "00";

		mConnection = JCO.createClient(mandant, userID, password, language,
				hostname, systemNumber);
		mConnection.connect();
		System.out.println("connected");
	}

	private static void printConnectionDetails() throws Exception {

	}

	private static void deleteConnection() throws Exception {
		mConnection.disconnect();
		mConnection = null;
	}
}
