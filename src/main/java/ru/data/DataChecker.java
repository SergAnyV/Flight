package ru.data;

import lombok.extern.slf4j.Slf4j;


public class DataChecker {

    /* метод проверяет на корректность данных:1) если рейс отменен (1) и время отправки и прибытия пустое то пропускаем
     * 2)
     * 3)если рейс не отмене (0) и совершил рейс время прибытия и отправки в наличие
    */
    public static boolean checkFlightLine(String[] fields) {

        return (fields[17].equals("1") && fields[11].isEmpty() && fields[15].isEmpty()) ? true :             //1
                (fields[11].isEmpty() && fields[15].isEmpty()) ? true :         //2
                (!fields[11].isEmpty() && !fields[15].isEmpty()) ? true :       //2
                (fields[17].equals("0") && (!fields[11].isEmpty() && !fields[15].isEmpty())) ? true : false;   //3
    }


}
