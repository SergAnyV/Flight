package ru.result;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.FormattedOutput;
import ru.questions.question1.Question1;
import ru.questions.question2.Question2;
import ru.questions.question3.Question3;
import ru.questions.question4.Question4;
import ru.questions.question5.Question5;
import ru.questions.question6.Question6;
import ru.questions.question7.Question7;
import ru.questions.question8.Question8;
import ru.questions.question9.Question9;

//Формирование ответов и добавление их в список

@Component
public class QuestionService {
    @Autowired
    private Question1 first;
    @Autowired
    private  Question2 secondQ;
    @Autowired
    private  Question3 thirdQ;
    @Autowired
    private  Question4 fourQ;
    @Autowired
    private  Question5 fiveQ;
    @Autowired
    private  Question6 sixQ;
    @Autowired
    private  Question7 sevenQ;
    @Autowired
    private  Question8 eightQ;
    @Autowired
    private  Question9 nineQ;
    @Autowired
    private  FormattedOutput output;



    public void calculAllResultsAndWriteToTheFile() {
        System.out.println("");
        String firstQ = first.getNameOfCompany() + "," + first.getPercentOfCancelledFlights();
        output.addAnswer(1, firstQ);
        output.addAnswer(2, secondQ.getResult());
        output.addAnswer(3, thirdQ.getResult());
        output.addAnswer(4, fourQ.getResult());
        output.addAnswer(5, fiveQ.getResult());
        output.addAnswer(6, sixQ.getResult());
        output.addAnswer(7, sevenQ.getResult());
        output.addAnswer(8, eightQ.getResult());
        output.addAnswer(9, nineQ.getResult());

        // запись результатов в файл
        output.writeAnswers();

    }

}
