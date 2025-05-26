package ru.asv.flights.service.imp.question4;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.asv.flights.repository.DataReadable;
import ru.asv.flights.service.Questionable;

import java.util.Map;

/*Какой аэропорт был самым загруженным с точки зрения количества прибывающих и
вылетающих рейсов? Ответом должен быть идентификатор OriginAirportID */
@Component
@Getter
public class Questionable4 implements Questionable {
    private String result;

    public Questionable4(DataReadable dataReaderCSV) {
        GeneratorMapOfAirportBusy generatorMapOfAirportBusy=new GeneratorMapOfAirportBusy(dataReaderCSV);
        result= generatorMapOfAirportBusy.getGeneratorMOAB().entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(s->s.getKey()).get();

        this.result = result;
    }

}
