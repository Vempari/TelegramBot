package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson2 implements Lesson {
    File method = new File("src/main/resources/Методичка 2 Лексика Языка.Типы данных.pdf");
    File presentation = new File("src/main/resources/Презентация 2 Лексика Языка.Типы данных.pdf");

    @Override
    public File getPresentation() {
        return presentation;
    }

    @Override
    public File getMethods() {
        return method;
    }

}
