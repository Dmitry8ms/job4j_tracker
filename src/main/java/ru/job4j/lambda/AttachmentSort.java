package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/** 1. Создайте анонимный класс для компаратора Attachment. Класс должен
сравнивать имена объектов Attachment.
2. Добавьте код из пункта 1 в конструкцию, приведенную ниже. */

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator comparator =  new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return left.getSize() - right.getSize();
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        Comparator<Attachment> compNamesDesc =  new Comparator<Attachment>() {

            @Override
            public int compare(Attachment a1, Attachment a2) {
                return a2.getName().compareTo(a1.getName());
            }
        };
        attachments.sort(compNamesDesc);
        System.out.println(attachments);
    }
}
