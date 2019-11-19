package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson3 implements Lesson {
    File method = new File("src/main/resources/Book 3. Compile. Type refactor.pdf");

    @Override
    public File getPresentation() {
        return null;
    }

    @Override
    public File getMethods() {
        return method;
    }
}
