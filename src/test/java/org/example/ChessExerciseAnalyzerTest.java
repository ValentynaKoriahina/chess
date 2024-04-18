package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The ChessExerciseAnalyzerTest class contains tests for the ChessExerciseAnalyzer class.
 */
public class ChessExerciseAnalyzerTest {

    /**
     * Test for the analyzeTargetSkills method.
     * Verifies that the method correctly counts the occurrences of target skills in a list of exercises.
     */
    @Test
    public void testAnalyzeTargetSkills() {
        ChessExerciseAnalyzer analyzer = new ChessExerciseAnalyzer();
        List<Object> exercises = Arrays.asList(
                createExercise("Skill1, Skill2"),
                createExercise("Skill2, Skill3"),
                createExercise("Skill1, Skill3, Skill4")
        );

        Map<String, Integer> skillCount = analyzer.analyzeTargetSkills(exercises);

        assertEquals(4, skillCount.size());
        assertEquals(2, skillCount.get("Skill1"));
        assertEquals(2, skillCount.get("Skill2"));
        assertEquals(2, skillCount.get("Skill3"));
        assertEquals(1, skillCount.get("Skill4"));
    }

    /**
     * Test for the analyzeDifficultyRange method.
     * Ensures that the method correctly calculates the distribution of exercises by difficulty level.
     */
    @Test
    public void testAnalyzeDifficultyRange() {
        ChessExerciseAnalyzer analyzer = new ChessExerciseAnalyzer();
        List<Object> exercises = Arrays.asList(
                createExerciseWithDifficulty(1),
                createExerciseWithDifficulty(2),
                createExerciseWithDifficulty(3),
                createExerciseWithDifficulty(2),
                createExerciseWithDifficulty(3)
        );

        Map<String, Integer> difficultyCount = analyzer.analyzeDifficultyRange(exercises);

        assertEquals(3, difficultyCount.size());
        assertEquals(1, difficultyCount.get("1"));
        assertEquals(2, difficultyCount.get("2"));
        assertEquals(2, difficultyCount.get("3"));
    }

    // Helper method to create an exercise with specified target skills
    private ChessExercise createExercise(String targetSkills) {
        ChessExercise exercise = new ChessExercise();
        exercise.setTargetSkills(targetSkills);
        return exercise;
    }

    // Helper method to create an exercise with specified difficulty level
    private ChessExercise createExerciseWithDifficulty(int difficulty) {
        ChessExercise exercise = new ChessExercise();
        exercise.setDifficultyRange(difficulty);
        return exercise;
    }
}
