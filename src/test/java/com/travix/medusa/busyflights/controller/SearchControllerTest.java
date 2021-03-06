package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.FlightSearchAggregator;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SearchControllerTest {
  @Autowired
  private SearchController controller;

  @Autowired
  private FlightSearchAggregator aggregator;

  @Test
  public void testInvalidPassengerNumber() {
    BusyFlightsRequest request = new BusyFlightsRequest();
    request.setDepartureDate(ZonedDateTime.of(2020, 3, 12, 14, 12, 12, 0, ZoneId.systemDefault()));
    request.setNumberOfPassengers(5);
    request.setDestination("AMS");
    request.setOrigin("LHR");
    ResponseEntity response = controller.getFlights(request);
    assertThat(response.getStatusCode(), is(HttpStatus.BAD_REQUEST));
    assertThat(response.getBody().toString(), is("Maximum allowed passenger list is 4."));
  }

  @Test
  public void testInvalidDestination() {
    SearchController controller = new SearchController();
    BusyFlightsRequest request = new BusyFlightsRequest();
    request.setDepartureDate(ZonedDateTime.of(2020, 3, 12, 14, 12, 12, 0, ZoneId.systemDefault()));
    request.setNumberOfPassengers(4);
    request.setDestination("AMSs");
    request.setOrigin("LHR");
    ResponseEntity response = controller.getFlights(request);
    assertThat(response.getStatusCode(), is(HttpStatus.BAD_REQUEST));
    assertThat(response.getBody().toString(), is("Destination should not contain >3 characters."));
  }

  @Test
  public void testInvalidOrigin() {
    SearchController controller = new SearchController();
    BusyFlightsRequest request = new BusyFlightsRequest();
    request.setDepartureDate(ZonedDateTime.of(2020, 3, 12, 14, 12, 12, 0, ZoneId.systemDefault()));
    request.setNumberOfPassengers(4);
    request.setDestination("AMS");
    request.setOrigin("LHRs");
    ResponseEntity response = controller.getFlights(request);
    assertThat(response.getStatusCode(), is(HttpStatus.BAD_REQUEST));
    assertThat(response.getBody().toString(), is("Origin should not contain >3 characters."));
  }

}