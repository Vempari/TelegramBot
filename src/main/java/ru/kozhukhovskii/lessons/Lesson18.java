package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson18 implements Lesson {
    File method = new File("src/main/resources/Book 18. CI:CD.pdf");
    File presentation = new File("src/main/resources/Presentation 18. CI:CD.pdf");

    @Override
    public File getPresentation() {
        return presentation;
    }

    @Override
    public File getMethods() {
        return method;
    }
}
