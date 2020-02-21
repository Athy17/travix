package com.travix.medusa.busyflights.domain.toughjet;

import java.time.ZonedDateTime;

public class ToughJetRequest {

    private String from;
    private String to;
    private ZonedDateTime outboundDate;
    private ZonedDateTime inboundDate;
    private int numberOfAdults;

    public String getFrom() {
        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public ZonedDateTime getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(final ZonedDateTime outboundDate) {
        this.outboundDate = outboundDate;
    }

    public ZonedDateTime getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(final ZonedDateTime inboundDate) {
        this.inboundDate = inboundDate;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(final int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }
}
