package ru.asv.flights.repository.impl;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.asv.flights.repository.DataReadable;
import ru.asv.flights.util.DataUtil;
import ru.asv.flights.util.FlightUtil;
import ru.asv.flights.model.Flight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
@Repository

public class DataReaderCSV implements DataReadable {
    @Getter
    private List<Flight> data = new ArrayList<>();

    // конструктор формирует лист с отфильтрованными объектами типа FlightObject,фильтрация от грязи происходит с
    // помощью класса DataChecker и формирование и добавление в лист (строка 23)

    public DataReaderCSV(@Value("${dataReaderCSV.filePath}")String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(Paths.get(filePath).toFile()))) {

            String line;
            reader.readLine();// pass first line with name of column
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (DataUtil.checkFlightLine(fields)) {
                    data.add(FlightUtil.createFO(fields)); //стр 23
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

