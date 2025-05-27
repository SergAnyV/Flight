package ru.asv.flights.service.imp;


import org.springframework.stereotype.Service;
import ru.asv.flights.repository.ResultWriter;
import ru.asv.flights.service.QuestionGetResulter;
import ru.asv.flights.service.QuestionService;

import java.util.List;

//Формирование ответов и добавление их в список

@Service
public class QuestionServiceImpl implements QuestionService {

    private List<QuestionGetResulter> questions;
    private ResultWriter output;

    public QuestionServiceImpl(List<QuestionGetResulter> questions, ResultWriter output) {
        this.questions = questions;
        this.output = output;
    }
    @Override
    public void writeAnswers() {
        for (int i = 0; i < questions.size(); i++) {
                   output.addAnswer(i+1,questions.get(i).getResult());
        }

        output.writeAnswers();// запись результатов в файл

    }

}
