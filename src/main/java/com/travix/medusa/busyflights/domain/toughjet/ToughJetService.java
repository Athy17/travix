package com.travix.medusa.busyflights.domain.toughjet;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Service for ToughJet
 * @author krish
 */
public class ToughJetService {
  public List<ToughJetResponse> searchFlights(ToughJetRequest request) {
    return populateDummyData();
  }

  public List<ToughJetResponse> populateDummyData() {
    List<ToughJetResponse> responses = new ArrayList<>();
    for (int i = 0; i <= 10; i++) {
      ToughJetResponse flight1 = new ToughJetResponse();
      flight1.setBasePrice(120);
      flight1.setDiscount(0);
      flight1.setTax(12);
      flight1.setDepartureAirportName("LHR");
      flight1.setArrivalAirportName("AMS");
      flight1.setOutboundDateTime(ZonedDateTime.of(2020, i, 12, 14, 12, 12, 0, ZoneId.systemDefault()));
      responses.add(flight1);
    }

    return responses;
  }
}
