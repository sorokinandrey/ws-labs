
package ifmo.lab3.service;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "SqlException", targetNamespace = "http://lab3.ifmo/")
public class SqlException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private CountriesServiceFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public SqlException(String message, CountriesServiceFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public SqlException(String message, CountriesServiceFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ifmo.lab3.service.CountriesServiceFault
     */
    public CountriesServiceFault getFaultInfo() {
        return faultInfo;
    }

}