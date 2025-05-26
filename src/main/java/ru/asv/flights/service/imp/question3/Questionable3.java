package ru.asv.flights.service.imp.question3;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.asv.flights.repository.impl.DataReaderCSV;
import ru.asv.flights.service.Questionable;

import java.util.Map;

/*Какой именно борт (TailNum) налетал наибольшее число миль? Ответом должен быть полный
номер борта */
@Component
@Getter
public class Questionable3 implements Questionable {
    private String result;

    public Questionable3(DataReaderCSV dataReaderCSV) {
        GeneratorMapTailNumDistance generatorMapTailNumDistance=new GeneratorMapTailNumDistance(dataReaderCSV);
        String result= generatorMapTailNumDistance.getMapTailNumDistance().entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(s->s.getKey())
                .get();
        this.result = result;
    }

}
