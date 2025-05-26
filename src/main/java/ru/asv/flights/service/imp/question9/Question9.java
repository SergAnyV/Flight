package ru.asv.flights.service.imp.question9;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.asv.flights.repository.DataReadable;


import java.util.Map;
import java.util.stream.Collectors;

/* В какой день недели совершается наибольшее количество вылетов*/
@Component
@Getter
public class Question9 {
    String result;

    public Question9(DataReadable dataReaderCSV) {
        result = dataReaderCSV.getData().parallelStream()
                .collect(Collectors.groupingBy(
                        fo -> fo.getDayOfWeek(),
                        Collectors.counting()
                )).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey().toString();

        this.result = result;
    }


}
