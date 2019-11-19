package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson5 implements Lesson {
    File method = new File("src/main/resources/Book 5. JMM.pdf");
    File presentation = new File("src/main/resources/Presentation 5. JMM File.pdf");

    @Override
    public File getPresentation() {
        return presentation;
    }

    @Override
    public File getMethods() {
        return method;
    }
}
