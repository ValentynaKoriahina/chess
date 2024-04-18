package org.example;

import lombok.Getter;
import lombok.Setter;

/**
 * The Attempt class represents the student's attempt to solve the exercise.
 */
@Getter
@Setter
public class Attempt {
    private int studentId;
    private String timeSpent;
    private int attemptsCount;
    private boolean solved;

    @Override
    public String toString() {
        return  "\t" + "\t" + "\n" +
                "\t" + "\t" + "\t" + "{"  + "\n" +
                "\t" + "\t" + "\t" + "\t" + "studentId : " + studentId + '\n' +
                "\t" + "\t" + "\t" + "\t" + "timeSpent : " + timeSpent + '\n' +
                "\t" + "\t" + "\t" + "\t" + "attemptsCount : " + attemptsCount + '\n' +
                "\t" + "\t" + "\t" + "\t" + "solved : " + solved + '\n' +
                "\t" + "\t" + "\t" + '}' + '\n' + "\t"  + "\t";
    }

}