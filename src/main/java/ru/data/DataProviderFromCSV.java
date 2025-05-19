package ru.data;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.objects.FlightObjectBuilderFromStringArray;
import ru.objects.FlightsObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
@Component

public class DataProviderFromCSV {
    @Getter
    private List<FlightsObject> data = new ArrayList<>();


    // конструктор формирует лист с отфильтрованными объектами типа FlightObject,фильтрация от грязи происходит с
// помощью класса DataChecker и формирование и добавление в лист (строка 23)

    public DataProviderFromCSV( @Value("${dataProviderFromCSV.filePath}")String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(Paths.get(filePath).toFile()))) {

            String line;
            reader.readLine();// pass first line with name of column
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (DataChecker.checkFlightLine(fields)) {
                    data.add(FlightObjectBuilderFromStringArray.createFO(fields)); //стр 23
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

