package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson6_2 implements Lesson{
    File method = new File("src/main/resources/Book 6. Collections.pdf");
    File presentation = new File("src/main/resources/Presentation 6. Collections.pdf");

    @Override
    public File getPresentation() {
        return presentation;
    }

    @Override
    public File getMethods() {
        return method;
    }
}
