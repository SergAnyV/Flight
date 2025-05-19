package ru.questions.question1;



import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.data.DataProviderFromCSV;
import ru.objects.FlightsObject;

import java.util.HashMap;
import java.util.Map;

// класс предназначен для преобразования (отфильтрованного листа с объектами)-> в мапу где ключ-название компании ,
// значение- количество рейсов которые совершила компания

@Getter
@Component
public class GenerateMapWithAllOfFlightsCompanies {

    private  Map<String,Integer> mapAllFlightsCompanies= new HashMap<>();

//конструктор собирает мапу с именами компаний и количеством совершенных рейсов

    public GenerateMapWithAllOfFlightsCompanies(DataProviderFromCSV dataProviderFromCSV) {
        for (FlightsObject fo:dataProviderFromCSV.getData()){
            mapAllFlightsCompanies.merge(fo.getUniqueCarrier(), 1, Integer::sum);

        }

    }


}
