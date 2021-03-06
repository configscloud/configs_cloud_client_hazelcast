//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.22 at 07:46:10 PM IST 
//


package cloud.configs.hazelcast.dynamictemplate.v34.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for port complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="port">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>unsignedShort">
 *       &lt;attribute name="auto-increment" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="port-count" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" default="100" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "port", propOrder = {
    "value"
})
public class Port {

    @XmlValue
    @XmlSchemaType(name = "unsignedShort")
    protected int value;
    @XmlAttribute(name = "auto-increment")
    protected Boolean autoIncrement;
    @XmlAttribute(name = "port-count")
    @XmlSchemaType(name = "unsignedInt")
    protected Long portCount;

    /**
     * Gets the value of the value property.
     * 
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Gets the value of the autoIncrement property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isAutoIncrement() {
        if (autoIncrement == null) {
            return true;
        } else {
            return autoIncrement;
        }
    }

    /**
     * Sets the value of the autoIncrement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoIncrement(Boolean value) {
        this.autoIncrement = value;
    }

    /**
     * Gets the value of the portCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getPortCount() {
        if (portCount == null) {
            return  100L;
        } else {
            return portCount;
        }
    }

    /**
     * Sets the value of the portCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPortCount(Long value) {
        this.portCount = value;
    }

}
