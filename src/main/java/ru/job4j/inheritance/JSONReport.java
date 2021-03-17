package ru.job4j.inheritance;

public class JSONReport extends TextReport {

    public String generate(String name, String body) {
        return "{"
                + System.lineSeparator()
                + "\"name\" :" + " \"" + name + "\","
                + System.lineSeparator()
                + "\"body\" :" + " \"" + body + "\""
                + System.lineSeparator()
                + "}";
    }

    public static void main(String[] args) {
        JSONReport report = new JSONReport();
        String print = report.generate("Title", "body body body");
        System.out.println(print);
    }
}
