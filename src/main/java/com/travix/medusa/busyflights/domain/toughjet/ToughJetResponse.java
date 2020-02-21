package com.travix.medusa.busyflights.domain.toughjet;

import java.time.ZonedDateTime;

public class ToughJetResponse {

    private String carrier;
    private double basePrice;
    private double tax;
    private double discount;
    private String departureAirportName;
    private String arrivalAirportName;
    private ZonedDateTime outboundDateTime;
    private ZonedDateTime inboundDateTime;

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(final String carrier) {
        this.carrier = carrier;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(final double basePrice) {
        this.basePrice = basePrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(final double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(final double discount) {
        this.discount = discount;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(final String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(final String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public ZonedDateTime getOutboundDateTime() {
        return outboundDateTime;
    }

    public void setOutboundDateTime(final ZonedDateTime outboundDateTime) {
        this.outboundDateTime = outboundDateTime;
    }

    public ZonedDateTime getInboundDateTime() {
        return inboundDateTime;
    }

    public void setInboundDateTime(final ZonedDateTime inboundDateTime) {
        this.inboundDateTime = inboundDateTime;
    }
}
