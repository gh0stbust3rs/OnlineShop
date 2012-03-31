/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import com.sap.mw.jco.JCO;

/**
 *
 * @author Milan
 */
public class SapConnection {
    private static JCO.Client mConnection = null;

	private static JCO.Repository mRepository = null;

	public JCO.Client connect(String ip) {
		try {
			if(ip == null || ip.equals("") || ip.length() == 0){
				ip="192.168.1.134";
			}
			createConnection(ip);
			printConnectionDetails();
			return mConnection;
		} catch (Exception _ex) {
			System.out.println("error occured: " + _ex);
		}
		return null;
	}
	
	public JCO.Client closeConnection(){
		try {
			deleteConnection();
			return null;
		} catch (Exception _ex) {
			// TODO Auto-generated catch block
			System.out.println("error occured: " + _ex);
		}
		return null;
	}
	
	private static void createConnection(String ip) throws Exception {
		String mandant = "000";
		String userID = "BCUSER";
		String password = "MINISAP";
		String language = "EN";
		String hostname = ip;
		String systemNumber = "00";

		mConnection = JCO.createClient(mandant, userID, password, language,
				hostname, systemNumber);
		mConnection.connect();
	}

	private static void printConnectionDetails() throws Exception {
		System.out.println("connection attributes: "
				+ mConnection.getAttributes());

		System.out.println("middleware version: " + JCO.getMiddlewareVersion());
	}

	private static void deleteConnection() throws Exception {
		mConnection.disconnect();
		mConnection = null;
		System.out.println("Disconnected.");
	}
}
