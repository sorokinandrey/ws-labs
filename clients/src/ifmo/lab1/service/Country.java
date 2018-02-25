
package ifmo.lab1.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for country complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="country">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="continent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="governmentForm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="headOfState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="localName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="population" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="region" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="surfaceArea" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "country", propOrder = {
        "code",
        "continent",
        "governmentForm",
        "headOfState",
        "id",
        "localName",
        "name",
        "population",
        "region",
        "surfaceArea"
})
public class Country {

    protected String code;
    protected String continent;
    protected String governmentForm;
    protected String headOfState;
    protected long id;
    protected String localName;
    protected String name;
    protected long population;
    protected String region;
    protected float surfaceArea;

    /**
     * Gets the value of the code property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the continent property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Sets the value of the continent property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setContinent(String value) {
        this.continent = value;
    }

    /**
     * Gets the value of the governmentForm property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGovernmentForm() {
        return governmentForm;
    }

    /**
     * Sets the value of the governmentForm property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGovernmentForm(String value) {
        this.governmentForm = value;
    }

    /**
     * Gets the value of the headOfState property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getHeadOfState() {
        return headOfState;
    }

    /**
     * Sets the value of the headOfState property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setHeadOfState(String value) {
        this.headOfState = value;
    }

    /**
     * Gets the value of the id property.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the localName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLocalName() {
        return localName;
    }

    /**
     * Sets the value of the localName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLocalName(String value) {
        this.localName = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the population property.
     */
    public long getPopulation() {
        return population;
    }

    /**
     * Sets the value of the population property.
     */
    public void setPopulation(long value) {
        this.population = value;
    }

    /**
     * Gets the value of the region property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRegion(String value) {
        this.region = value;
    }

    /**
     * Gets the value of the surfaceArea property.
     */
    public float getSurfaceArea() {
        return surfaceArea;
    }

    /**
     * Sets the value of the surfaceArea property.
     */
    public void setSurfaceArea(float value) {
        this.surfaceArea = value;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", continent='" + continent + '\'' +
                ", governmentForm='" + governmentForm + '\'' +
                ", headOfState='" + headOfState + '\'' +
                ", id=" + id +
                ", localName='" + localName + '\'' +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", region='" + region + '\'' +
                ", surfaceArea=" + surfaceArea +
                '}';
    }
}
