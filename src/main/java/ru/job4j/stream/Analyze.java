package ru.job4j.stream;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* В этом задании необходимо реализовать класс для подсчета статистики по аттестатам учеников.
 Метод averageScore вычисляет общий средний балл.

Метод averageScoreBySubject вычисляет средний балл ученика по его предметам.
Возвращает список из объекта Tuple (имя ученика и средний балл).

Метод averageScoreByPupil вычисляет средний балл по всем предметам для каждого ученика.
Возвращает список из объекта Tuple (название предмета и средний балл).

Метод bestStudent - возвращает лучшего ученика. Лучшим считается ученик с наибольшим баллом по
 всем предметам.

Метод bestSubject - возвращает предмет с наибольшим баллом для всех студентов.
Возвращает объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету) */

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(p -> p.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(p -> new Tuple(p.getName(), p.getSubjects()
                .stream()
                .mapToInt(Subject::getScore)
                .average().orElse(0D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(p -> new Tuple(p.getName(), p.getSubjects()
                .stream()
                .mapToInt(Subject::getScore)
                .sum()))
                .max((l, r) -> Double.compare(l.getScore(), r.getScore()))
                .orElse(new Tuple("none", 0));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .max((l, r) -> Double.compare(l.getScore(), r.getScore()))
                .orElse(new Tuple("none", 0));
    }
}
