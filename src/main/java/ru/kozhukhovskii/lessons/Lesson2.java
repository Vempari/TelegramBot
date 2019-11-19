package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson2 implements Lesson {
    File method = new File("src/main/resources/Book 2 core.Data types.pdf");
    File presentation = new File("src/main/resources/Presentation 2 core.Data type.pdf");

    @Override
    public File getPresentation() {
        return presentation;
    }

    @Override
    public File getMethods() {
        return method;
    }

}
