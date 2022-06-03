package my.spring;

import my.spring.domain.Quiz;
import my.spring.service.ApplicationRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import my.spring.service.QuizService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        QuizService quizService = context.getBean(QuizService.class);

        ApplicationRunner application = new ApplicationRunner(quizService);
        application.runApplication();
    }

}
