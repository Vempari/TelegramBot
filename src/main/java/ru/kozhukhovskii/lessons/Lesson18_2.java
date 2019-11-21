package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson18_2 implements Lesson {
    File method = new File("src/main/resources/Book 18. Logs.pdf");
    File presentation = new File("src/main/resources/Presentation 18. Logs.pdf");

    @Override
    public File getPresentation() {
        return presentation;
    }

    @Override
    public File getMethods() {
        return method;
    }
}
