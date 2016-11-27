
package com.dtu.mmmngg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for flightInfoObject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="flightInfoObject">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bookingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateOfTravel" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="FO" type="{http://MMMNGG.dtu.com/}flightObject" minOccurs="0"/>
 *         &lt;element name="nameOfAirline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flightInfoObject", propOrder = {
    "bookingNumber",
    "dateOfTravel",
    "fo",
    "nameOfAirline",
    "price"
})
public class FlightInfoObject {

    protected String bookingNumber;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateOfTravel;
    @XmlElement(name = "FO")
    protected FlightObject fo;
    protected String nameOfAirline;
    protected int price;

    /**
     * Gets the value of the bookingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingNumber() {
        return bookingNumber;
    }

    /**
     * Sets the value of the bookingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingNumber(String value) {
        this.bookingNumber = value;
    }

    /**
     * Gets the value of the dateOfTravel property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfTravel() {
        return dateOfTravel;
    }

    /**
     * Sets the value of the dateOfTravel property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfTravel(XMLGregorianCalendar value) {
        this.dateOfTravel = value;
    }

    /**
     * Gets the value of the fo property.
     * 
     * @return
     *     possible object is
     *     {@link FlightObject }
     *     
     */
    public FlightObject getFO() {
        return fo;
    }

    /**
     * Sets the value of the fo property.
     * 
     * @param value
     *     allowed object is
     *     {@link FlightObject }
     *     
     */
    public void setFO(FlightObject value) {
        this.fo = value;
    }

    /**
     * Gets the value of the nameOfAirline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOfAirline() {
        return nameOfAirline;
    }

    /**
     * Sets the value of the nameOfAirline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOfAirline(String value) {
        this.nameOfAirline = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(int value) {
        this.price = value;
    }

}
