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
    }

    public void configApplication() {

        listOfQuiz = new ArrayList<Quiz>();

        readFileProperties(FILE_PROPERTIES);
        readFileCsv(pathFileCsv);
    }

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

    public void showListofQuiz() {

        for (var instanceQuiz : listOfQuiz) {
           System.out.println("");
           instanceQuiz.showQuestionQuiz();
           instanceQuiz.showAnswersQuiz();
        }
    }

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
