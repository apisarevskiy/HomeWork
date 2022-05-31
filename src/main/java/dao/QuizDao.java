package dao;

import domain.Quiz;

import java.util.List;

public interface QuizDao {

    Quiz findQuiz(String q, List<String> answers);
}
