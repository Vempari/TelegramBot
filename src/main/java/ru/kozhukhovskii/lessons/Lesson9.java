package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson9 implements Lesson{
    File method = new File("src/main/resources/Методичка 9. Multithreading. Part I.pdf");
    File presentation = new File("src/main/resources/Презентация 9. Multithreading. Part I.pdf");

    @Override
    public File getPresentation() {
        return presentation;
    }

    @Override
    public File getMethods() {
        return method;
    }
}

