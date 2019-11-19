package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson15 implements Lesson {
    File method = new File("src/main/resources/Методичка 15. JUnit Part I.pdf");
    File presentation = new File("src/main/resources/Презентация 15. JUnit Part I.pdf");

    @Override
    public File getPresentation() {
        return presentation;
    }

    @Override
    public File getMethods() {
        return method;
    }
}
