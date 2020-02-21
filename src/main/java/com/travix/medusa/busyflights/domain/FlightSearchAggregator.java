package com.travix.medusa.busyflights.domain;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.services.CrazyAirServiceAdapter;
import com.travix.medusa.busyflights.services.ToughJetServiceAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Aggregator class to combine all the flight response into BusyFlightsResponse
 *
 * @author krish
 */
public class FlightSearchAggregator implements SearchFlightAdapter {
  List<SearchFlightAdapter> adapterList;

  public FlightSearchAggregator() {
    adapterList = new ArrayList<>();
    adapterList.add(new ToughJetServiceAdapter());
    adapterList.add(new CrazyAirServiceAdapter());
  }

  public List<BusyFlightsResponse> searchFlights(BusyFlightsRequest request) {
    return adapterList.stream().map(searchFlightAdapter -> searchFlightAdapter.searchFlights(request))
            .collect(Collectors.toList())
            .stream().flatMap(Collection::stream)
            .sorted(Comparator.comparingDouble(BusyFlightsResponse::getFare))
            .collect(Collectors.toList());

  }
}
