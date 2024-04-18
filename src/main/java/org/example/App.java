package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * The class contains the entry point and the main flow of program execution
 */
public class App {

    /**
     * The main method that starts the program.
     *
     * @param args Command line arguments: path to folder with JSON files and attribute name.
     */
    public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            System.out.println("Incorrect number of startup parameters.");
            System.out.println("Example: java Main /path/to/folder name_attribute");
            return;
        }

        String folderPath = args[0];
        String attributeName = args[1];

        System.out.println("JSON files folder path: " + folderPath);
        System.out.println("Attribute name: " + attributeName);

        JsonParser jp = new JsonParser(2);
        List<Object> allExercises = new ArrayList<>();
        allExercises = jp.parse(folderPath);

        ChessExerciseAnalyzer ca = new ChessExerciseAnalyzer();
        Map<String, Integer> result = null;


        if (Objects.equals(attributeName, "targetSkills")) {
            result = ca.analyzeTargetSkills(allExercises);
        } else if (Objects.equals(attributeName, "difficultyRange")) {
            result = ca.analyzeDifficultyRange(allExercises);
        }

        new StatisticsFormatter(attributeName, result).process();
    }

}