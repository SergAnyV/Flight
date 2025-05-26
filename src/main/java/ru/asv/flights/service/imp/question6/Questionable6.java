package ru.asv.flights.service.imp.question6;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.asv.flights.repository.DataReadable;
import ru.asv.flights.service.Questionable;
import ru.asv.flights.service.imp.question5.GeneratorMapsAiroportDestAndOriginal;


import java.util.Map;

@Component
@Getter
public class Questionable6 implements Questionable {
    private String result;

    public Questionable6(DataReadable dataReaderCSV) {
        GeneratorMapsAiroportDestAndOriginal mgADO = new GeneratorMapsAiroportDestAndOriginal(dataReaderCSV);
        Map<String, Integer> mapAiroprDest = mgADO.getMapAiroportDest();
        Map<String, Integer> mapAiroprtOrig = mgADO.getMapAiroportOriginal();
        int temp = 0;

        for (Map.Entry<String, Integer> dest : mapAiroprDest.entrySet()) {
            String airportKey = dest.getKey();
            if (mapAiroprtOrig.containsKey(airportKey)
                    && temp < dest.getValue() - mapAiroprtOrig.get(airportKey)) {
                temp = dest.getValue() - mapAiroprtOrig.get(airportKey);
                result = airportKey;

            }

        }

    }

}
