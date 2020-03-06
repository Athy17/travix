package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.SearchFlightAdapter;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author krish
 */

@Service
public class CrazyAirService  implements SearchFlightAdapter {

  public List<BusyFlightsResponse> searchFlights(BusyFlightsRequest request) {
    CrazyAirRequest crazyAirRequest = convertRequest(request);
    List<CrazyAirResponse>  responses = getFlights(crazyAirRequest);
     return responses.stream()
             .map(this::convertResponse)
             .collect(Collectors.toList());
  }

  private List<CrazyAirResponse> getFlights(CrazyAirRequest request) {
    List<CrazyAirResponse> responses = new ArrayList<>();
    for (int i = 1; i <= 12; i++) {
      CrazyAirResponse flight1 = new CrazyAirResponse();
      flight1.setPrice(144.50);
      flight1.setAirline("CrazyAir");
      flight1.setCabinclass("B");
      flight1.setDepartureAirportCode("LHR");
      flight1.setDestinationAirportCode("DXB");
      flight1.setDepartureDate(ZonedDateTime.of(2020, i, 12, 14, 12, 12, 0, ZoneId.systemDefault()));
      flight1.setDepartureDate(flight1.getDepartureDate().plusMonths(2));
      responses.add(flight1);
    }

    return responses;
  }


  private CrazyAirRequest convertRequest(BusyFlightsRequest request) {
    CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
    crazyAirRequest.setOrigin(request.getOrigin());
    crazyAirRequest.setDestination(request.getDestination());
    crazyAirRequest.setReturnDate(request.getReturnDate());
    crazyAirRequest.setDepartureDate(request.getDepartureDate());
    crazyAirRequest.setPassengerCount(request.getNumberOfPassengers());
    return crazyAirRequest;
  }

  private BusyFlightsResponse convertResponse(CrazyAirResponse item) {
    BusyFlightsResponse result = new BusyFlightsResponse();
    result.setAirline(item.getAirline());
    result.setArrivalDate(item.getArrivalDate());
    result.setDepartureAirportCode(item.getDepartureAirportCode());
    result.setDestinationAirportCode(item.getDestinationAirportCode());
    result.setDepartureDate(item.getDepartureDate());
    result.setSupplier("CrazyAir");
    result.setFare(item.getPrice());
    return result;
  }
}
