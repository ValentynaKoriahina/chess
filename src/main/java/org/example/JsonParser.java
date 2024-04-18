package org.example;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.AllArgsConstructor;

/**
 * JsonParser class is designed for parsing JSON files with chess exercises.
 */
@AllArgsConstructor
public class JsonParser {
    /** Number of threads for parsing files */
    private int numThreads = 1;

    /**
     * Method parses JSON files with chess exercises from specified folder.
     *
     * @param folderPath The path to the folder with JSON files.
     * @return List of objects representing chess exercises.
     */
    public List<Object> parse(String folderPath) {
        List<Object> allExercises = new CopyOnWriteArrayList<>();
        System.out.println("Parsing files in folder: " + folderPath);

        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files != null) {
            ExecutorService executor = Executors.newFixedThreadPool(numThreads);
            for (File file : files) {
                if (file.isFile()) {
                    executor.execute(() -> processFile(file, allExercises));
                }
            }
            executor.shutdown();
            try {
                executor.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                System.err.println("Error waiting for threads to complete.");
            }
        } else {
            System.out.println("The specified path does not denote a directory, or an I/O error occurred.");
        }
        return allExercises;
    }

    /**
     * Processes a JSON file with chess exercises and adds them to the list of all exercises.
     *
     * @param file JSON file to process.
     * @param allExercises List to store all exercises.
     */
    private void processFile(File file, List<Object> allExercises) {
        // Using JsonReader from Gson library for step-by-step reading of data from files.
        try (FileReader fileReader = new FileReader(file);
             JsonReader jsonReader = new JsonReader(fileReader)) {

            jsonReader.beginArray();

            Gson gson = new Gson();

            while (jsonReader.hasNext()) {
                ChessExercise exercise = gson.fromJson(jsonReader, ChessExercise.class);
                allExercises.add(exercise);
            }
            jsonReader.endArray();

        } catch (IOException e) {
            System.out.println("Error processing file: " + file.getName());
            e.printStackTrace();
        }
    }
}
