package ru.asv.flights.service.imp.question3;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.asv.flights.repository.DataReadable;
import ru.asv.flights.model.Flight;

import java.util.HashMap;
import java.util.Map;
@Component
public class GeneratorMapTailNumDistance {
    @Getter
    private Map<String, Integer> mapTailNumDistance = new HashMap<>();

    public GeneratorMapTailNumDistance(DataReadable dataReaderCSV) {
        for (Flight fo : dataReaderCSV.getData()) {
            if (!fo.getTailNum().isEmpty() && !fo.getTailNum().equals(" ")) {
                mapTailNumDistance.merge(fo.getTailNum(), Integer.parseInt(fo.getDistance()), Integer::sum);
            }
        }

    }

}
