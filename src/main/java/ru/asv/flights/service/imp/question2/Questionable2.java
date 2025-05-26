package ru.asv.flights.service.imp.question2;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.asv.flights.repository.impl.DataReaderCSV;
import ru.asv.flights.service.Questionable;

import java.util.Map;
@Component
@Getter
public class Questionable2 implements Questionable {
    private String result;


    /* По какой причине рейсы отменялись чаще всего? Ответом должен быть однобуквенный код.*/

    public Questionable2(DataReaderCSV dataReaderCSV) {
        Map<String, Integer> mcc = new GenrateMapCanceledCode(dataReaderCSV).getMapCancelledCode();
        String result = mcc.entrySet().stream().max(Map.Entry.comparingByValue())
                .map(s -> s.getKey()).get();
        this.result = result;
    }

}
