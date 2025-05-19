package ru.questions.question8;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.data.DataProviderFromCSV;
import ru.objects.FlightsObject;

import java.util.Comparator;
/*Задержки иногда удается наверстать (т.е. рейс сумел-таки прибыть вовремя или даже с
опережением графика). Какая из таких наверстанных задержек оказалась самой большой? В
ответе указать дату (DayOfMonth), задержку вылета (DepDelay) в минутах и номер борта
(TailNum). Например: .*/
@Component
@Getter
public class Question8 {
    private String result;
//конструктор обрабатывает и выдает результат
    public Question8(DataProviderFromCSV dataProviderFromCSV) {
        result = dataProviderFromCSV.getData().stream().filter(fo -> fo.getCancelled().equals("0")
                        && fo.getCancelled().equals("0")
                        && !fo.getDepDelay().isEmpty() && !fo.getArrDelay().isEmpty() )
                .filter(fo -> Integer.parseInt(fo.getDepDelay()) > 0)
                .filter(fo -> Integer.parseInt(fo.getArrDelay()) <= 0 || fo.getArrDelay().isEmpty())
                .max(Comparator.comparingInt(fo -> Integer.parseInt(fo.getDepDelay())))
                .map(fo ->
                        fo.getDayOfMonth() + "," + fo.getDepDelay() + "," + fo.getTailNum()
                ).get();


        this.result = result;
    }


}
