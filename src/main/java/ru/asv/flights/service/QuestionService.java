package ru.asv.flights.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.asv.flights.repository.OutputWritable;

import java.util.List;

//Формирование ответов и добавление их в список

@Service
public class QuestionService {

    @Autowired
    private List<Questionable> questions;
    @Autowired
    private OutputWritable output;



    public void calculAllResultsAndWriteToTheFile() {
        for (int i = 0; i < questions.size(); i++) {
                   output.addAnswer(i+1,questions.get(i).getResult());
        }
        // запись результатов в файл
        output.writeAnswers();

    }

}
