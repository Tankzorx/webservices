/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dk.dtu.imm.fastmoney.types.CreditCardInfoType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tankz
 */
public class testGetItin {
    private final DatatypeFactory df;
    private final CreditCardInfoType creditCardInfo;
    
    public testGetItin() throws DatatypeConfigurationException {
        // Make dates with this.
        df = DatatypeFactory.newInstance();
        creditCardInfo = new CreditCardInfoType();
        creditCardInfo.setName("Bech Camilla");
        creditCardInfo.setNumber("50408822");
        
        CreditCardInfoType.ExpirationDate xp = new CreditCardInfoType.ExpirationDate();
        xp.setMonth(7);
        xp.setYear(9);
        creditCardInfo.setExpirationDate(xp);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        String uid = createItinerary("H");
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList> flights = new javax.xml.ws.Holder<>();
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList> hotels = new javax.xml.ws.Holder<>();
        getItinerary(uid, flights, hotels);
    }

    private static String createItinerary(java.lang.String name) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.createItinerary(name);
    }

    private static void getItinerary(java.lang.String uid, javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList> flights, javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList> hotels) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        port.getItinerary(uid, flights, hotels);
    }
}
