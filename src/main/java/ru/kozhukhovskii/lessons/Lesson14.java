package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson14 implements Lesson {
    File method = new File("src/main/resources/Book 14. Maven.pdf");
    File presentation = new File("src/main/resources/Presentation 14. Maven.pdf");

    @Override
    public File getPresentation() {
        return presentation;
    }

    @Override
    public File getMethods() {
        return method;
    }
}
