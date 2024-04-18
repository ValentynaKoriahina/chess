package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The JsonParserTest class contains tests for the JsonParser class.
 */
public class JsonParserTest {

    /**
     * Test for the parse method with a valid folder path.
     * Verifies that the method correctly reads and processes JSON files from a valid folder path.
     */
    @Test
    public void testParseValidFolderPath() {
        String folderPath = "src/test/resources/JSON";

        JsonParser jp = new JsonParser(1);
        List<Object> allExercises = jp.parse(folderPath);

        assertNotNull(allExercises);
        assertFalse(allExercises.isEmpty());
    }

    /**
     * Test for the parse method with an invalid folder path.
     * Ensures that the method handles invalid folder paths gracefully and returns an empty list.
     */
    @Test
    public void testParseInvalidFolderPath() {
        String folderPath = "src/test/resources/JSONf";

        JsonParser jp = new JsonParser(1);
        List<Object> allExercises = jp.parse(folderPath);

        assertNotNull(allExercises);
        assertTrue(allExercises.isEmpty());
    }

    /**
     * Test for the parse method with an empty folder.
     * Verifies that the method handles empty folders correctly and returns an empty list.
     */
    @Test
    public void testParseEmptyFolder() {
        String folderPath = "src/test/resources/JSON_empty";

        JsonParser jp = new JsonParser(1);
        List<Object> allExercises = jp.parse(folderPath);

        assertNotNull(allExercises);
        assertTrue(allExercises.isEmpty());
    }

    /**
     * Test for the parse method with individual objects count check.
     * Checks the number of individual objects parsed from a JSON file.
     */
    @Test
    public void testParseIndividualObjectsCount() {
        String testFilePath = "src/test/resources/JSON_count"; // Specify the path to your test JSON file

        JsonParser jsonParser = new JsonParser(1);
        List<Object> exercises = jsonParser.parse(testFilePath);

        assertNotNull(exercises);
        short expectedNumberOfObjects = 4;
        assertEquals(expectedNumberOfObjects, exercises.size()); // Specify the expected number of objects in the JSON array

        for (Object obj : exercises) {
            assertInstanceOf(ChessExercise.class, obj); // Ensure the object is an instance of the expected class
            ChessExercise exercise = (ChessExercise) obj;
        }
    }

    /**
     * Test for the parse method with individual objects verification.
     * Verifies the correctness of individual object fields parsed from a JSON file.
     */
    @Test
    public void testParseIndividualObjects() {
        String testFilePath = "src/test/resources/JSON_obj_fields";
        JsonParser jsonParser = new JsonParser(1);

        List<Object> exercises = jsonParser.parse(testFilePath);

        assertNotNull(exercises);
        assertFalse(exercises.isEmpty());

        for (Object obj : exercises) {
            assertInstanceOf(ChessExercise.class, obj);
            ChessExercise exercise = (ChessExercise) obj;

            // Check each field of the object for correspondence with the expected data from JSON
            assertEquals("Тактики для взяття не захищених фігур противника.", exercise.getTopic());
            assertEquals(2, exercise.getDifficultyRange());
            assertEquals(2, exercise.getStudentLevel());
            assertEquals("classic", exercise.getMode());
            assertEquals("Захват материала", exercise.getType());
            assertEquals(List.of("#взяття", "#не_захищені_фігури"), exercise.getTags());
            assertEquals("Взяття", exercise.getSolutionStrategy());
            assertEquals("[Event \"Тренування\"]\n[Site \"Клуб\"]\n[Date \"2024.04.08\"]\n[Round \"-\"]\n[White \"Учень1\"]\n[Black \"Учень2\"]\n[Result \"*\"]\n\n1. e4 d5 2. exd5 Qxd5 3. Nc3 Qa5", exercise.getPGN());
            assertEquals("Тактична обізнаність, Планування нападу", exercise.getTargetSkills());
            assertEquals(4, exercise.getRate());

            // Check the Attempt class objects
            List<Attempt> attempts = exercise.getAttempts();
            Pattern timePattern = Pattern.compile("^\\d{2}:\\d{2}:\\d{2}$");

            for (Attempt attempt : attempts) {
                assertTrue(timePattern.matcher(attempt.getTimeSpent()).matches());
                assertTrue(attempt.getStudentId() > 0);
                assertTrue(attempt.getAttemptsCount() > 0);
                assertNotNull(attempt.isSolved());
            }
        }
    }

}

