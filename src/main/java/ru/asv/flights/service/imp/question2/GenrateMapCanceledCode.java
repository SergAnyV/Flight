package ru.asv.flights.service.imp.question2;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.asv.flights.repository.DataReadable;
import ru.asv.flights.model.Flight;


import java.util.HashMap;
import java.util.Map;
@Component
public class GenrateMapCanceledCode {
    @Getter
   private Map<String,Integer> mapCancelledCode=new HashMap<>();

    public GenrateMapCanceledCode(DataReadable dataReaderCSV) {
        for (Flight fo : dataReaderCSV.getData()) {
            if (!fo.getCancellationCode().isEmpty()) {
                mapCancelledCode.merge(fo.getCancellationCode(), 1, Integer::sum);

            }
        }
        this.mapCancelledCode = mapCancelledCode;

    }

}
