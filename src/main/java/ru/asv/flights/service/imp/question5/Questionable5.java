package ru.asv.flights.service.imp.question5;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.asv.flights.repository.impl.DataReaderCSV;
import ru.asv.flights.service.Questionable;

import java.util.Map;

/*Какой аэропорт был самым активным «источником» (source) рейсов? Этот показатель
вычисляется как разница между прибывающими и вылетающими рейсами. Ответом должен
быть идентификатор OriginAirportID . В ответе на этот вопрос не должны
участвовать отменные рейсы.*/
@Component
@Getter
public class Questionable5 implements Questionable {
    private String result;

    public Questionable5(DataReaderCSV dataReaderCSV) {
        GeneratorMapsAiroportDestAndOriginal mgADO=new GeneratorMapsAiroportDestAndOriginal(dataReaderCSV);
        Map<String,Integer> mapAiroprDest=mgADO.getMapAiroportDest();
        Map<String ,Integer> mapAiroprtOrig=mgADO.getMapAiroportOriginal();
        int temp=0;

        for (Map.Entry<String,Integer> dest:mapAiroprDest.entrySet()){
            String airportKey = dest.getKey();
        if(     mapAiroprtOrig.containsKey(airportKey)
                &&temp < mapAiroprtOrig.get(airportKey)-dest.getValue()){
            temp=mapAiroprtOrig.get(airportKey)-dest.getValue();
            result=airportKey;

        }
        }

        this.result = result;
    }

}
