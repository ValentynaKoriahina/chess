package org.example;

/**
 * ParsingTimeTest class is designed to test the parsing time of JSON files.
 */
public class ParsingTimeTest {

    /**
     * Entry point to the program for testing the parsing time.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) throws Exception {

        // Path to the folder with JSON files
        String folderPath = "src/test/resources/JSON";

        // Measure parsing start time
        long startTime = System.nanoTime();

        JsonParser jp = new JsonParser(8); // Desired number of threads for parallel parsing
        jp.parse(folderPath);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;

        System.out.println("Время парсинга: " + duration + " мс");

    }
}
