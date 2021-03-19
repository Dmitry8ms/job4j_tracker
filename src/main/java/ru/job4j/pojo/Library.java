package ru.job4j.pojo;

public class Library {
    public static void printLibrary(Book[] library) {
        for (int i = 0; i < library.length; i++) {
            System.out.println("Book: \"" + library[i].getTitle() + "\", pages - "
                                + library[i].getPages());
        }
        System.out.println("_____________________________________________________________");
    }

    public static void printLibrary(Book[] library, String title) {
        for (int i = 0; i < library.length; i++) {
            if (library[i].getTitle().equals(title)) {
                System.out.println("Book: \"" + library[i].getTitle() + "\", pages - "
                        + library[i].getPages());
            }
        }
        System.out.println("_____________________________________________________________");
    }

    public static void main(String[] args) {
        Book cc = new Book("Clean code", 300);
        Book hf = new Book("Head first, Java", 400);
        Book boj = new Book("Basics of Java", 500);
        Book tij = new Book("Thinking in Java", 600);
        Book[] library = new Book[]{cc, hf, boj, tij};
        printLibrary(library);
        Book tmp = library[0];
        library[0] = library[3];
        library[3] = tmp;
        printLibrary(library, "Clean code");
    }
}
