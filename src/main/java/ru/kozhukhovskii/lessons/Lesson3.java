package ru.kozhukhovskii.lessons;

import java.io.File;

public class Lesson3 implements Lesson {
    File method = new File("src/main/resources/Методичка 3. Модуль компиляции и его структура. Преобразование типов.pdf");

    @Override
    public File getPresentation() {
        return null;
    }

    @Override
    public File getMethods() {
        return method;
    }
}
