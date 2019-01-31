//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.01.17 at 05:18:48 AM MSK 
//


package by.it.malishevskiy.jd02_09.beans;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for User complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="User">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="niсkname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ads" type="{http://beans.jd02_09.malishevskiy.it.by}Ads" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="login" use="required" type="{http://beans.jd02_09.malishevskiy.it.by}Login" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User", propOrder = {
    "name",
    "ni\u0441kname",
    "email",
    "ads"
})
public class User {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String niсkname;
    @XmlElement(required = true)
    protected String email;
    @XmlElement(required = true)
    protected List<Ads> ads;
    @XmlAttribute(name = "login", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String login;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the niсkname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNiсkname() {
        return niсkname;
    }

    /**
     * Sets the value of the niсkname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNiсkname(String value) {
        this.niсkname = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the ads property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ads property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ads }
     * 
     * 
     */
    public List<Ads> getAds() {
        if (ads == null) {
            ads = new ArrayList<Ads>();
        }
        return this.ads;
    }

    /**
     * Gets the value of the login property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the value of the login property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogin(String value) {
        this.login = value;
    }

    @Override
    public String toString() {
        return "\n\tUser{" +
                "name='" + name + '\'' +
                ", niсkname='" + niсkname + '\'' +
                ", email='" + email + '\'' +
                ", ads=" + ads +
                ", login='" + login + '\'' +
                '}';
    }
}