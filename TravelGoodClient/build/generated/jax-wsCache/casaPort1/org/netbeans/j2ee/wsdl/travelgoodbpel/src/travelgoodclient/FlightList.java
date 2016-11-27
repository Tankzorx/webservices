
package org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for flightList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="flightList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="flightInfo" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="departure" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="bookingNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="isBooked" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                 &lt;/sequence>
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
@XmlType(name = "flightList", propOrder = {
    "flightInfo"
})
public class FlightList {

    @XmlElement(required = true)
    protected List<FlightList.FlightInfo> flightInfo;

    /**
     * Gets the value of the flightInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flightInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlightInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FlightList.FlightInfo }
     * 
     * 
     */
    public List<FlightList.FlightInfo> getFlightInfo() {
        if (flightInfo == null) {
            flightInfo = new ArrayList<FlightList.FlightInfo>();
        }
        return this.flightInfo;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *         &lt;element name="departure" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="bookingNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="isBooked" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "price",
        "departure",
        "bookingNumber",
        "isBooked"
    })
    public static class FlightInfo {

        @XmlElement(required = true)
        protected BigInteger price;
        @XmlElement(required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar departure;
        @XmlElement(required = true)
        protected String bookingNumber;
        protected boolean isBooked;

        /**
         * Gets the value of the price property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getPrice() {
            return price;
        }

        /**
         * Sets the value of the price property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setPrice(BigInteger value) {
            this.price = value;
        }

        /**
         * Gets the value of the departure property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDeparture() {
            return departure;
        }

        /**
         * Sets the value of the departure property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDeparture(XMLGregorianCalendar value) {
            this.departure = value;
        }

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
         * Gets the value of the isBooked property.
         * 
         */
        public boolean isIsBooked() {
            return isBooked;
        }

        /**
         * Sets the value of the isBooked property.
         * 
         */
        public void setIsBooked(boolean value) {
            this.isBooked = value;
        }

    }

}
