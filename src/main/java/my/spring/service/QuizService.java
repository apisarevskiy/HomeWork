package my.spring.service;

import my.spring.domain.Quiz;

import java.util.List;

public interface QuizService {

    Quiz getQuiz(String q, List<String> answers);
}
