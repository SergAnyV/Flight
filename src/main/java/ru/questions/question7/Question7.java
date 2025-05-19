package ru.questions.question7;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.data.DataProviderFromCSV;
import ru.objects.FlightsObject;
/*Сколько рейсов компании American Airlines (UniqueCarrier ‘.....’) оказались задержаны на 60
минут и более? Если задержался и вылет и прибытие, учитывается сумма этих задержек. Ответом
должно быть целое число.*/
//В Q7 (число рейсов компании ......., чей вылет задержался на 60 и более минут) не надо складывать задержки
// вылета с задержками прибытия; так, например, рейс с 40-минутной DepDelay и 40-минутной ArrDelay не должен включаться
// в расчеты, хотя для него совокупная задержка составила 80 минут.
@Component
@Getter
public class Question7 {
  private   String result;
    //конструктор обрабатывает и выдает результат
    public Question7(DataProviderFromCSV dataProviderFromCSV) {
     result= String.valueOf(dataProviderFromCSV.getData().stream().
                filter(s->s.getUniqueCarrier().equals("AA") && s.getCancelled().equals("0")
                        && !s.getDepDelay().isEmpty() && !s.getArrDelay().isEmpty() ).
                filter(s->{
                    return  ((Integer.parseInt(s.getDepDelay())>=60) || (Integer.parseInt(s.getArrDelay()))>=60);
                }).
                count());

    }


}
