//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.22 at 07:46:10 PM IST 
//


package cloud.configs.hazelcast.dynamictemplate.v34.schema;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cache-eviction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cache-eviction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="size" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" default="10000" />
 *       &lt;attribute name="max-size-policy" type="{http://www.hazelcast.com/schema/config}cache-max-size-policy" default="ENTRY_COUNT" />
 *       &lt;attribute name="eviction-policy" type="{http://www.hazelcast.com/schema/config}eviction-policy" default="LRU" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cache-eviction")
public class CacheEviction {

    @XmlAttribute(name = "size")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger size;
    @XmlAttribute(name = "max-size-policy")
    protected CacheMaxSizePolicy maxSizePolicy;
    @XmlAttribute(name = "eviction-policy")
    protected EvictionPolicy evictionPolicy;

    /**
     * Gets the value of the size property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSize() {
        if (size == null) {
            return new BigInteger("10000");
        } else {
            return size;
        }
    }

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSize(BigInteger value) {
        this.size = value;
    }

    /**
     * Gets the value of the maxSizePolicy property.
     * 
     * @return
     *     possible object is
     *     {@link CacheMaxSizePolicy }
     *     
     */
    public CacheMaxSizePolicy getMaxSizePolicy() {
        if (maxSizePolicy == null) {
            return CacheMaxSizePolicy.ENTRY_COUNT;
        } else {
            return maxSizePolicy;
        }
    }

    /**
     * Sets the value of the maxSizePolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link CacheMaxSizePolicy }
     *     
     */
    public void setMaxSizePolicy(CacheMaxSizePolicy value) {
        this.maxSizePolicy = value;
    }

    /**
     * Gets the value of the evictionPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link EvictionPolicy }
     *     
     */
    public EvictionPolicy getEvictionPolicy() {
        if (evictionPolicy == null) {
            return EvictionPolicy.LRU;
        } else {
            return evictionPolicy;
        }
    }

    /**
     * Sets the value of the evictionPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link EvictionPolicy }
     *     
     */
    public void setEvictionPolicy(EvictionPolicy value) {
        this.evictionPolicy = value;
    }

}
