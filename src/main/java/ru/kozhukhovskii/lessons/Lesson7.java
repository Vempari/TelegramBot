package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson7 implements Lesson{
    File method = new File("src/main/resources/Book 7. ClassLoaders.pdf");
    File presentation = new File("src/main/resources/Presentation 7. Classloaders.pdf");

    @Override
    public File getPresentation() {
        return presentation;
    }

    @Override
    public File getMethods() {
        return method;
    }
}

