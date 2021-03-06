package ifmo.lab1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Builder
public class Country {
    public static final String KEY_CODE = "code";
    public static final String KEY_NAME = "name";
    public static final String KEY_CONTINENT = "continent";
    public static final String KEY_REGION = "region";
    public static final String KEY_SURFACE_AREA = "surfacearea";
    public static final String KEY_POPULATION = "population";
    public static final String KEY_LOCAL_NAME = "localname";
    public static final String KEY_GOVERNMENT_FORM = "governmentform";
    public static final String KEY_HEAD_OF_STATE = "headofstate";
    public static final String KEY_CODE2 = "code2";

    public static final String[] STRING_KEYS = {KEY_CODE, KEY_NAME, KEY_CONTINENT, KEY_REGION, KEY_LOCAL_NAME, KEY_GOVERNMENT_FORM, KEY_HEAD_OF_STATE};
    public static final String[] NUMBER_KEYS = {KEY_SURFACE_AREA, KEY_POPULATION};

    private String code;
    private String name;
    private String continent;
    private String region;
    private float surfaceArea;
    private long population;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private String code2 = "";
}
