package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson8 implements Lesson{
    File method = new File("src/main/resources/Методичка 8. Java.IO.pdf");
    File presentation = new File("src/main/resources/Презентация 8. Java.IO.pdf");

    @Override
    public File getPresentation() {
        return presentation;
    }

    @Override
    public File getMethods() {
        return method;
    }
}

