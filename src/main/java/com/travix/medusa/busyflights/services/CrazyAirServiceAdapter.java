package com.travix.medusa.busyflights.services;

import com.travix.medusa.busyflights.domain.SearchFlightAdapter;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Adapter for CrazyAir
 * @author krish
 */
public class CrazyAirServiceAdapter implements SearchFlightAdapter {

  CrazyAirService service;

  public CrazyAirServiceAdapter() {
    service = new CrazyAirService();
  }

  @Override
  public List<BusyFlightsResponse> searchFlights(BusyFlightsRequest request) {
    CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
    crazyAirRequest.setOrigin(request.getOrigin());
    crazyAirRequest.setDestination(request.getDestination());
    crazyAirRequest.setReturnDate(request.getReturnDate());
    crazyAirRequest.setDepartureDate(request.getDepartureDate());
    crazyAirRequest.setPassengerCount(request.getNumberOfPassengers());
    List<CrazyAirResponse> crazyAirResponses = service.searchFlights(crazyAirRequest);

    return crazyAirResponses.stream().map(this::toBusyFlightResponse).collect(Collectors.toList());
  }

  private BusyFlightsResponse toBusyFlightResponse(CrazyAirResponse item) {
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
