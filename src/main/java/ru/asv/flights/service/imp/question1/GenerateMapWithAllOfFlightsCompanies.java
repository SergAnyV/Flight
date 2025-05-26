package ru.asv.flights.service.imp.question1;



import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.asv.flights.repository.DataReadable;
import ru.asv.flights.model.Flight;

import java.util.HashMap;
import java.util.Map;

// класс предназначен для преобразования (отфильтрованного листа с объектами)-> в мапу где ключ-название компании ,
// значение- количество рейсов которые совершила компания

@Getter
@Component
public class GenerateMapWithAllOfFlightsCompanies {

    private  Map<String,Integer> mapAllFlightsCompanies= new HashMap<>();

//конструктор собирает мапу с именами компаний и количеством совершенных рейсов

    public GenerateMapWithAllOfFlightsCompanies(DataReadable dataReaderCSV) {
        for (Flight fo: dataReaderCSV.getData()){
            mapAllFlightsCompanies.merge(fo.getUniqueCarrier(), 1, Integer::sum);

        }

    }


}
