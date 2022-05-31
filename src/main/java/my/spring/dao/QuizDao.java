package my.spring.dao;

import my.spring.domain.Quiz;

import java.util.List;

public interface QuizDao {

    Quiz findQuiz(String q, List<String> answers);
}
