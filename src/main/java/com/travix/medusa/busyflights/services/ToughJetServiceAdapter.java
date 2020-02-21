package com.travix.medusa.busyflights.services;

import com.travix.medusa.busyflights.domain.SearchFlightAdapter;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

public class ToughJetServiceAdapter implements SearchFlightAdapter {

    ToughJetService service;

    public ToughJetServiceAdapter() {
        service = new ToughJetService();
    }


    @Override
    public List<BusyFlightsResponse> searchFlights(BusyFlightsRequest request) {
        ToughJetRequest toughJetRequest = new ToughJetRequest();
        toughJetRequest.setFrom(request.getOrigin());
        toughJetRequest.setTo(request.getDestination());
        toughJetRequest.setInboundDate(request.getReturnDate());
        toughJetRequest.setOutboundDate(request.getDepartureDate());
        toughJetRequest.setNumberOfAdults(request.getNumberOfPassengers());
        List<ToughJetResponse> toughJetResponses = service.searchFlights(toughJetRequest);

        return toughJetResponses.stream().map(this::toBusyFlightResponse).collect(Collectors.toList());
    }

    private BusyFlightsResponse toBusyFlightResponse(ToughJetResponse item) {
        BusyFlightsResponse result = new BusyFlightsResponse();
        result.setAirline(item.getCarrier());
        result.setArrivalDate(item.getInboundDateTime());
        result.setDepartureAirportCode(item.getDepartureAirportName());
        result.setDestinationAirportCode(item.getArrivalAirportName());
        result.setDepartureDate(item.getOutboundDateTime());
        result.setSupplier("ToughJet");
        double fare = (item.getBasePrice() + item.getTax()) * (1 - item.getDiscount());
        BigDecimal bd = BigDecimal.valueOf(fare);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        result.setFare(bd.doubleValue());
        return result;
    }
}
