package ifmo.lab3.exception;

public class CountriesServiceFault {

    private static final String DEFAULT_MESSAGE = "argument cannot be null or empty";

    protected String message;

    public CountriesServiceFault() {
    }

    public CountriesServiceFault(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static CountriesServiceFault defaultInstance() {
        CountriesServiceFault fault = new CountriesServiceFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }

}