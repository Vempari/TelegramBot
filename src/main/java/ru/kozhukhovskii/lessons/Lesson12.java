package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson12 implements Lesson {
    File method = new File("src/main/resources/Методичка 12. Java EE. Part I.pdf");
    File method2 = new File("src/main/resources/Методичка 12. Java EE:UML.pdf");
    File presentation = new File("src/main/resources/Презентация 12. Java EE. Part I.pdf");

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

