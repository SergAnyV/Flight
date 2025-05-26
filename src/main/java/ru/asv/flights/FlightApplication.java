package ru.asv.flights;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.asv.flights.service.QuestionService;

@Configuration
@ComponentScan("ru.asv.flights")
@PropertySource("classpath:application.properties")
public class FlightApplication {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(FlightApplication.class);
        QuestionService questionService=context.getBean(QuestionService.class);
        questionService.calculAllResultsAndWriteToTheFile();
    }

}
