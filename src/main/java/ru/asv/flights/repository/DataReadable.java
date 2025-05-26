package ru.asv.flights.repository;

import ru.asv.flights.model.Flight;

import java.util.List;

public interface DataReadable  {
    List<Flight> getData();
}
