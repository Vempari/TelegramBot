package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson10 implements Lesson {
    File method = new File("src/main/resources/Методичка 10. Multithreading. Part II.pdf");
    File presentation = new File("src/main/resources/Презентация 10. Multithreading Part II.pdf");

    @Override
    public File getPresentation() {
        return presentation;
    }

    @Override
    public File getMethods() {
        return method;
    }
}

