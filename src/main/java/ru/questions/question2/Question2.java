package ru.questions.question2;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.data.DataProviderFromCSV;
import ru.objects.FlightsObject;

import java.util.Map;
@Component
@Getter
public class Question2 {
    private String result;


    /* По какой причине рейсы отменялись чаще всего? Ответом должен быть однобуквенный код.*/

    public Question2(DataProviderFromCSV dataProviderFromCSV) {
        Map<String, Integer> mcc = new GenrateMapCanceledCode(dataProviderFromCSV).getMapCancelledCode();
        String result = mcc.entrySet().stream().max(Map.Entry.comparingByValue())
                .map(s -> s.getKey()).get();
        this.result = result;
    }

}
