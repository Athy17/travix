package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.FlightSearchAggregator;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Rest controller for the search
 *
 * @author krish
 */
@RestController
@Validated
public class SearchController {

  @Autowired
  private FlightSearchAggregator aggregator;

  @GetMapping("/search/flights")
  public ResponseEntity getFlights(@Valid BusyFlightsRequest request) {
    List<BusyFlightsResponse> busyFlightsResponses = aggregator.searchFlights(request);
    return ResponseEntity.ok(busyFlightsResponses);
  }
}
