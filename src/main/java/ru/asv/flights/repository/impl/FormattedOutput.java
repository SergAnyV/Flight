package ru.asv.flights.repository.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.asv.flights.repository.OutputWritable;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Class that is used for validation testing and grading.
 * The bundled JUnit tests will use the output from this class to check answers.
 * Don't forget to call writeAnswers() at the end!
 */
@Repository
public class FormattedOutput implements OutputWritable {

    // ArrayList for holding answers to the questions.
    // Each index corresponds to question number minus 1,
    // i.e. answers.get(2) corresponds to Q3, and so forth.
    private ArrayList<String> answers;
    private int numQuestions = 9;
    @Value("${formattedOutput.answerPath}")
    private String answerPath;
    public FormattedOutput() {

        answers = new ArrayList<>();

        // Initializes the answers ArrayList with dummy values
        for (int ii = 0; ii < numQuestions; ii++) {
            answers.add("No answer given");
        }
    }

    /**
     * Method for adding a descriptive answer
     *
     * @param question Question number
     * @param answer Provided answer
     */
    public void addAnswer(int question, String answer) {

        // Catches question numbers outside of the valid range
        if (question < 0 || question > numQuestions) {
            throw new IllegalArgumentException("Invalid question number, please try again");
        }

        answers.set(question - 1, answer);
    }

    /**
     * Method for adding a numerical answer
     *
     * @param question Question number
     * @param answer Provided answer
     */
    public void addAnswer(int question, int answer) {
        addAnswer(question, Integer.toString(answer));
    }

    /**
     * Writes answers to a TXT-file
     */
    @Override
    public void writeAnswers() {
        File out = new File(answerPath);

        try (PrintWriter pw = new PrintWriter(out)) {
            for (String s : answers) {
                pw.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not write the file out.  Check permissions, etc.");
        }
    }

}
