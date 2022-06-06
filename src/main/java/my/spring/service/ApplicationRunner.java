package my.spring.service;

import my.spring.domain.Quiz;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class ApplicationRunner {

    private List<Quiz> listOfQuiz;
    private QuizService quizService;
    private final String FILE_PROPERTIES = "src/main/resources/config.properties";
    private String pathFileCsv = "";
    private int countRightQuestions;

    public ApplicationRunner(QuizService quizService) {
        this.quizService = quizService;
    }
    public void runApplication() {

        configApplication();
        showListofQuiz();
        playQuiz();
    }

    // Запускаем викторину
    public void playQuiz() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Do you want to start QUIZ, enter y?");
        System.out.print("Your answer: ");
        String userChoice = scanner.nextLine();

        if (userChoice.equals("y")) {

            System.out.println("Choose the correct answer to the quetsion: ");

            for (var instanceQuiz : listOfQuiz) {
                instanceQuiz.showQuestionQuiz();
                instanceQuiz.showAnswersQuiz();
                System.out.print("Your answer: ");
                userChoice = scanner.nextLine();
            }
        } else {
            System.out.println("We wish you good luck. Come back to us again!");
        }
    }

    public void configApplication() {

        listOfQuiz = new ArrayList<Quiz>();

        readFileProperties(FILE_PROPERTIES);
        readFileCsv(pathFileCsv);
    }

    // Добавляем новый вопрос и ответы в список викторины
    public void putListOfQuiz(String sentence[]) {

        List<String> answersQuiz = new ArrayList<String>();
        String questionQuiz = "";
        Boolean sentenceQuestion = true;

            for (var quizSentence : sentence) {

                if (sentenceQuestion) {
                    questionQuiz = quizSentence;
                    sentenceQuestion = false;
                } else {
                    answersQuiz.add(quizSentence);
                }
            }

        Quiz instanceQuiz = quizService.getQuiz(questionQuiz, answersQuiz);
        listOfQuiz.add(instanceQuiz);

    }

    // Отображаем вопросы и ответы викторины
    public void showListofQuiz() {

        for (var instanceQuiz : listOfQuiz) {
           instanceQuiz.showQuestionQuiz();
           instanceQuiz.showAnswersQuiz();
        }
    }

    // Читаем настройки с CSV файла
    public void readFileCsv(String fileCsv) {

        try {
            Scanner scanner = new Scanner(new FileReader(fileCsv));

            while (scanner.hasNext()) {
                var line = scanner.nextLine();
                String sentence[] = line.split(",");
                putListOfQuiz(sentence);
            }
            scanner.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Читаем properties файл и из него получаем путь к CSV файлу
    public void readFileProperties(String fileProperties) {

        Properties property = new Properties();

        try {
            FileInputStream fis = new FileInputStream(fileProperties);
            property.load(fis);

            pathFileCsv = property.getProperty("db.pathCsv");
            countRightQuestions = Integer.parseInt(property.getProperty("db.countRightQuestions"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
