
package ifmo.lab2.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ifmo.lab2.service package. 
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

    private final static QName _DeleteCountry_QNAME = new QName("http://lab2.ifmo/", "deleteCountry");
    private final static QName _AddCountryResponse_QNAME = new QName("http://lab2.ifmo/", "addCountryResponse");
    private final static QName _GetCountryResponse_QNAME = new QName("http://lab2.ifmo/", "getCountryResponse");
    private final static QName _GetCountries_QNAME = new QName("http://lab2.ifmo/", "getCountries");
    private final static QName _UpdateCountryResponse_QNAME = new QName("http://lab2.ifmo/", "updateCountryResponse");
    private final static QName _AddCountry_QNAME = new QName("http://lab2.ifmo/", "addCountry");
    private final static QName _UpdateCountry_QNAME = new QName("http://lab2.ifmo/", "updateCountry");
    private final static QName _GetCountriesResponse_QNAME = new QName("http://lab2.ifmo/", "getCountriesResponse");
    private final static QName _DeleteCountryResponse_QNAME = new QName("http://lab2.ifmo/", "deleteCountryResponse");
    private final static QName _GetCountry_QNAME = new QName("http://lab2.ifmo/", "getCountry");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ifmo.lab2.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddCountry }
     * 
     */
    public AddCountry createAddCountry() {
        return new AddCountry();
    }

    /**
     * Create an instance of {@link UpdateCountry }
     * 
     */
    public UpdateCountry createUpdateCountry() {
        return new UpdateCountry();
    }

    /**
     * Create an instance of {@link GetCountries }
     * 
     */
    public GetCountries createGetCountries() {
        return new GetCountries();
    }

    /**
     * Create an instance of {@link UpdateCountryResponse }
     * 
     */
    public UpdateCountryResponse createUpdateCountryResponse() {
        return new UpdateCountryResponse();
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
     * Create an instance of {@link DeleteCountryResponse }
     * 
     */
    public DeleteCountryResponse createDeleteCountryResponse() {
        return new DeleteCountryResponse();
    }

    /**
     * Create an instance of {@link DeleteCountry }
     * 
     */
    public DeleteCountry createDeleteCountry() {
        return new DeleteCountry();
    }

    /**
     * Create an instance of {@link GetCountryResponse }
     * 
     */
    public GetCountryResponse createGetCountryResponse() {
        return new GetCountryResponse();
    }

    /**
     * Create an instance of {@link AddCountryResponse }
     * 
     */
    public AddCountryResponse createAddCountryResponse() {
        return new AddCountryResponse();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link ResponseCode }
     * 
     */
    public ResponseCode createResponseCode() {
        return new ResponseCode();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.ifmo/", name = "deleteCountry")
    public JAXBElement<DeleteCountry> createDeleteCountry(DeleteCountry value) {
        return new JAXBElement<DeleteCountry>(_DeleteCountry_QNAME, DeleteCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.ifmo/", name = "addCountryResponse")
    public JAXBElement<AddCountryResponse> createAddCountryResponse(AddCountryResponse value) {
        return new JAXBElement<AddCountryResponse>(_AddCountryResponse_QNAME, AddCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.ifmo/", name = "getCountryResponse")
    public JAXBElement<GetCountryResponse> createGetCountryResponse(GetCountryResponse value) {
        return new JAXBElement<GetCountryResponse>(_GetCountryResponse_QNAME, GetCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountries }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.ifmo/", name = "getCountries")
    public JAXBElement<GetCountries> createGetCountries(GetCountries value) {
        return new JAXBElement<GetCountries>(_GetCountries_QNAME, GetCountries.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.ifmo/", name = "updateCountryResponse")
    public JAXBElement<UpdateCountryResponse> createUpdateCountryResponse(UpdateCountryResponse value) {
        return new JAXBElement<UpdateCountryResponse>(_UpdateCountryResponse_QNAME, UpdateCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.ifmo/", name = "addCountry")
    public JAXBElement<AddCountry> createAddCountry(AddCountry value) {
        return new JAXBElement<AddCountry>(_AddCountry_QNAME, AddCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.ifmo/", name = "updateCountry")
    public JAXBElement<UpdateCountry> createUpdateCountry(UpdateCountry value) {
        return new JAXBElement<UpdateCountry>(_UpdateCountry_QNAME, UpdateCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.ifmo/", name = "getCountriesResponse")
    public JAXBElement<GetCountriesResponse> createGetCountriesResponse(GetCountriesResponse value) {
        return new JAXBElement<GetCountriesResponse>(_GetCountriesResponse_QNAME, GetCountriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.ifmo/", name = "deleteCountryResponse")
    public JAXBElement<DeleteCountryResponse> createDeleteCountryResponse(DeleteCountryResponse value) {
        return new JAXBElement<DeleteCountryResponse>(_DeleteCountryResponse_QNAME, DeleteCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab2.ifmo/", name = "getCountry")
    public JAXBElement<GetCountry> createGetCountry(GetCountry value) {
        return new JAXBElement<GetCountry>(_GetCountry_QNAME, GetCountry.class, null, value);
    }

}
