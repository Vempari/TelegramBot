package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson4 implements Lesson {
    File method = new File("src/main/resources/Методичка 4. Массивы. Операторы и структура кода. Исключения..pdf");
    File presentation = new File("src/main/resources/Презентация 4. Массивы. Операторы и структура кода. Исключения.pdf");

    @Override
    public File getPresentation() {
        return presentation;
    }

    @Override
    public File getMethods() {
        return method;
    }
}
