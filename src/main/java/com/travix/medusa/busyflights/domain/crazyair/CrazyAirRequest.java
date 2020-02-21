package com.travix.medusa.busyflights.domain.crazyair;

import java.time.ZonedDateTime;

/**
 * @author krish
 */
public class CrazyAirRequest {

  private String origin;
  private String destination;
  private ZonedDateTime departureDate;
  private ZonedDateTime returnDate;
  private int passengerCount;

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

  public int getPassengerCount() {
    return passengerCount;
  }

  public void setPassengerCount(final int passengerCount) {
    this.passengerCount = passengerCount;
  }
}
