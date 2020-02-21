package com.travix.medusa.busyflights.domain.crazyair;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author krish
 */
public class CrazyAirService {

  public List<CrazyAirResponse> searchFlights(CrazyAirRequest request) {
    return populateDummyData();
  }

  public List<CrazyAirResponse> populateDummyData() {
    List<CrazyAirResponse> responses = new ArrayList<>();
    for (int i = 0; i <= 10; i++) {
      CrazyAirResponse flight1 = new CrazyAirResponse();
      flight1.setPrice(144.50);
      flight1.setAirline("ToughJet");
      flight1.setCabinclass("B");
      flight1.setDepartureAirportCode("LHR");
      flight1.setDestinationAirportCode("AMS");
      flight1.setDepartureDate(ZonedDateTime.of(2020, i, 12, 14, 12, 12, 0, ZoneId.systemDefault()));
      flight1.setDepartureDate(flight1.getDepartureDate().plusMonths(2));
      responses.add(flight1);
    }

    return responses;
  }
}
