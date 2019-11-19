package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson11 implements Lesson {
    File method = new File("src/main/resources/Методичка 11. Lambda  Stream API 1.pdf");
    File method2 = new File("src/main/resources/Методичка 11. Lambda  Stream API 2.pdf");
    File presentation = new File("src/main/resources/Презентация 11. Lambda  Stream API.pdf");

    @Override
    public File getPresentation() {
        return presentation;
    }

    @Override
    public File getMethods() {
        return method;
    }
    public File getMethods2() {
        return method;
    }

}

