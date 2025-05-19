package ru.questions.question2;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.data.DataProviderFromCSV;
import ru.objects.FlightsObject;


import java.util.HashMap;
import java.util.Map;
@Component
public class GenrateMapCanceledCode {
    @Getter
   private Map<String,Integer> mapCancelledCode=new HashMap<>();

    public GenrateMapCanceledCode(DataProviderFromCSV dataProviderFromCSV) {
        for (FlightsObject fo : dataProviderFromCSV.getData()) {
            if (!fo.getCancellationCode().isEmpty()) {
                mapCancelledCode.merge(fo.getCancellationCode(), 1, Integer::sum);

            }
        }
        this.mapCancelledCode = mapCancelledCode;

    }

}
