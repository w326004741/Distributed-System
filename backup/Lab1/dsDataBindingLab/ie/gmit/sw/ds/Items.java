//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2017.09.29 时间 09:57:42 AM IST 
//


package ie.gmit.sw.ds;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Items complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Items">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="quantity">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger">
 *                         &lt;minInclusive value="1"/>
 *                         &lt;maxExclusive value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="shipDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="partNumber" type="{http://sw.gmit.ie/ds/}SKU" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Items", namespace = "http://sw.gmit.ie/ds/", propOrder = {
    "item"
})
public class Items {

    @XmlElement(namespace = "http://sw.gmit.ie/ds/")
    protected List<Items.Item> item;

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Items.Item }
     * 
     * 
     */
    public List<Items.Item> getItem() {
        if (item == null) {
            item = new ArrayList<Items.Item>();
        }
        return this.item;
    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="quantity">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger">
     *               &lt;minInclusive value="1"/>
     *               &lt;maxExclusive value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="shipDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="partNumber" type="{http://sw.gmit.ie/ds/}SKU" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "productName",
        "quantity",
        "price",
        "shipDate"
    })
    public static class Item {

        @XmlElement(namespace = "http://sw.gmit.ie/ds/", required = true)
        protected String productName;
        @XmlElement(namespace = "http://sw.gmit.ie/ds/")
        protected int quantity;
        @XmlElement(namespace = "http://sw.gmit.ie/ds/", required = true)
        protected BigDecimal price;
        @XmlElement(namespace = "http://sw.gmit.ie/ds/")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar shipDate;
        @XmlAttribute(name = "partNumber")
        protected String partNumber;

        /**
         * 获取productName属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProductName() {
            return productName;
        }

        /**
         * 设置productName属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProductName(String value) {
            this.productName = value;
        }

        /**
         * 获取quantity属性的值。
         * 
         */
        public int getQuantity() {
            return quantity;
        }

        /**
         * 设置quantity属性的值。
         * 
         */
        public void setQuantity(int value) {
            this.quantity = value;
        }

        /**
         * 获取price属性的值。
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getPrice() {
            return price;
        }

        /**
         * 设置price属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setPrice(BigDecimal value) {
            this.price = value;
        }

        /**
         * 获取shipDate属性的值。
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getShipDate() {
            return shipDate;
        }

        /**
         * 设置shipDate属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setShipDate(XMLGregorianCalendar value) {
            this.shipDate = value;
        }

        /**
         * 获取partNumber属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPartNumber() {
            return partNumber;
        }

        /**
         * 设置partNumber属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPartNumber(String value) {
            this.partNumber = value;
        }

    }

}
