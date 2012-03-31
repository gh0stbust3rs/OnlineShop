/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgOnlineShop;

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.JCO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Milan
 */
@ManagedBean
@SessionScoped
public class SapController {
    
    private JCO.Client mConnection = null;

    private JCO.Repository mRepository = null;
    
    private List list;
    
    private String message;

    public SapController(){}
    
    ////////////////////////////////////////////////////////////////////////////////////////Creat
    public void read(){
            list = new ArrayList();
            try {
                    mConnection = new SapConnection().connect(null);
                    JCO.Function sapFunction = getFunction("BAPI_ZFLIGHTCOUNTRY_FILL");
                    setFunctionInputParametersRead(sapFunction);
                    executeFunction(sapFunction);
                    printRead(sapFunction);
            } catch (Exception _ex) {
                    System.out.println("error occured: " + _ex);
            }
    }

    ///////////////////////////////////////////////////////////////////////////////////
    private JCO.Function getFunction(String nameOfFunction)
                    throws Exception {
            try {
                    mRepository = new JCO.Repository("MyRepository", mConnection);
                    IFunctionTemplate ft = mRepository
                                    .getFunctionTemplate(nameOfFunction.toUpperCase());

                    if (ft == null)
                            throw new Exception("Function not found in SAP Repository.");

                    System.out.println("function details: " + ft.getFunction());

                    return ft.getFunction();
            } catch (Exception _ex) {
                    throw new Exception("Creating FunctionTemplate for "
                                    + nameOfFunction + " failed with " + _ex);
            }
    }

    private void setFunctionInputParametersRead(JCO.Function _sapFunction) throws Exception {
            System.out.println(_sapFunction);
    }

    private void setFunctionInputParametersAgent(JCO.Function _sapFunction, String id) throws Exception {
            System.out.println(_sapFunction);
            _sapFunction.getImportParameterList().setValue(id, "ID");
    }

    private void executeFunction(JCO.Function _sapFunction)throws Exception {
            mConnection.execute(_sapFunction);
    }

    private void printRead(JCO.Function _sapFunction) throws Exception {
            message = "";

            JCO.Table tblCountry = _sapFunction.getTableParameterList().getTable("COUNTRYTBL");

            if(tblCountry == null || tblCountry.isEmpty()){
                    message = "something goes wrong";
            }
            else{
                    int i = 0;
                    for (; i < tblCountry.getNumRows(); i++, tblCountry.nextRow())
                    {
                            String[] tmp = {tblCountry.getString("LAND1"), tblCountry.getString("LANDX"), tblCountry.getString("NATIO")};
                            list.add(tmp);
                    }
                    message = i+" countries loaded";
            }

    }
    
    public String getMessage(){
        return message;
    }
    
    public void setMessage(String message){
        this.message = message;
    }
}
