package ru.asv.flights.service.imp.question5;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.asv.flights.repository.DataRepositoty;

import ru.asv.flights.model.Flight;

import java.util.HashMap;
import java.util.Map;

/*Какой аэропорт был самым активным «источником» (source) рейсов? Этот показатель
вычисляется как разница между прибывающими и вылетающими рейсами. Ответом должен
быть идентификатор OriginAirportID . В ответе на этот вопрос не должны
участвовать отменные рейсы.*/
@Getter
@Component
public class GeneratorMapsAiroportDestAndOriginal {
    private Map<String, Integer> mapAiroportDest = new HashMap<>();
    private Map<String, Integer> mapAiroportOriginal = new HashMap<>();

    // формирование мап в конструкотре ключ- аэропорт(прибытия или отправления) , значение - количество осещений аэропорта

    public GeneratorMapsAiroportDestAndOriginal(DataRepositoty dataReaderCSV) {
        for (Flight fo : dataReaderCSV.getData()) {
            if (fo.getDestAirportID()!=null&& !fo.getDestAirportID().trim().isEmpty()
                    && fo.getOriginAirportID()!=null&&!fo.getOriginAirportID().trim().isEmpty()) {
                mapAiroportDest.merge(fo.getDestAirportID(), 1, Integer::sum);
                mapAiroportOriginal.merge(fo.getOriginAirportID(), 1, Integer::sum);
            }
        }

    }

}
