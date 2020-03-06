package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.SearchFlightAdapter;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for ToughJet
 * @author krish
 */

@Service
public class ToughJetService  implements SearchFlightAdapter {
  @Override
  public List<BusyFlightsResponse> searchFlights(BusyFlightsRequest request) {
    ToughJetRequest toughJetRequest = convertRequest(request);
    List<ToughJetResponse> toughJetResponses = getFlights(toughJetRequest);
    return toughJetResponses.stream()
            .map(this::toBusyFlightResponse)
            .collect(Collectors.toList());
  }

  public List<ToughJetResponse> getFlights(ToughJetRequest toughJetRequest) {
    List<ToughJetResponse> responses = new ArrayList<>();
    for (int i = 1; i <= 12; i++) {
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

  private ToughJetRequest convertRequest(BusyFlightsRequest request) {
    ToughJetRequest toughJetRequest = new ToughJetRequest();
    toughJetRequest.setFrom(request.getOrigin());
    toughJetRequest.setTo(request.getDestination());
    toughJetRequest.setInboundDate(request.getReturnDate());
    toughJetRequest.setOutboundDate(request.getDepartureDate());
    toughJetRequest.setNumberOfAdults(request.getNumberOfPassengers());
    return toughJetRequest;
  }

  private BusyFlightsResponse toBusyFlightResponse(ToughJetResponse item) {
    BusyFlightsResponse result = new BusyFlightsResponse();
    result.setAirline(item.getCarrier());
    result.setArrivalDate(item.getInboundDateTime());
    result.setDepartureAirportCode(item.getDepartureAirportName());
    result.setDestinationAirportCode(item.getArrivalAirportName());
    result.setDepartureDate(item.getOutboundDateTime());
    result.setSupplier("ToughJet");

    result.setFare(calculateFare(item.getBasePrice(), item.getTax(), item.getDiscount()));
    return result;
  }

  private double calculateFare(double basePrice, double tax, double discount) {
    double fare = (basePrice + tax) * (1 - discount);
    BigDecimal finalFare = BigDecimal.valueOf(fare);
    finalFare = finalFare.setScale(2, RoundingMode.HALF_UP);
    return finalFare.doubleValue();
  }
}
