package my.spring;

import my.spring.service.ApplicationRunner;
import org.springframework.context.annotation.*;


//@EnableAspectJAutoProxy
@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        ApplicationRunner application = context.getBean(ApplicationRunner.class);
        application.runApplication();
    }

}
