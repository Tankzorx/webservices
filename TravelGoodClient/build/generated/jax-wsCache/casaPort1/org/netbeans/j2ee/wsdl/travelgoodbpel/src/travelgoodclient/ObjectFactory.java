
package org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Boolean_QNAME = new QName("http://j2ee.netbeans.org/wsdl/TravelGoodBPEL/src/TravelGoodClient", "boolean");
    private final static QName _NewElement_QNAME = new QName("http://j2ee.netbeans.org/wsdl/TravelGoodBPEL/src/TravelGoodClient", "newElement");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HotelList }
     * 
     */
    public HotelList createHotelList() {
        return new HotelList();
    }

    /**
     * Create an instance of {@link FlightList }
     * 
     */
    public FlightList createFlightList() {
        return new FlightList();
    }

    /**
     * Create an instance of {@link HotelList.HotelInfo }
     * 
     */
    public HotelList.HotelInfo createHotelListHotelInfo() {
        return new HotelList.HotelInfo();
    }

    /**
     * Create an instance of {@link FlightList.FlightInfo }
     * 
     */
    public FlightList.FlightInfo createFlightListFlightInfo() {
        return new FlightList.FlightInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://j2ee.netbeans.org/wsdl/TravelGoodBPEL/src/TravelGoodClient", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://j2ee.netbeans.org/wsdl/TravelGoodBPEL/src/TravelGoodClient", name = "newElement")
    public JAXBElement<String> createNewElement(String value) {
        return new JAXBElement<String>(_NewElement_QNAME, String.class, null, value);
    }

}
