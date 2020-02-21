package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.FlightSearchAggregator;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author krish
 */
@RestController
public class SearchController {

  FlightSearchAggregator aggregator;
  BusyFlightsRequest request;

  public SearchController() {
    aggregator = new FlightSearchAggregator();
    request = new BusyFlightsRequest();
  }

  @GetMapping("/search/flights")
  public List<BusyFlightsResponse> getFlights() {
    request.setNumberOfPassengers(5);
    return aggregator.searchFlights(request);
  }

}
