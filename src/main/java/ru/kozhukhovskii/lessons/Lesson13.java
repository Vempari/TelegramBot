package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson13 implements Lesson {
    File method = new File("src/main/resources/Методичка 13. JVM,JIT,GC.pdf");
    File presentation = new File("src/main/resources/Презентация 13. JVM,JIT,GC.pdf");

    @Override
    public File getPresentation() {
        return presentation;
    }

    @Override
    public File getMethods() {
        return method;
    }
}
