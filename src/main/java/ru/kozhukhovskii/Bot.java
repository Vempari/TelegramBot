package ru.kozhukhovskii;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendDocument;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import ru.kozhukhovskii.lessons.*;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Bot extends TelegramLongPollingBot {
    private long chat_id;
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi botapi = new TelegramBotsApi();
        try {
            botapi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendDoc(Message msg, File file) {
        SendDocument d = new SendDocument();
        d.setChatId(msg.getChatId());
        d.setNewDocument(file);
        try {
            sendDocument(d);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "USER";
    }

    @Override
    public void onUpdateReceived(Update e) {
        e.getUpdateId();
        SendMessage sendMessage = new SendMessage().setChatId(e.getMessage().getChatId());
        chat_id = e.getMessage().getChatId();
        String text = e.getMessage().getText();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        if (text.equals("/start")) {
            try {
                sendMessage.setText("Привет! Я тестовый бот и я предоставляю доступ к файлам для обучающихся по курсу Java.\n" +
                        "Если хочешь посмотреть расписание уроков напиши 'Расписание' \n" +
                        "Если хочешь посмотреть задания от Антона напиши 'Задания' \n" +
                        "Если хочешь скачать методички или презентации уроков напиши 'Лекции'");
                execute(sendMessage);
            } catch (TelegramApiException ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                sendMessage.setText(getMessage(text, e.getMessage()));
                execute(sendMessage);
            } catch (TelegramApiException ex) {
                ex.printStackTrace();
            }
        }
    }

    private String getMessage(String text, Message message) {
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow leftRow = new  KeyboardRow();
        KeyboardRow rightRow = new KeyboardRow();
        KeyboardRow thirdRow = new KeyboardRow();
        KeyboardRow fourthRow = new KeyboardRow();
        KeyboardRow fifthRow = new KeyboardRow();
        KeyboardRow sixthRow = new KeyboardRow();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        switch (text) {
            case "Меню":
                mainMenu(keyboard, leftRow, rightRow);
                return "Выбери";
            case "Расписание":

            File file = new File("src/main/resources/Schedule.pdf");
            sendDoc(message, file);
                replyKeyboardMarkup.setKeyboard(keyboard);
                mainMenu(keyboard, leftRow, rightRow);
                return "Прошу";
            case "Лекции":
                keyboard.clear();
                leftRow.clear();
                rightRow.clear();
                thirdRow.clear();
                fourthRow.clear();
                fifthRow.clear();
                sixthRow.clear();
                leftRow.add("1. Введение в Java.JDK, IntelliJ IDEA, Git.");
                leftRow.add("2. Лексика языка. Типы данных.");
                leftRow.add("3. Модуль компиляции и его структура. Преобразование типов.");
                rightRow.add("4. Массивы. Операторы и структура кода. Исключения.");
                rightRow.add("5. Модель памяти Java. Механизмы отражения и проксирования.");
                rightRow.add("6. Пакет java.util. Родовые типы Java(Generics).");
                thirdRow.add("7. ClassLoaders.");
                thirdRow.add("8. Введение в сетевые протоколы. Пакет java.io и работа с ресурсами.");
                thirdRow.add("9. Потоки выполнения. Синхронизация. Часть 1.");
                fourthRow.add("10. Потоки выполнения. Синхронизация. Часть 2.");
                fourthRow.add("11. Stream API и лямбда выражения.");
                fourthRow.add("12. Основы Java EE. UML");
                fifthRow.add("13. JVM, JIT, GC.");
                fifthRow.add("14. Инструменты сборки");
                fifthRow.add("15. Модульное тестирование на базе Junit 5. Часть 1.");
                sixthRow.add("16. Модульное тестирование на базе Junit 5. Часть 2");
                sixthRow.add("17. Системы контроля версий файлов");
                sixthRow.add("18. Фреймворки логирования. Системы CI и прочие инструменты");
                sixthRow.add("Меню");
                keyboard.add(leftRow);
                keyboard.add(rightRow);
                keyboard.add(thirdRow);
                keyboard.add(fourthRow);
                keyboard.add(fifthRow);
                keyboard.add(sixthRow);
                replyKeyboardMarkup.setKeyboard(keyboard);
                return "Выбери тему: ";
            case "1. Введение в Java.JDK, IntelliJ IDEA, Git.":
                fabric(new Lesson1(), message);
                replyKeyboardMarkup.setKeyboard(keyboard);
                mainMenu(keyboard, leftRow, rightRow);
                return "Прошу";
            case "2. Лексика языка. Типы данных.":
                fabric(new Lesson2(), message);
                replyKeyboardMarkup.setKeyboard(keyboard);
                mainMenu(keyboard, leftRow, rightRow);
                return "Прошу";
            case "3. Модуль компиляции и его структура. Преобразование типов.":
                fabric(new Lesson3(), message);
                replyKeyboardMarkup.setKeyboard(keyboard);
                mainMenu(keyboard, leftRow, rightRow);
                return "Прошу";
            case "4. Массивы. Операторы и структура кода. Исключения.":
                fabric(new Lesson4(), message);
                replyKeyboardMarkup.setKeyboard(keyboard);
                mainMenu(keyboard, leftRow, rightRow);
                return "Прошу";
            case "5. Модель памяти Java. Механизмы отражения и проксирования.":
                fabric(new Lesson5(), message);
                fabric(new Lesson5_2(), message);
                replyKeyboardMarkup.setKeyboard(keyboard);
                mainMenu(keyboard, leftRow, rightRow);
                return "Прошу";
            case "6. Пакет java.util. Родовые типы Java(Generics).":
                fabric(new Lesson6(), message);
                fabric(new Lesson6_2(), message);
                replyKeyboardMarkup.setKeyboard(keyboard);
                mainMenu(keyboard, leftRow, rightRow);
                return "Прошу";
            case "7. ClassLoaders.":
                fabric(new Lesson7(), message);
                replyKeyboardMarkup.setKeyboard(keyboard);
                mainMenu(keyboard, leftRow, rightRow);
                return "Прошу";
            case "8. Введение в сетевые протоколы. Пакет java.io и работа с ресурсами.":
                fabric(new Lesson8(), message);
                replyKeyboardMarkup.setKeyboard(keyboard);
                mainMenu(keyboard, leftRow, rightRow);
                return "Прошу";
            case "9. Потоки выполнения. Синхронизация. Часть 1.":
                fabric(new Lesson9(), message);
                replyKeyboardMarkup.setKeyboard(keyboard);
                mainMenu(keyboard, leftRow, rightRow);
                return "Прошу";
            case "10. Потоки выполнения. Синхронизация. Часть 2.":
                fabric(new Lesson10(), message);
                replyKeyboardMarkup.setKeyboard(keyboard);
                mainMenu(keyboard, leftRow, rightRow);
                return "Прошу";
            case "11. Stream API и лямбда выражения.":
                fabric(new Lesson11(), message);
                replyKeyboardMarkup.setKeyboard(keyboard);
                mainMenu(keyboard, leftRow, rightRow);
                return "Прошу";
            case "12. Основы Java EE. UML":
                fabric(new Lesson12(), message);
                replyKeyboardMarkup.setKeyboard(keyboard);
                mainMenu(keyboard, leftRow, rightRow);
                return "Прошу";
            case "13. JVM, JIT, GC.":
                fabric(new Lesson13(), message);
                replyKeyboardMarkup.setKeyboard(keyboard);
                mainMenu(keyboard, leftRow, rightRow);
                return "Прошу";
            case "14. Инструменты сборки":
                fabric(new Lesson14(), message);
                replyKeyboardMarkup.setKeyboard(keyboard);
                mainMenu(keyboard, leftRow, rightRow);
                return "Прошу";
            case "15. Модульное тестирование на базе Junit 5. Часть 1.":
                fabric(new Lesson15(), message);
                replyKeyboardMarkup.setKeyboard(keyboard);
                mainMenu(keyboard, leftRow, rightRow);
                return "Прошу";
            case "16. Модульное тестирование на базе Junit 5. Часть 2":
                fabric(new Lesson16(), message);
                replyKeyboardMarkup.setKeyboard(keyboard);
                mainMenu(keyboard, leftRow, rightRow);
                return "Прошу";
            case "17. Системы контроля версий файлов":
                fabric(new Lesson17(), message);
                replyKeyboardMarkup.setKeyboard(keyboard);
                mainMenu(keyboard, leftRow, rightRow);
                return "Прошу";
            case "18. Фреймворки логирования. Системы CI и прочие инструменты":
                fabric(new Lesson18(), message);
                fabric(new Lesson18_2(), message);
                replyKeyboardMarkup.setKeyboard(keyboard);
                mainMenu(keyboard, leftRow, rightRow);
                return "Прошу";
            case "Задания":
                keyboard.clear();
                leftRow.clear();
                rightRow.clear();
                leftRow.add("Домашнее задание 1");
                leftRow.add("Домашнее задание 3");
                leftRow.add("Домашнее задание 8");
                leftRow.add("Домашнее задание 18");
                rightRow.add("Домашнее задание 2");
                rightRow.add("Домашнее задание 4");
                rightRow.add("Домашнее задание 6");
                rightRow.add("Домашнее задание 12");
                rightRow.add("Меню");
                keyboard.add(leftRow);
                keyboard.add(rightRow);
                replyKeyboardMarkup.setKeyboard(keyboard);
                return "Выбери задание:";
            case "Домашнее задание 1":
                return "Установить и настроить рабочее окружение: JDK, IntelliJ Idea, git.\n" +
                        "Создать простеший проект, выводящий в консоль \"Hello, World.\", запушить его в git.";
            case "Домашнее задание 2":
                return "Спроектировать и реализовать класс, реализующий коллекцию типа \"хеш-таблица\" (hash-map), или " +
                        "двунаправленная хеш-таблица (bi-map), без использования стандартных или библиотечных реализаций" +
                        " коллекций (можно использовать массивы). В качестве ключей и значений могут использоваться " +
                        "любые объекты. В коллекции должны быть методы добавления, обновления, получения, удаления " +
                        "элемента, проверка наличия элемента по ключу (и по значению в случае двунаправленной таблицы), " +
                        "получение количества элементов в коллекции.  В случае совершения недопустимых операций " +
                        "выбрасывать исключения. Протестировать работоспособность с помощью юнит-тестов, включая " +
                        "положительные (при корректных операциях с коллекцией она ведет себя корректно), и негативные " +
                        "тесты (исключения при некоректных операциях).\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "** Дополнительное необязательное задание:\n" +
                        "\n" +
                        "К предыдущей реализации добавить новую, с аналогичным интерфейсом взаимодействия, на основе " +
                        "сбалансированного дерева поиска (АВЛ или красно-черное на выбор). При совершении серии " +
                        "одинаковых операций коллекции должны выдавать одинаковый результат.";
            case "Домашнее задание 3":
                return "Доработать домашнее задание 2 следующим образом:\n" +
                        "Сделать написанную ранее реализацию HashMap параметризуемой типами ключа и значения (используя дженерики).\n" +
                        "Реализовать в своем классе стандартный интерфейс java.util.Map.\n" +
                        "В тестах сравнить поведение основных операций с HashMap, оно не должно отличаться.\n" +
                        "Для реализации public Set<Entry> entrySet(),  public Collection values(), public Set keySet() " +
                        "можно использовать стандартные коллекции Java.";
            case "Домашнее задание 4":
                return "Необходимо реализовать метов void cleanup(Object object, Set<String> fieldsToCleanup, " +
                        "Set<String> fieldsToOutput), принимающий любой объект и две коллекции строк. В объекте, " +
                        "посредством reflection надо поля, перечисленные в fieldsToClenup установить в значение null, " +
                        "или, если поля примитивных типов в их значение по умолчанию. Поля, перечисленные в " +
                        "fieldsToOutput сконвертировать в строку (вызвав toString у объектов, или String.valueOf " +
                        "для примитивных типов) и вывести результат преобразования в консоль. Если переданный первым " +
                        "параметром объект является реализацией интерфейса Map, то проделать аналогичные операции - " +
                        "для списка fieldsToCleanup удалить ключи из мапы, для fieldsToOutput вывести в консоль " +
                        "значения, хранящиеся в мапе. При отсутствии в объекте/мапе нузных полей/ключей - падать с " +
                        "IllegalArgumentException, оставив объект неизменным.";
            case "Домашнее задание 6":
                return "Реализовать на сокетах простейший HTTP 1.1 сервер, который на любой GET запрос выдает список " +
                        "файлов и директорий в текущей директории. На остальные запросы отдавать 404.";
            case "Домашнее задание 8":
                return "Рализовать однопоточную и многопоточную версию игры \"жизнь\" с квадратным замкнутым полем " +
                        "(https://ru.wikipedia.org/wiki/%D0%98%D0%B3%D1%80%D0%B0_%C2%AB%D0%96%D0%B8%D0%B7%D0%BD%D1%8C%C2%BB). " +
                        "Начальная конфигурация поля считывается из файла, конечная пишется в файл, имена файлов и " +
                        "количество шагов для расчета задается агрументами коммандной строки. Визуализацию процесса " +
                        "делать не обязательно. Для распаралеливания можно использовать любой подход. В юнит-тесте" +
                        " посмотреть и сравнить приблизительное время выполнения однопоточной и многопоточной версии " +
                        "на одних и тех же данных.";
            case "Домашнее задание 12":
                return "Реализовать EJB бин с методом, возвращающим содержимое домашнего каталога пользователя " +
                        "(рекурсивно вглубь). Создать JSP страницу, выводящую в виде дерева результат работы EJB " +
                        "из предыдущего пункта.";
            case "Домашнее задание 18":
                return "Упаковать ранее сделанное ДЗ 12 в Docker контейнер (написа Dockerfile), и сконфигурировать " +
                        "запуск контейнера с помощью docker-compose (написав docker-compose.yml). Запустить получившийся" +
                        " контейнер, добиться его доступности из браузера.\n" +
                        "\n" +
                        "Полезные ссылки:\n" +
                        "\n" +
                        "https://docs.docker.com/engine/reference/builder/\n" +
                        "\n" +
                        "https://docs.docker.com/compose/compose-file/\n" +
                        "\n";
    }
    return "Не верное состояние ответа.";
    }

    public void fabric(Lesson lesson, Message message) {
        sendDoc(message, lesson.getMethods());
        sendDoc(message, lesson.getPresentation());
    }



    public void mainMenu(ArrayList<KeyboardRow> keyboard, KeyboardRow leftRow, KeyboardRow rightRow) {
        keyboard.clear();
        leftRow.clear();
        rightRow.clear();
        leftRow.add("Расписание");
        leftRow.add("Лекции");
        rightRow.add("Задания");
        keyboard.add(leftRow);
        keyboard.add(rightRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }
    @Override
    public String getBotToken() {
        return "902774919:AAFl94BunXxpk1kxeeviwqe4WVCNgJv8znI";
        //Токен бота
    }

}
