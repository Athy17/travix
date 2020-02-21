package com.travix.medusa.busyflights.domain.busyflights;

import java.time.ZonedDateTime;

/**
 * @author krish
 */
public class BusyFlightsResponse {

  private String airline;
  private String supplier;
  private double fare;
  private String departureAirportCode;
  private String destinationAirportCode;
  private ZonedDateTime departureDate;
  private ZonedDateTime arrivalDate;

  public String getAirline() {
    return airline;
  }

  public void setAirline(String airline) {
    this.airline = airline;
  }

  public String getSupplier() {
    return supplier;
  }

  public void setSupplier(String supplier) {
    this.supplier = supplier;
  }

  public double getFare() {
    return fare;
  }

  public void setFare(double fare) {
    this.fare = fare;
  }

  public String getDepartureAirportCode() {
    return departureAirportCode;
  }

  public void setDepartureAirportCode(String departureAirportCode) {
    this.departureAirportCode = departureAirportCode;
  }

  public String getDestinationAirportCode() {
    return destinationAirportCode;
  }

  public void setDestinationAirportCode(String destinationAirportCode) {
    this.destinationAirportCode = destinationAirportCode;
  }

  public ZonedDateTime getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(ZonedDateTime departureDate) {
    this.departureDate = departureDate;
  }

  public ZonedDateTime getArrivalDate() {
    return arrivalDate;
  }

  public void setArrivalDate(ZonedDateTime arrivalDate) {
    this.arrivalDate = arrivalDate;
  }
}
