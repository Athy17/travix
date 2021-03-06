package com.travix.medusa.busyflights.domain.crazyair;

import java.time.ZonedDateTime;

public class CrazyAirResponse {

  private String airline;
  private double price;
  private String cabinclass;
  private String departureAirportCode;
  private String destinationAirportCode;
  private ZonedDateTime departureDate;
  private ZonedDateTime arrivalDate;

  public String getAirline() {
    return airline;
  }

  public void setAirline(final String airline) {
    this.airline = airline;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(final double price) {
    this.price = price;
  }

  public String getCabinclass() {
    return cabinclass;
  }

  public void setCabinclass(final String cabinclass) {
    this.cabinclass = cabinclass;
  }

  public String getDepartureAirportCode() {
    return departureAirportCode;
  }

  public void setDepartureAirportCode(final String departureAirportCode) {
    this.departureAirportCode = departureAirportCode;
  }

  public String getDestinationAirportCode() {
    return destinationAirportCode;
  }

  public void setDestinationAirportCode(final String destinationAirportCode) {
    this.destinationAirportCode = destinationAirportCode;
  }

  public ZonedDateTime getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(final ZonedDateTime departureDate) {
    this.departureDate = departureDate;
  }

  public ZonedDateTime getArrivalDate() {
    return arrivalDate;
  }

  public void setArrivalDate(final ZonedDateTime arrivalDate) {
    this.arrivalDate = arrivalDate;
  }
}
