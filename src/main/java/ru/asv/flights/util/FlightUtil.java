package ru.asv.flights.util;


import ru.asv.flights.model.Flight;

public class FlightUtil {

    //метод собирает объект типа FlightObjet для дальнейшего использования
    public static Flight createFO(String[] fields) {
        Flight fo = Flight.builder()
                .dayOfMonth(fields[0])
                .dayOfWeek(fields[1])
                .flightDate(fields[2])
                .uniqueCarrier(fields[3])
                .tailNum(fields[4])
                .originAirportID(fields[5])
                .origin(fields[6])
                .originStateName(fields[7])
                .destAirportID(fields[8])
                .dest(fields[9])
                .destStateName(fields[10])
                .depTime(fields[11])
                .depDelay(fields[12])
                .wheelsOff(fields[13])
                .wheelsOn(fields[14])
                .arrTime(fields[15])
                .arrDelay(fields[16])
                .cancelled(fields[17])
                .cancellationCode(fields[18])
                .diverted(fields[19])
                .airTime(fields[20])
                .distance(fields[21]).build();
        return fo;
    }
}
