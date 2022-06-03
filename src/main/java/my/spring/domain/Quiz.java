package my.spring.domain;

import java.util.List;

// Объявляем класс викторина, который содержит вопрос и список ответов
public class Quiz {

    private final String questionQuiz;
    private final List<String> answersQuiz;

    public Quiz(String questionQuiz, List<String> answersQuiz) {
        this.questionQuiz = questionQuiz;
        this.answersQuiz = answersQuiz;
    }

    public void showQuestionQuiz() {
        System.out.println(questionQuiz);
    }

    public void showAnswersQuiz() {

        for(int i = 0; i < answersQuiz.size(); i++) {
            System.out.println((i+1) + ". " + answersQuiz.get(i));
        }
    }

    public String getQuestion() {return questionQuiz;}

    public List<String> getAnswers() {return answersQuiz;}

}
