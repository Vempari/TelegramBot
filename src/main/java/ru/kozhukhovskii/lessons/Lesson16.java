package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson16 implements Lesson {
    File method = new File("src/main/resources/Book 16. JUnit Part II.pdf");

    @Override
    public File getPresentation() {
        return null;
    }

    @Override
    public File getMethods() {
        return method;
    }
}
