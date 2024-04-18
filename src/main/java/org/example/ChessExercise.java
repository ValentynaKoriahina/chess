package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The ChessExercise class represents a chess exercise.
 */
@Getter
@Setter
public class ChessExercise {
        private String topic;
        private int difficultyRange;
        private int studentLevel;
        private String mode;
        private String type;
        private List<String> tags;
        private String solutionStrategy;
        private String PGN;
        private String targetSkills;
        private int rate;
        private List<Attempt> attempts;

        @Override
        public String toString() {
                return "ChessExercise{" + '\n' +
                        '\t' + "topic : " + topic + '\n' +
                        '\t' + "difficultyRange : " + difficultyRange + '\n' +
                        '\t' + "studentLevel : " + studentLevel + '\n' +
                        '\t' + "mode : " + mode + '\n' +
                        '\t' + "type : " + type + '\n' +
                        '\t' + "tags : " + tags + '\n' +
                        '\t' + "solutionStrategy : " + solutionStrategy + '\n' +
                        '\t' + "PGN : " + '\n' +
                        '\t' + "targetSkills : " + targetSkills + '\n' +
                        '\t' + "rate : " + rate + '\n' +
                        '\t' + "attempts : " + "\n" + "\t" + "\t" +  attempts + "\n" +
                        '\t' + '}';
        }
}
