package service;

import domain.Quiz;

import java.util.List;

public interface QuizService {

    Quiz getQuiz(String q, List<String> answers);
}
