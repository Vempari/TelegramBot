package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson1 implements Lesson {
    File file = new File("/src/main/resources/Book 1. Java, JDK, IDEA, GIT.pdf");

    @Override
    public File getPresentation() {
        return file;
    }

    @Override
    public File getMethods() {
        return file;
    }
}
