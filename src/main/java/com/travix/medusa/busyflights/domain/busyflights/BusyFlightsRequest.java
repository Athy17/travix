package com.travix.medusa.busyflights.domain.busyflights;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;

/**
 * @author krish
 */
public class BusyFlightsRequest {

  @NotNull
  @Size(max = 3, message = "Origin should not contain >3 characters.")
  private String origin;
  @NotNull
  @Size(max = 3, message = "Destination should not contain >3 characters.")
  private String destination;
  private ZonedDateTime departureDate;
  private ZonedDateTime returnDate;
  @Max(value = 4, message = "Maximum allowed passenger list is 4.")
  private int numberOfPassengers;

  public BusyFlightsRequest() {
    origin = "";
    destination = "";
    numberOfPassengers = 0;
  }

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
