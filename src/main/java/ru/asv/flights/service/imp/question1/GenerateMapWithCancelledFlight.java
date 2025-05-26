package ru.asv.flights.service.imp.question1;



import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.asv.flights.repository.DataReadable;
import ru.asv.flights.model.Flight;

import java.util.HashMap;
import java.util.Map;

// класс предназначен для преобразования (отфильтрованного листа с объектами)-> в мапу где ключ-название компании ,
// значение- количество ОТМЕНЕННЫХ рейсов для данной компания
@Getter
@Component
public class GenerateMapWithCancelledFlight {
    private Map<String, Integer> cancelledFlightsMap = new HashMap<>();

    //конструктор собирает мапу с именами компаний и количеством ОТМЕНЕННЫХ рейсов

    public GenerateMapWithCancelledFlight(DataReadable dataReaderCSV) {
        for (Flight fo : dataReaderCSV.getData()) {
            if (fo.getCancelled().equals("1")) {
                cancelledFlightsMap.merge(fo.getUniqueCarrier(), 1, Integer::sum);

            }
        }

    }


}
