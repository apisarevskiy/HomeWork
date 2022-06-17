package my.spring.service;

import my.spring.domain.Person;
import my.spring.domain.Quiz;

import java.util.List;

public interface QuizService {

    // Инициализируем сервис
    void initQuizService();

    // Создаем пользователя для викторины
    void createPersonByName();

    // Выводим меню пользователя
    void showMenu();

    // Запускаем викторину
    void playQuiz();

    // Отображаем вопросы и ответы викторины
    void showListofQuiz();

    // Подводим итоги викторины
    void checkResultOfQuiz();
}
