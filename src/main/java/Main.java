import domain.Quiz;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.QuizService;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        QuizService service = context.getBean(QuizService.class);

        List<String> answers = new ArrayList<String>();
        answers.add("Ответ 1");
        answers.add("Ответ 2");
        answers.add("Ответ 3");
        answers.add("Ответ 4");

        Quiz one = service.getQuiz("Первый вопрос", answers);

        System.out.println(one.getQuestion());
        one.showQuiz();


    }
}
