package com.travix.medusa.busyflights.domain.toughjet;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

public class ToughJetService {
    public List<ToughJetResponse> searchFlights(ToughJetRequest request) {
        ToughJetResponse flight1 = new ToughJetResponse();
        flight1.setBasePrice(120);
        flight1.setDiscount(0);
        flight1.setTax(12);
        flight1.setDepartureAirportName("LHR");
        flight1.setArrivalAirportName("AMS");
        flight1.setOutboundDateTime(ZonedDateTime.parse("2020-12-11T10:00:00"));
        return Arrays.asList(flight1, new ToughJetResponse(),new ToughJetResponse());
    }
}
