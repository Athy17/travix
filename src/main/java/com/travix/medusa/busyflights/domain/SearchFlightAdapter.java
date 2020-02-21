package com.travix.medusa.busyflights.domain;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

import java.util.List;

public interface SearchFlightAdapter {
    public List<BusyFlightsResponse> searchFlights(BusyFlightsRequest request);
}
