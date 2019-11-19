package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson5_2 implements Lesson {
    File method = new File("src/main/resources/Методичка 5. Reflection API.pdf");
    File presentation = new File("src/main/resources/Презентация 5. Reflection API.pdf");

    @Override
    public File getPresentation() {
        return presentation;
    }

    @Override
    public File getMethods() {
        return method;
    }
}
