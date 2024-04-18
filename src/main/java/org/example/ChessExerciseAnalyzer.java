package org.example;

import java.util.*;

/**
 * The ChessExerciseAnalyzer class is designed to calculate statistics in the context of one of the attributes of chess exercises.
 */
public class ChessExerciseAnalyzer {

    Map<String, Integer> skillCount = new HashMap<>();
    Map<String, Integer> difficultyCount = new HashMap<>();

    /**
     * The method analyzes target exercise skills.
     *
     * @param exercises List of exercises to analyze.
     * @return Map where key is the target skill, value is the number of exercises with this skill.
     */
    public Map<String, Integer> analyzeTargetSkills(List<Object> exercises) {
        for (Object obj : exercises) {
            ChessExercise exercise = (ChessExercise) obj;

            String targetSkills = exercise.getTargetSkills();
            String[] split = targetSkills.split("\\s*,\\s*");

            for (String skill : split) {
                skillCount.put(skill, skillCount.getOrDefault(skill, 0) + 1);
            }
        }

        return skillCount;
    }

    /**
     * The method analyzes the range of exercise difficulty.
     *
     * @param exercises List of exercises to analyze.
     * @return Map, where key is the range of difficulty, value is the number of exercises in this range.
     */
    public Map<String, Integer>  analyzeDifficultyRange(List<Object> exercises) {
        for (Object obj : exercises) {

            ChessExercise exercise = (ChessExercise) obj;
            int difficulty = exercise.getDifficultyRange();

            String difficultyStr = String.valueOf(difficulty);
            difficultyCount.put(difficultyStr, difficultyCount.getOrDefault(difficultyStr, 0) + 1);
        }

        return difficultyCount;
    }
}
