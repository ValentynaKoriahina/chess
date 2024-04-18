package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Lesson class presents a chess lesson.
 */
@Getter
@Setter
public class Lesson {
    private Date date;
    private Date deadline;
    private List<ChessExercise> tasks;
    private int studentId;
    private String topic;

}
