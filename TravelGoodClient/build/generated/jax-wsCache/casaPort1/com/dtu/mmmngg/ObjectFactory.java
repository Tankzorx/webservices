
package com.dtu.mmmngg;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.dtu.mmmngg package. 
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

    private final static QName _CancelFlights_QNAME = new QName("http://MMMNGG.dtu.com/", "cancelFlights");
    private final static QName _HelloResponse_QNAME = new QName("http://MMMNGG.dtu.com/", "helloResponse");
    private final static QName _GetFlightsResponse_QNAME = new QName("http://MMMNGG.dtu.com/", "getFlightsResponse");
    private final static QName _Hello_QNAME = new QName("http://MMMNGG.dtu.com/", "hello");
    private final static QName _BookFlights_QNAME = new QName("http://MMMNGG.dtu.com/", "bookFlights");
    private final static QName _GetFlights_QNAME = new QName("http://MMMNGG.dtu.com/", "getFlights");
    private final static QName _BookFlightsResponse_QNAME = new QName("http://MMMNGG.dtu.com/", "bookFlightsResponse");
    private final static QName _CancelFlightsResponse_QNAME = new QName("http://MMMNGG.dtu.com/", "cancelFlightsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.dtu.mmmngg
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFlights }
     * 
     */
    public GetFlights createGetFlights() {
        return new GetFlights();
    }

    /**
     * Create an instance of {@link BookFlightsResponse }
     * 
     */
    public BookFlightsResponse createBookFlightsResponse() {
        return new BookFlightsResponse();
    }

    /**
     * Create an instance of {@link CancelFlights }
     * 
     */
    public CancelFlights createCancelFlights() {
        return new CancelFlights();
    }

    /**
     * Create an instance of {@link CancelFlightsResponse }
     * 
     */
    public CancelFlightsResponse createCancelFlightsResponse() {
        return new CancelFlightsResponse();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link GetFlightsResponse }
     * 
     */
    public GetFlightsResponse createGetFlightsResponse() {
        return new GetFlightsResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link BookFlights }
     * 
     */
    public BookFlights createBookFlights() {
        return new BookFlights();
    }

    /**
     * Create an instance of {@link FlightObject }
     * 
     */
    public FlightObject createFlightObject() {
        return new FlightObject();
    }

    /**
     * Create an instance of {@link FlightInfoObject }
     * 
     */
    public FlightInfoObject createFlightInfoObject() {
        return new FlightInfoObject();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelFlights }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://MMMNGG.dtu.com/", name = "cancelFlights")
    public JAXBElement<CancelFlights> createCancelFlights(CancelFlights value) {
        return new JAXBElement<CancelFlights>(_CancelFlights_QNAME, CancelFlights.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://MMMNGG.dtu.com/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://MMMNGG.dtu.com/", name = "getFlightsResponse")
    public JAXBElement<GetFlightsResponse> createGetFlightsResponse(GetFlightsResponse value) {
        return new JAXBElement<GetFlightsResponse>(_GetFlightsResponse_QNAME, GetFlightsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://MMMNGG.dtu.com/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookFlights }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://MMMNGG.dtu.com/", name = "bookFlights")
    public JAXBElement<BookFlights> createBookFlights(BookFlights value) {
        return new JAXBElement<BookFlights>(_BookFlights_QNAME, BookFlights.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlights }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://MMMNGG.dtu.com/", name = "getFlights")
    public JAXBElement<GetFlights> createGetFlights(GetFlights value) {
        return new JAXBElement<GetFlights>(_GetFlights_QNAME, GetFlights.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookFlightsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://MMMNGG.dtu.com/", name = "bookFlightsResponse")
    public JAXBElement<BookFlightsResponse> createBookFlightsResponse(BookFlightsResponse value) {
        return new JAXBElement<BookFlightsResponse>(_BookFlightsResponse_QNAME, BookFlightsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelFlightsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://MMMNGG.dtu.com/", name = "cancelFlightsResponse")
    public JAXBElement<CancelFlightsResponse> createCancelFlightsResponse(CancelFlightsResponse value) {
        return new JAXBElement<CancelFlightsResponse>(_CancelFlightsResponse_QNAME, CancelFlightsResponse.class, null, value);
    }

}
