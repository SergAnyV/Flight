package ru.asv.flights.service.imp.question9;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.asv.flights.repository.DataRepositoty;
import ru.asv.flights.service.QuestionGetResulter;


import java.util.Map;
import java.util.stream.Collectors;

/* В какой день недели совершается наибольшее количество вылетов*/
@Component
@Getter
public class QuestionGetResulterImpl9 implements QuestionGetResulter {
   private String result;

    public QuestionGetResulterImpl9(DataRepositoty dataReaderCSV) {
        this.result = dataReaderCSV.getData().parallelStream()
                .collect(Collectors.groupingBy(
                        fo -> fo.getDayOfWeek(),
                        Collectors.counting()
                )).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey().toString();


    }


}
