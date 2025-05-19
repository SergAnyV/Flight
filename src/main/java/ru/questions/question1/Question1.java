package ru.questions.question1;


import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Map;

@Component

public class Question1 {
    @Getter
    private String NameOfCompany;
    @Getter
    private double percentOfCancelledFlights;

   /*У какой авиакомпании наибольший процент отмененных рейсов (Cancelled)? Ответом должен
быть двухбуквенный код авиаперевозчика (UniqueCarrier) и процентная доля отмененных
рейсов (например: AA, 1.22%). Процентная доля вычисляется как отношение отмененных рейсов
к общему числу совершенных рейсов. Ответ надо представить без округления, как есть.*/

    Question1(GenerateMapWithCancelledFlight generateMapWithCancelledFlight,GenerateMapWithAllOfFlightsCompanies generateMapWithAllOfFlightsCompanies) {
        Map<String, Integer> cancelledMap = generateMapWithCancelledFlight.getCancelledFlightsMap();
        Map<String, Integer> allFlightsMap = generateMapWithAllOfFlightsCompanies.getMapAllFlightsCompanies();
        double maxpercentCancelledFlights = 0, temp;
        String company = "";
        for (Map.Entry<String, Integer> entry : cancelledMap.entrySet()) {
            temp = ((double) entry.getValue() / allFlightsMap.get(entry.getKey())) * 100;
            if (maxpercentCancelledFlights < temp) {
                maxpercentCancelledFlights = temp;
                company = entry.getKey();
            }
        }
        this.NameOfCompany = company;
        this.percentOfCancelledFlights = maxpercentCancelledFlights;

    }

}
