//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2017.09.29 时间 09:57:42 AM IST 
//


package ie.gmit.sw.ds;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * <p>PurchaseOrder complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PurchaseOrder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="shipTo" type="{http://sw.gmit.ie/ds/}Address"/>
 *         &lt;element name="billTo" type="{http://sw.gmit.ie/ds/}Address"/>
 *         &lt;element name="items" type="{http://sw.gmit.ie/ds/}Items"/>
 *       &lt;/sequence>
 *       &lt;attribute name="orderNumber" use="required" type="{http://sw.gmit.ie/ds/}OrderNumber" />
 *       &lt;attribute name="orderDate" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PurchaseOrder", namespace = "http://sw.gmit.ie/ds/", propOrder = {
    "shipTo",
    "billTo",
    "items"
})
 @XmlRootElement
public class PurchaseOrder {

    @XmlElement(namespace = "http://sw.gmit.ie/ds/", required = true)
    protected Address shipTo;
    @XmlElement(namespace = "http://sw.gmit.ie/ds/", required = true)
    protected Address billTo;
    @XmlElement(namespace = "http://sw.gmit.ie/ds/", required = true)
    protected Items items;
    @XmlAttribute(name = "orderNumber", required = true)
    protected String orderNumber;
    @XmlAttribute(name = "orderDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar orderDate;

    /**
     * 获取shipTo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getShipTo() {
        return shipTo;
    }

    /**
     * 设置shipTo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setShipTo(Address value) {
        this.shipTo = value;
    }

    /**
     * 获取billTo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getBillTo() {
        return billTo;
    }

    /**
     * 设置billTo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setBillTo(Address value) {
        this.billTo = value;
    }

    /**
     * 获取items属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Items }
     *     
     */
    public Items getItems() {
        return items;
    }

    /**
     * 设置items属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Items }
     *     
     */
    public void setItems(Items value) {
        this.items = value;
    }

    /**
     * 获取orderNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置orderNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderNumber(String value) {
        this.orderNumber = value;
    }

    /**
     * 获取orderDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrderDate() {
        return orderDate;
    }

    /**
     * 设置orderDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrderDate(XMLGregorianCalendar value) {
        this.orderDate = value;
    }

}
