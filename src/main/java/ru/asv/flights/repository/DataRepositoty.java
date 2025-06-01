package ru.asv.flights.repository;

import ru.asv.flights.model.Flight;
import ru.asv.flights.repository.impl.DataRepositoryCSVImpl;

import java.util.List;
/**
 * Интерфейс репозитория для получения данных о рейсах.
 * Определяет базовый контракт для получения списка рейсов из различных источников данных.
 * Реализации интерфейса могут получать данные из CSV-файлов, баз данных, API и других источников.
 * @see DataRepositoryCSVImpl Пример реализации для работы с CSV-файлами
 */
public interface DataRepositoty {
    /**
     * Возвращает список рейсов.
     *
     * @return список объектов {@link Flight}, содержащих информацию о рейсах.
     */
    List<Flight> getData();
}
