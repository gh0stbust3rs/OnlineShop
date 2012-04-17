/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.JCO;

/**
 *
 * @author Andreas
 */
public class SAPFunctions {
    private JCO.Client mConnection = null;
    private JCO.Repository mRepository = null;
    
    public int FunctionReadCreditCard(JCO.Client connection, String cnum, String cvc, String edate){
        try{
            mConnection = connection;
            JCO.Function sapFunction = getFunction("Z_OS_CHECKCREDIT");
            setFunctionInputParametersRead(sapFunction, cnum, cvc, edate);
            executeFunction(sapFunction);
            return printRead(sapFunction);
        }
        catch(Exception e) {return 0;}
    }
    
    private JCO.Function getFunction(String nameofFunction)throws Exception{
        try{
            mRepository = new JCO.Repository("MyRepository", mConnection);
            IFunctionTemplate ft = mRepository.getFunctionTemplate(nameofFunction.toUpperCase());
            if(ft==null)
                throw new Exception("Function not found in SAP");
            return ft.getFunction();
        }
        catch(Exception e){
            throw new Exception("Function not found in SAP");
        }
    }
    
    	private void setFunctionInputParametersRead(JCO.Function _sapFunction, String cnum, String cvc, String edate) throws Exception {		
		_sapFunction.getImportParameterList().setValue(cnum, "CNUM");
		_sapFunction.getImportParameterList().setValue(cvc, "CVC");
		_sapFunction.getImportParameterList().setValue(edate, "EDATE");
	}
        
        private void executeFunction(JCO.Function _sapFunction)throws Exception {
		mConnection.execute(_sapFunction);
	}
        
        private int printRead(JCO.Function _sapFunction) throws Exception {	
            JCO.Table tblCredit = _sapFunction.getTableParameterList().getTable("RETURN");
            int i = 0;
            if(tblCredit == null || tblCredit.isEmpty()){
                    System.out.println("something goes wrong");
            }
            else{
                    
                    for (; i < tblCredit.getNumRows(); i++, tblCredit.nextRow())
                {
                            System.out.println(tblCredit.getValue("CNUM") +" "+ tblCredit.getValue("CVC") +" "+ tblCredit.getValue("EDATE"));
                }
                    System.out.println(i+" countries loaded");
            }
            return i;
	}
}
