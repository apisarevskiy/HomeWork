package my.spring.service;

import my.spring.dao.QuizDao;
import my.spring.domain.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizDao dao;

    public QuizServiceImpl(QuizDao dao) {
        this.dao = dao;
    }

    @Override
    public Quiz getQuiz(String q, List<String> answers) {
        return dao.findQuiz(q, answers);
    }
}
