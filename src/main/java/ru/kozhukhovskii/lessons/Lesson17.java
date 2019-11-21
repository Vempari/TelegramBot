package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson17 implements Lesson {
    File method = new File("src/main/resources/Book 17. Git.pdf");
    File presentation = new File("src/main/resources/Presentation 17. Git.pdf");

    @Override
    public File getPresentation() {
        return presentation;
    }

    @Override
    public File getMethods() {
        return method;
    }
}
