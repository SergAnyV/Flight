package ru.asv.flights.model;


import lombok.Builder;
import lombok.Getter;

/**
 * Класс, представляющий информацию о рейсе с различными деталями:
 * дата, авиакомпания,
 * пункты отправления и назначения, статистика рейса.
 * Класс является неизменяемым (immutable), для создания объектов используется
 * Lombok аннотация {@code @Builder}.
 */


@Builder
@Getter
public class Flight {
    //День месяца, когда выполняется рейс (формат: "dd").
    private final String dayOfMonth;
    // День недели, когда выполняется рейс
    private final String dayOfWeek;
    // Дата выполнения рейса
    private final String flightDate;
    //Уникальный код авиакомпании
    private final String uniqueCarrier;
    //Бортовой номер воздушного судна.
    private final String tailNum;
    // ID аэропорта вылета.
    private final String originAirportID;
    //Код аэропорта вылет
    private final String origin;
    // Название штата/региона аэропорта вылета.
    private final String originStateName;
    //ID аэропорта назначения.
    private final String destAirportID;
    //Код аэропорта назначения
    private final String dest;
    //Название штата/региона аэропорта назначения.
    private final String destStateName;
    //Время вылета по расписанию
    private final String depTime;
    //Задержка вылета в минутах.
    private final String depDelay;
    //Фактическое время отрыва
    private final String wheelsOff;
    //Фактическое время касания
    private final String wheelsOn;
    //Время прибытия по расписанию
    private final String arrTime;
    //Задержка прибытия в минутах.
    private final String arrDelay;
    //Флаг отмены рейса ("1" - отменен, "0" - не отменен).
    private final String cancelled;
    //Код причины отмены рейса (если рейс отменен).
    private final String cancellationCode;
    // Флаг перенаправления рейса ("1" - перенаправлен, "0" - нет).
    private final String diverted;
    //Время в пути в минутах.
    private final String airTime;
    //Расстояние между аэропортами в милях.
    private final String distance;

}
