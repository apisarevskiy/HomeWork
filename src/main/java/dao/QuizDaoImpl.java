package dao;

import domain.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizDaoImpl implements QuizDao {

    @Override
    public Quiz findQuiz(String q, List<String> answers) {
        return new Quiz(q, answers);
    }
}
