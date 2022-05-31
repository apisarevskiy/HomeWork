package my.spring.domain;

import java.util.List;

// Объявляем класс викторина, который содержит вопрос и список ответов
public class Quiz {

    private final String question;
    private final List<String> answers;

    public Quiz(String q, List<String> answers) {
        this.question = q;
        this.answers = answers;
    }

    public void showQuiz() {
        System.out.println(question);

        for(int i=0; i < answers.size(); i++) {
            System.out.println(i + ". " + answers.get(i));
        }
    }

    public String getQuestion() {return question;}

    public List<String> getAnswers() {return answers;}

}
