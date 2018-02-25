
package ifmo.lab1.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ifmo.lab1.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCountry_QNAME = new QName("http://lab1.ifmo/", "getCountry");
    private final static QName _GetCountriesResponse_QNAME = new QName("http://lab1.ifmo/", "getCountriesResponse");
    private final static QName _GetCountries_QNAME = new QName("http://lab1.ifmo/", "getCountries");
    private final static QName _GetCountryResponse_QNAME = new QName("http://lab1.ifmo/", "getCountryResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ifmo.lab1.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCountries }
     * 
     */
    public GetCountries createGetCountries() {
        return new GetCountries();
    }

    /**
     * Create an instance of {@link GetCountry }
     * 
     */
    public GetCountry createGetCountry() {
        return new GetCountry();
    }

    /**
     * Create an instance of {@link GetCountriesResponse }
     * 
     */
    public GetCountriesResponse createGetCountriesResponse() {
        return new GetCountriesResponse();
    }

    /**
     * Create an instance of {@link GetCountryResponse }
     * 
     */
    public GetCountryResponse createGetCountryResponse() {
        return new GetCountryResponse();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.ifmo/", name = "getCountry")
    public JAXBElement<GetCountry> createGetCountry(GetCountry value) {
        return new JAXBElement<GetCountry>(_GetCountry_QNAME, GetCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.ifmo/", name = "getCountriesResponse")
    public JAXBElement<GetCountriesResponse> createGetCountriesResponse(GetCountriesResponse value) {
        return new JAXBElement<GetCountriesResponse>(_GetCountriesResponse_QNAME, GetCountriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountries }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.ifmo/", name = "getCountries")
    public JAXBElement<GetCountries> createGetCountries(GetCountries value) {
        return new JAXBElement<GetCountries>(_GetCountries_QNAME, GetCountries.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.ifmo/", name = "getCountryResponse")
    public JAXBElement<GetCountryResponse> createGetCountryResponse(GetCountryResponse value) {
        return new JAXBElement<GetCountryResponse>(_GetCountryResponse_QNAME, GetCountryResponse.class, null, value);
    }

}
