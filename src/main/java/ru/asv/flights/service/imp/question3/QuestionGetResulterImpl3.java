package ru.asv.flights.service.imp.question3;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.asv.flights.repository.impl.DataRepositoryCSVImpl;
import ru.asv.flights.service.QuestionGetResulter;

import java.util.Map;

/*Какой именно борт (TailNum) налетал наибольшее число миль? Ответом должен быть полный
номер борта */
@Component
@Getter
public class QuestionGetResulterImpl3 implements QuestionGetResulter {
    private String result;

    public QuestionGetResulterImpl3(DataRepositoryCSVImpl dataRepositoryCSVImpl) {
        GeneratorMapTailNumDistance generatorMapTailNumDistance=new GeneratorMapTailNumDistance(dataRepositoryCSVImpl);
        this.result= generatorMapTailNumDistance.getMapTailNumDistance().entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(s->s.getKey())
                .get();
        }

}
