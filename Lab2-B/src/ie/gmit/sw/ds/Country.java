//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2017.09.29 时间 09:57:42 AM IST 
//


package ie.gmit.sw.ds;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Country的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="Country">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Ireland"/>
 *     &lt;enumeration value="UK"/>
 *     &lt;enumeration value="US"/>
 *     &lt;enumeration value="France"/>
 *     &lt;enumeration value="Spain"/>
 *     &lt;enumeration value="Italy"/>
 *     &lt;enumeration value="Germany"/>
 *     &lt;enumeration value="Russia"/>
 *     &lt;enumeration value="China"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Country", namespace = "http://sw.gmit.ie/ds/")
@XmlEnum
public enum Country {

    @XmlEnumValue("Ireland")
    IRELAND("Ireland"),
    UK("UK"),
    US("US"),
    @XmlEnumValue("France")
    FRANCE("France"),
    @XmlEnumValue("Spain")
    SPAIN("Spain"),
    @XmlEnumValue("Italy")
    ITALY("Italy"),
    @XmlEnumValue("Germany")
    GERMANY("Germany"),
    @XmlEnumValue("Russia")
    RUSSIA("Russia"),
    @XmlEnumValue("China")
    CHINA("China");
    private final String value;

    Country(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Country fromValue(String v) {
        for (Country c: Country.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
