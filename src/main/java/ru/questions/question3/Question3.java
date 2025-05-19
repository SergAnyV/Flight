package ru.questions.question3;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.data.DataProviderFromCSV;
import ru.objects.FlightsObject;

import java.util.Map;

/*Какой именно борт (TailNum) налетал наибольшее число миль? Ответом должен быть полный
номер борта */
@Component
@Getter
public class Question3 {
    private String result;

    public Question3(DataProviderFromCSV dataProviderFromCSV) {
        GeneratorMapTailNumDistance generatorMapTailNumDistance=new GeneratorMapTailNumDistance(dataProviderFromCSV);
        String result= generatorMapTailNumDistance.getMapTailNumDistance().entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(s->s.getKey())
                .get();
        this.result = result;
    }

}
