package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* Задание.

1. Создать список учеников. Класс Student взять из задания "Фильтрация учеников".
2. Преобразовать список учеников в Map.
3. В качестве ключа использовать фамилию ученика.
4. В качестве значение использовать объект ученика.
5. Реализуйте описанную выше логику в методе, который на вход принимает список учеников.
На реализованный метод напишите тесты. Важно! В исходном списке должны содержаться дубликаты.  */

public class ConvertListToMap {

    public Map<String, Student> listToMap(List<Student> studentList) {
        Map<String, Student> studentMap = studentList.stream()
                .distinct()
                .collect(Collectors.toMap(student -> student.getSurname(),
                                            student -> student));
        return studentMap;
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(10, "Ivanov"));
        studentList.add(new Student(20, "Petrov"));
        studentList.add(new Student(30, "Bashiroff"));
        studentList.add(new Student(10, "Ivanov"));
        Map<String, Student> studentMap = new ConvertListToMap().listToMap(studentList);
        for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
            System.out.println(entry);
        }

    }

}
