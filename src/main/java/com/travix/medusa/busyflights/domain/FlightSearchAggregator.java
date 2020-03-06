package com.travix.medusa.busyflights.domain;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Aggregator class to combine all the flight response into BusyFlightsResponse
 *
 * @author krish
 */

@Component
public class FlightSearchAggregator implements SearchFlightAdapter {
  private List<SearchFlightAdapter> adapterList;

  public FlightSearchAggregator(List<SearchFlightAdapter> adapterList) {
    this.adapterList = adapterList;
  }

  public List<BusyFlightsResponse> searchFlights(BusyFlightsRequest request) {
    return adapterList.stream().map(searchFlightAdapter -> searchFlightAdapter.searchFlights(request))
            .flatMap(Collection::stream)
            .sorted(Comparator.comparingDouble(BusyFlightsResponse::getFare))
            .collect(Collectors.toList());
  }
}
