package ru.asv.flights.service.imp.question4;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.asv.flights.repository.DataRepositoty;
import ru.asv.flights.service.QuestionGetResulter;

import java.util.Map;

/*Какой аэропорт был самым загруженным с точки зрения количества прибывающих и
вылетающих рейсов? Ответом должен быть идентификатор OriginAirportID */
@Component
@Getter
public class QuestionGetResulter4 implements QuestionGetResulter {
    private String result;

    public QuestionGetResulter4(DataRepositoty dataReaderCSV) {
        GeneratorMapOfAirportBusy generatorMapOfAirportBusy=new GeneratorMapOfAirportBusy(dataReaderCSV);
        this.result= generatorMapOfAirportBusy.getGeneratorMOAB().entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(s->s.getKey()).get();

    }

}
