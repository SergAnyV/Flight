package ru.asv.flights.service.imp.question4;
import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.asv.flights.repository.DataReadable;
import ru.asv.flights.model.Flight;

import java.util.HashMap;
import java.util.Map;
// формирование мапы ключ- аэропорт , значение - количество осещений аэропорта
@Component
@Getter
public class GeneratorMapOfAirportBusy {
 private    Map<String,Integer> generatorMOAB=new HashMap<>();

    public GeneratorMapOfAirportBusy(DataReadable dataReaderCSV) {
        for (Flight fo: dataReaderCSV.getData()){
            generatorMOAB.merge(fo.getOriginAirportID(), 1, Integer::sum);
        }
        this.generatorMOAB = generatorMOAB;
    }


}
