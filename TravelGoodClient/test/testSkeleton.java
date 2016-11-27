/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.dtu.mmmngg.GetFlightsResponse;
import com.niceview.GetHotelsResponse;
import dk.dtu.imm.fastmoney.types.CreditCardInfoType;
import java.math.BigInteger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;
import travelgoodca.Fault;

/**
 *
 * @author Tankz
 */
public class testSkeleton {
    private final CreditCardInfoType card;
    private final DatatypeFactory df;
    
    public testSkeleton() throws DatatypeConfigurationException {
        // Make dates with this.
        df = DatatypeFactory.newInstance();
        card = new CreditCardInfoType();
        card.setName("Anne Strandberg");
        card.setNumber("50408816");
        CreditCardInfoType.ExpirationDate exp = new CreditCardInfoType.ExpirationDate();
        exp.setMonth(5);
        exp.setYear(9);
        card.setExpirationDate(exp);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testP1() {
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList> flights = new javax.xml.ws.Holder<>();
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList> hotels = new javax.xml.ws.Holder<>();
        String uid;
        Boolean isBooked;
        Boolean status;
        XMLGregorianCalendar hotelDep = df.newXMLGregorianCalendar("2016-12-27");        
        XMLGregorianCalendar hotelArr = df.newXMLGregorianCalendar("2016-12-15");
        XMLGregorianCalendar flightDate = df.newXMLGregorianCalendar("2016-11-10");
        String fromDestination = "Copenhagen";
        String toDestination = "Amsterdam";
        
        uid = createItinerary("");
        cancelItinerary(uid);
        getItinerary(uid, flights, hotels);
        
        
        
        
    }

    private static boolean addFlight(java.lang.String uid, java.lang.String bookingNumber, javax.xml.datatype.XMLGregorianCalendar departure, java.math.BigInteger price) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.addFlight(uid, bookingNumber, departure, price);
    }

    private static boolean addHotel(java.lang.String uid, java.math.BigInteger bookingNumber, java.math.BigInteger price) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.addHotel(uid, bookingNumber, price);
    }

    private static boolean bookItinerary(java.lang.String uid, dk.dtu.imm.fastmoney.types.CreditCardInfoType ccInfo) throws Fault {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.bookItinerary(uid, ccInfo);
    }

    private static boolean cancelItinerary(java.lang.String uid) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.cancelItinerary(uid);
    }

    private static boolean cancelItineraryPostPlanning(java.lang.String uid, dk.dtu.imm.fastmoney.types.CreditCardInfoType ccInfo) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.cancelItineraryPostPlanning(uid, ccInfo);
    }

    private static String createItinerary(java.lang.String name) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.createItinerary(name);
    }

    private static GetFlightsResponse getFlights(java.lang.String uid, java.lang.String from, java.lang.String to, javax.xml.datatype.XMLGregorianCalendar departureDate) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.getFlights(uid, from, to, departureDate);
    }

    private static GetHotelsResponse getHotels(java.lang.String uid, javax.xml.datatype.XMLGregorianCalendar arrivalDate, javax.xml.datatype.XMLGregorianCalendar departureDate, java.lang.String city) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.getHotels(uid, arrivalDate, departureDate, city);
    }

    private static void getItinerary(java.lang.String uid, javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList> flights, javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList> hotels) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        port.getItinerary(uid, flights, hotels);
    }

    private static void getItineraryPostPlanning(java.lang.String uid, javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList> flights, javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList> hotels) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        port.getItineraryPostPlanning(uid, flights, hotels);
    }
}
