package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson1 implements Lesson {
    File file = new File("src/main/resources/Методичка 1. Java.JDK, InteliJ IDEA, Git.pdf");

    @Override
    public File getPresentation() {
        return null;
    }

    @Override
    public File getMethods() {
        return file;
    }
}
