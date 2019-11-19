package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson4 implements Lesson {
    File method = new File("src/main/resources/Book 4. Massive. code structure. Exceptions..pdf");
    File presentation = new File("src/main/resources/Presentation 4. Massive. code structure. Exeception.pdf");

    @Override
    public File getPresentation() {
        return presentation;
    }

    @Override
    public File getMethods() {
        return method;
    }
}
