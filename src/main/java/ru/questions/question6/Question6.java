package ru.questions.question6;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.data.DataProviderFromCSV;
import ru.questions.question5.GeneratorMapsAiroportDestAndOriginal;


import java.util.Map;

@Component
@Getter
public class Question6 {
    private String result;

    public Question6(DataProviderFromCSV dataProviderFromCSV) {
        GeneratorMapsAiroportDestAndOriginal mgADO = new GeneratorMapsAiroportDestAndOriginal(dataProviderFromCSV);
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
