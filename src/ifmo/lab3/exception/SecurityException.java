package ifmo.lab3.exception;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "ifmo.lab3.exception.CountriesServiceFault")
public class SecurityException extends Exception {
    private final CountriesServiceFault fault;

    public SecurityException(String message, CountriesServiceFault fault) {
        super(message);
        this.fault = fault;
    }

    public SecurityException(String message, CountriesServiceFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public CountriesServiceFault getFaultInfo() {
        return fault;
    }
}