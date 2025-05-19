package ru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.data.DataProviderFromCSV;
import ru.result.QuestionService;

//  в filePath указан путь к файлу с данными

public class Main {




    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("AppContext.xml");
        QuestionService questionService=context.getBean(QuestionService.class);


        questionService.calculAllResultsAndWriteToTheFile();

    }
  }