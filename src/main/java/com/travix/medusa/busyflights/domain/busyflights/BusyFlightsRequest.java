package com.travix.medusa.busyflights.domain.busyflights;

import java.time.ZonedDateTime;

/**
 * @author krish
 */
public class BusyFlightsRequest {

  private String origin;
  private String destination;
  private ZonedDateTime departureDate;
  private ZonedDateTime returnDate;
  private int numberOfPassengers;

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(final String origin) {
    this.origin = origin;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(final String destination) {
    this.destination = destination;
  }

  public ZonedDateTime getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(final ZonedDateTime departureDate) {
    this.departureDate = departureDate;
  }

  public ZonedDateTime getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(final ZonedDateTime returnDate) {
    this.returnDate = returnDate;
  }

  public int getNumberOfPassengers() {
    return numberOfPassengers;
  }

  public void setNumberOfPassengers(final int numberOfPassengers) {
    this.numberOfPassengers = numberOfPassengers;
  }
}
