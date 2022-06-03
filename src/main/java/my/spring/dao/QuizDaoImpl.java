package my.spring.dao;

import my.spring.domain.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizDaoImpl implements QuizDao {

    @Override
    public Quiz findQuiz(String questionQuiz, List<String> answersQuiz) {
        return new Quiz(questionQuiz, answersQuiz);
    }
}
