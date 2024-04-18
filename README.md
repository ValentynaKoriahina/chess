# Project Title

The "Chess" project is a tool for analyzing and processing a set of chess exercises in JSON format. The program allows to analyze various attributes of exercises, such as skills, difficulty level.

## Table of Contents

- [Run](#run)
- [Main entities](#main-entities)
- [Examples input and output files](#examples-input-and-output-files)
- [Experiments with Number of Threads](#experiments-with-number-of-threads)

## Run
The main program method is contained in the App class. Required arguments:

1 - path to the folder with JSON files

2 - name of the attribute for which statistics should be generated. The program works with two attributes:
"targetSkills", "difficultyRange"


## Main entities

### 1. ChessExercise
Represents an individual chess exercise. It contains information about the topic, difficulty level, student level, mode, type, tags, solution strategy, PGN entry, and other attributes.

### 2. Attempt
Represents an attempt to solve the chess exercise. Includes information about the student, time spent, number of attempts, and whether the exercise was solved.

### 3. Lesson
Represents a chess lesson. It contains the date of the lesson, the deadline of the assignments, the list of assignments, the student ID, and the topic of the lesson


## Key functional classes

### JsonParser
A class for parsing JSON files and converting their contents into Java objects. Provides methods to read JSON from the file system and analyze its structure.

### ChessExerciseAnalyzer
A class for analyzing chess exercise data. Provides methods for identifying target skills and estimating the difficulty level of exercises.

### StatisticsFormatter
A class for formatting and saving statistical data. Provides methods for processing statistics and saving them in an XML format.


## Examples input and output files

### Input Files

- JSON files containing list of chess exercises data.
 ```
[
    {
        "topic": "Тактики для взяття не захищених фігур противника.",
        "difficultyRange": 2,
        "studentLevel": 2,
        "mode": "classic",
        "type": "Захват матеріалу",
        "tags": [
            "#взяття",
            "#не_захищені_фігури"
        ],
        "solutionStrategy": "Взяття",
        "PGN": "[Event \"Тренування\"]\n[Site \"Клуб\"]\n[Date \"2024.04.08\"]\n[Round \"-\"]\n[White \"Учень1\"]\n[Black \"Учень2\"]\n[Result \"*\"]\n\n1. e4 d5 2. exd5 Qxd5 3. Nc3 Qa5",
        "targetSkills": "Тактична обізнаність, Планування нападу",
        "rate": 4,
        "attempts": [
            {
                "studentId": 1,
                "timeSpent": "00:12:45",
                "attemptsCount": 3,
                "solved": true
            },
            {
                "studentId": 2,
                "timeSpent": "00:10:20",
                "attemptsCount": 2,
                "solved": false
            }
        ]
    },
    {
        // Second exercise...
    },
    // Other Exercises...
]
```

### Output Files

- XML files containing statistics data. Creating in the root directory of the project.
```
<statistics>
    <item>
        <value>Skill1</value>
        <count>12</count>
    </item>
    <item>
        <value>Skill2</value>
        <count>8</count>
    </item>
</statistics>
```

## Experiments with number of threads

To evaluate the performance of the JSON parser, experiments with different numbers of threads were conducted. The results of the experiments showed the following:

### For a small number of objects (29 JSON)

| Number of Threads | Parsing Time (ms) |
|--------------------|-------------------|
| 1                  | 73                |
| 2                  | 75                |
| 4                  | 88                |
| 8                  | 72                |

Based on these results, we can conclude that increasing the number of threads can decrease the parsing time of JSON files, probably due to the overhead of thread management.

### With a large number of objects (4423 JSON)

| Number of Threads | Parsing Time (ms) |
|--------------------|-------------------|
| 1                  | 506               |
| 2                  | 359               |
| 4                  | 369               |
| 8                  | 355               |

Using 2 or more threads reduces parsing time approximately equally.
