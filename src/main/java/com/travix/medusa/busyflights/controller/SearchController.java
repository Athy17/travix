package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.FlightSearchAggregator;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Rest controller for the search
 *
 * @author krish
 */
@RestController
public class SearchController {

  FlightSearchAggregator aggregator;

  public SearchController() {
    aggregator = new FlightSearchAggregator();
  }

  @GetMapping("/search/flights")
  public ResponseEntity getFlights(BusyFlightsRequest request) {
    ResponseEntity response = validate(request);
    if (response.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
      return response;
    }
    request.setDepartureDate(ZonedDateTime.of(2020, 3, 12, 14, 12, 12, 0, ZoneId.systemDefault()));
    request.setNumberOfPassengers(5);
    request.setDestination("AMS");
    request.setOrigin("LHR");
    request.setReturnDate(request.getDepartureDate().plusDays(6));

    List<BusyFlightsResponse> busyFlightsResponses = aggregator.searchFlights(request);
    return ResponseEntity.ok(busyFlightsResponses);
  }

  private ResponseEntity validate(BusyFlightsRequest request) {
    StringBuilder message = new StringBuilder();
    if (request.getNumberOfPassengers() > 4) {
      message.append("Maximum allowed passenger list is 4.");
    }
    if (!StringUtils.isEmpty(request.getOrigin()) && request.getOrigin().length() > 3) {
      message.append("Origin should not contain >3 characters.");
    }
    if (!StringUtils.isEmpty(request.getDestination()) && request.getDestination().length() > 3) {
      message.append("Destination should not contain >3 characters.");
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
  }

}
