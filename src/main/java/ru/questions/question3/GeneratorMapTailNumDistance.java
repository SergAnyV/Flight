package ru.questions.question3;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.data.DataProviderFromCSV;
import ru.objects.FlightsObject;

import java.util.HashMap;
import java.util.Map;
@Component
public class GeneratorMapTailNumDistance {
    @Getter
    private Map<String, Integer> mapTailNumDistance = new HashMap<>();

    public GeneratorMapTailNumDistance(DataProviderFromCSV dataProviderFromCSV) {
        for (FlightsObject fo : dataProviderFromCSV.getData()) {
            if (!fo.getTailNum().isEmpty() && !fo.getTailNum().equals(" ")) {
                mapTailNumDistance.merge(fo.getTailNum(), Integer.parseInt(fo.getDistance()), Integer::sum);
            }
        }

    }

}
