package ru.asv.flights.service.imp.question2;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.asv.flights.repository.impl.DataRepositoryCSVImpl;
import ru.asv.flights.service.QuestionGetResulter;

import java.util.Map;
@Component
@Getter
public class QuestionGetResulterImpl2 implements QuestionGetResulter {
    private String result;


    /* По какой причине рейсы отменялись чаще всего? Ответом должен быть однобуквенный код.*/

    public QuestionGetResulterImpl2(DataRepositoryCSVImpl dataRepositoryCSVImpl) {
        Map<String, Integer> mcc = new GenrateMapCanceledCode(dataRepositoryCSVImpl).getMapCancelledCode();
        String result = mcc.entrySet().stream().max(Map.Entry.comparingByValue())
                .map(s -> s.getKey()).get();
        this.result = result;
    }

}
