package ru.asv.flights.model;


import lombok.Builder;
import lombok.Getter;



@Builder
@Getter
public class Flight {
    private final String dayOfMonth;

    private final String dayOfWeek;

    private final String flightDate;

    private final String uniqueCarrier;

    private final String tailNum;

    private final String originAirportID;

    private final String origin;

    private final String originStateName;

    private final String destAirportID;

    private final String dest;

    private final String destStateName;

    private final String depTime;

    private final String depDelay;

    private final String wheelsOff;

    private final String wheelsOn;

    private final String arrTime;

    private final String arrDelay;

    private final String cancelled;

    private final String cancellationCode;

    private final String diverted;

    private final String airTime;
    private final String distance;

}
