package ru.questions.question4;
import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.data.DataProviderFromCSV;
import ru.objects.FlightsObject;

import java.util.HashMap;
import java.util.Map;
// формирование мапы ключ- аэропорт , значение - количество осещений аэропорта
@Component
@Getter
public class GeneratorMapOfAirportBusy {
 private    Map<String,Integer> generatorMOAB=new HashMap<>();

    public GeneratorMapOfAirportBusy(DataProviderFromCSV dataProviderFromCSV) {
        for (FlightsObject fo:dataProviderFromCSV.getData()){
            generatorMOAB.merge(fo.getOriginAirportID(), 1, Integer::sum);
        }
        this.generatorMOAB = generatorMOAB;
    }


}
