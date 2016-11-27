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
import org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList.FlightInfo;
import org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList.HotelInfo;
import travelgoodca.Fault;

/**
 *
 * @author Tankz
 */
public class MandatoryTests {
    private final CreditCardInfoType card;
    private final DatatypeFactory df;
    
    public MandatoryTests() throws DatatypeConfigurationException {
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
    public void testP1() throws Fault {
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList> flights = new javax.xml.ws.Holder<>();
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList> hotels = new javax.xml.ws.Holder<>();
        String uid;
        Boolean status;
        XMLGregorianCalendar hotelDep = df.newXMLGregorianCalendar("2016-12-27");        
        XMLGregorianCalendar hotelArr = df.newXMLGregorianCalendar("2016-12-15");
        XMLGregorianCalendar flightDate = df.newXMLGregorianCalendar("2016-11-10");
        String fromDestination = "Copenhagen";
        String toDestination = "Amsterdam";
        String hotelCity = "Copenhagen";
        GetFlightsResponse flightResp;
        GetHotelsResponse hotelResp;
                
        // Create Itinerary
        uid = createItinerary("");
        assertTrue(uid.length() > 5);
        
        // Get and add a flight.
        flightResp = getFlights(uid, fromDestination,toDestination,flightDate);
        status = addFlight(uid, flightResp.getReturn().get(0).getBookingNumber(),
                flightResp.getReturn().get(0).getDateOfTravel(), 
                BigInteger.valueOf(flightResp.getReturn().get(0).getPrice()));
        
        assertTrue(status);
        
        // Get and add a hotel.
        hotelResp = getHotels(uid, hotelArr, hotelDep, hotelCity);
        status = addHotel(uid, BigInteger.valueOf(hotelResp.getReturn().get(0).getBookingNumber()),
                BigInteger.valueOf(1));
        
        assertTrue(status);
        
        // Get and add a flight.
        flightResp = getFlights(uid, fromDestination,toDestination,flightDate);
        status = addFlight(uid, flightResp.getReturn().get(0).getBookingNumber(),
                flightResp.getReturn().get(0).getDateOfTravel(), 
                BigInteger.valueOf(flightResp.getReturn().get(0).getPrice()));
        
        assertTrue(status);
        
        // Get and add a flight.
        flightResp = getFlights(uid, fromDestination,toDestination,flightDate);
        status = addFlight(uid, flightResp.getReturn().get(0).getBookingNumber(),
                flightResp.getReturn().get(0).getDateOfTravel(), 
                BigInteger.valueOf(flightResp.getReturn().get(0).getPrice()));
        
        assertTrue(status);
        
        // Get and add a hotel.
        hotelResp = getHotels(uid, hotelArr, hotelDep, hotelCity);
        status = addHotel(uid, BigInteger.valueOf(hotelResp.getReturn().get(0).getBookingNumber()),
                BigInteger.valueOf(1));
        
        assertTrue(status);
        
        // Get the Itinerary
        getItinerary(uid, flights, hotels);
        for (FlightInfo col : flights.value.getFlightInfo()) {
            assertFalse(col.isIsBooked());
        }
        
        for (HotelInfo col : hotels.value.getHotelInfo()) {
            assertFalse(col.isIsBooked());
        }
        // Verify length of flight/hotel list.
        assertEquals(3, flights.value.getFlightInfo().size());
        assertEquals(2, hotels.value.getHotelInfo().size());
        
        status = bookItinerary(uid, card);
        assertTrue(status);
        
        
        
        getItineraryPostPlanning(uid, flights, hotels);
        for (FlightInfo col : flights.value.getFlightInfo()) {
            assertTrue(col.isIsBooked());
        }
        
        for (HotelInfo col : hotels.value.getHotelInfo()) {
            assertTrue(col.isIsBooked());
        }
        // Verify length of flight/hotel list post-planning.
        assertEquals(3, flights.value.getFlightInfo().size());
        assertEquals(2, hotels.value.getHotelInfo().size());
    }
    
    @Test
    public void P2() {
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList> flights = new javax.xml.ws.Holder<>();
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList> hotels = new javax.xml.ws.Holder<>();
        String uid;
        Boolean isBooked;
        Boolean status;
        XMLGregorianCalendar flightDate = df.newXMLGregorianCalendar("2016-11-10");
        String fromDestination = "Copenhagen";
        String toDestination = "Amsterdam";
        GetFlightsResponse flightResp;
        
        uid = createItinerary("");
        
        // Get and add a flight.
        flightResp = getFlights(uid, fromDestination,toDestination,flightDate);
        status = addFlight(uid, flightResp.getReturn().get(0).getBookingNumber(),
                flightResp.getReturn().get(0).getDateOfTravel(), 
                BigInteger.valueOf(flightResp.getReturn().get(0).getPrice()));
        
        assertTrue(status);
        
        status = cancelItinerary(uid);
        assertTrue(status);
    }
    
    @Test
    public void B() {
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList> flights = new javax.xml.ws.Holder<>();
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList> hotels = new javax.xml.ws.Holder<>();
        String uid;
        Boolean isBooked;
        Boolean status;
        XMLGregorianCalendar flightDate = df.newXMLGregorianCalendar("2016-11-10");
        XMLGregorianCalendar hotelDep = df.newXMLGregorianCalendar("2016-12-27");        
        XMLGregorianCalendar hotelArr = df.newXMLGregorianCalendar("2016-12-15");
        String fromDestination = "Copenhagen";
        String toDestination = "Amsterdam";
        String hotelCity = "Copenhagen";
        GetFlightsResponse flightResp;
        GetHotelsResponse hotelResp;
        
        uid = createItinerary("");
        
        // Get and add a flight.
        flightResp = getFlights(uid, fromDestination,toDestination,flightDate);
        status = addFlight(uid, flightResp.getReturn().get(0).getBookingNumber(),
                flightResp.getReturn().get(0).getDateOfTravel(), 
                BigInteger.valueOf(flightResp.getReturn().get(0).getPrice()));
        
        assertTrue(status);
        
        // Get and add a flight.
        flightResp = getFlights(uid, fromDestination,toDestination,flightDate);
        status = addFlight(uid, "THISDOESNTEXIST",
                flightResp.getReturn().get(0).getDateOfTravel(), 
                BigInteger.valueOf(flightResp.getReturn().get(0).getPrice()));
        
        assertTrue(status);
        
        // Get and add a hotel.
        hotelResp = getHotels(uid, hotelArr, hotelDep, hotelCity);
        status = addHotel(uid, BigInteger.valueOf(hotelResp.getReturn().get(0).getBookingNumber()),
                BigInteger.valueOf(1));
        
        assertTrue(status);
        
        getItinerary(uid, flights, hotels);
        for (FlightInfo col : flights.value.getFlightInfo()) {
            assertFalse(col.isIsBooked());
        }
        
        for (HotelInfo col : hotels.value.getHotelInfo()) {
            assertFalse(col.isIsBooked());
        }
        Boolean bookingFailed = false;
        try {
            bookItinerary(uid, card);
        } catch (Exception e) {
            bookingFailed = true;
        }
        assertTrue(bookingFailed);
        
        getItinerary(uid, flights, hotels);
        for (FlightInfo col : flights.value.getFlightInfo()) {
            assertFalse(col.isIsBooked());
        }
        
        for (HotelInfo col : hotels.value.getHotelInfo()) {
            assertFalse(col.isIsBooked());
        }
    }
    
    @Test
    public void C1() throws Fault {
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList> flights = new javax.xml.ws.Holder<>();
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList> hotels = new javax.xml.ws.Holder<>();
        String uid;
        Boolean isBooked;
        Boolean status;
        XMLGregorianCalendar flightDate = df.newXMLGregorianCalendar("2016-11-10");
        XMLGregorianCalendar hotelDep = df.newXMLGregorianCalendar("2016-12-27");        
        XMLGregorianCalendar hotelArr = df.newXMLGregorianCalendar("2016-12-15");
        String fromDestination = "Copenhagen";
        String toDestination = "Amsterdam";
        String hotelCity = "Copenhagen";
        GetFlightsResponse flightResp;
        GetHotelsResponse hotelResp;
        
        uid = createItinerary("");
        
        // Get and add a flight.
        flightResp = getFlights(uid, fromDestination,toDestination,flightDate);
        status = addFlight(uid, flightResp.getReturn().get(0).getBookingNumber(),
                flightResp.getReturn().get(0).getDateOfTravel(), 
                BigInteger.valueOf(flightResp.getReturn().get(0).getPrice()));
        
        assertTrue(status);
        
        // Get and add a hotel.
        hotelResp = getHotels(uid, hotelArr, hotelDep, hotelCity);
        status = addHotel(uid, BigInteger.valueOf(hotelResp.getReturn().get(0).getBookingNumber()),
                BigInteger.valueOf(1));
        
        assertTrue(status);
        
        // Get and add a flight.
        flightResp = getFlights(uid, fromDestination,toDestination,flightDate);
        status = addFlight(uid, flightResp.getReturn().get(0).getBookingNumber(),
                flightResp.getReturn().get(0).getDateOfTravel(), 
                BigInteger.valueOf(flightResp.getReturn().get(0).getPrice()));
        
        assertTrue(status);
        
        status = bookItinerary(uid, card);
        
        assertTrue(status);
        
        getItineraryPostPlanning(uid, flights, hotels);
        for (FlightInfo col : flights.value.getFlightInfo()) {
            assertTrue(col.isIsBooked());
        }
        
        for (HotelInfo col : hotels.value.getHotelInfo()) {
            assertTrue(col.isIsBooked());
        }
        
        status = cancelItineraryPostPlanning(uid, card);
        assertTrue(status);
        
        getItineraryPostPlanning(uid, flights, hotels);
        for (FlightInfo col : flights.value.getFlightInfo()) {
            assertFalse(col.isIsBooked());
        }
        
        for (HotelInfo col : hotels.value.getHotelInfo()) {
            assertFalse(col.isIsBooked());
        }
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

    private static boolean bookItinerary(java.lang.String uid, dk.dtu.imm.fastmoney.types.CreditCardInfoType ccInfo) throws Fault {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.bookItinerary(uid, ccInfo);
    }
}
