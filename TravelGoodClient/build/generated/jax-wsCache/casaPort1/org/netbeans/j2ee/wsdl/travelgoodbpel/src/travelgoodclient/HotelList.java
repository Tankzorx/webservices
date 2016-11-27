
package org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for hotelList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="hotelList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hotelInfo" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="bookingNumber" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
@XmlType(name = "hotelList", propOrder = {
    "hotelInfo"
})
public class HotelList {

    @XmlElement(required = true)
    protected List<HotelList.HotelInfo> hotelInfo;

    /**
     * Gets the value of the hotelInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hotelInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotelInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HotelList.HotelInfo }
     * 
     * 
     */
    public List<HotelList.HotelInfo> getHotelInfo() {
        if (hotelInfo == null) {
            hotelInfo = new ArrayList<HotelList.HotelInfo>();
        }
        return this.hotelInfo;
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
     *         &lt;element name="bookingNumber" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
        "bookingNumber",
        "isBooked"
    })
    public static class HotelInfo {

        @XmlElement(required = true)
        protected BigInteger price;
        @XmlElement(required = true)
        protected BigInteger bookingNumber;
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
         * Gets the value of the bookingNumber property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBookingNumber() {
            return bookingNumber;
        }

        /**
         * Sets the value of the bookingNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBookingNumber(BigInteger value) {
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
