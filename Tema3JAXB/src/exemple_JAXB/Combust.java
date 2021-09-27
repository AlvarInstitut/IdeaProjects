
package exemple_JAXB;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Combust.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Combust">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="gasolina"/>
 *     &lt;enumeration value="diesel"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Combust")
@XmlEnum
public enum Combust {

    @XmlEnumValue("gasolina")
    GASOLINA("gasolina"),
    @XmlEnumValue("diesel")
    DIESEL("diesel");
    private final String value;

    Combust(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Combust fromValue(String v) {
        for (Combust c: Combust.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
