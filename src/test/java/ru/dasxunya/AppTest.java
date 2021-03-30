package ru.dasxunya;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class AppTest {
    private static final PrintStream originalOutput = System.out;
    private static final InputStream originalInput = System.in;

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String EXIT = "exit";

    private ByteArrayOutputStream outputContent;
    private ByteArrayInputStream inputContent;

    @BeforeEach
    public void setUpStreams() {
        outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
    }

    private void provideInput(String data) {
        inputContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputContent);
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOutput);
        System.setIn(originalInput);
    }

    private String collectStrings(String... cases) {
        return String.join(LINE_SEPARATOR, cases).concat(LINE_SEPARATOR);
    }


    private void launchApplication(String input, String expected) {
        provideInput(input);

        App.main(new String[0]);

        String actual = outputContent.toString();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void MenuExitTest() {
        launchApplication(EXIT, "");
    }

    @Test
    void MenuHelpTest() {
        launchApplication(
                collectStrings("help", EXIT),
                collectStrings(

                        """
                              Меню:                             
                              help : вывести справку по доступным командам
                              info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                              show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                              add {element} : добавить новый элемент в коллекцию
                              update id {element} : обновить значение элемента коллекции, id которого равен заданному
                              remove_by_id id : удалить элемент из коллекции по его id
                              clear : очистить коллекцию
                              save : сохранить коллекцию в файл
                              execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
                              exit : завершить программу (без сохранения в файл)
                              add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
                              add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
                              history : вывести последние 11 команд (без их аргументов)
                              max_by_soundtrack_name : вывести любой объект из коллекции, значение поля soundtrackName которого является максимальным
                              filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки
                              print_unique_weapon_type : вывести уникальные значения поля weaponType всех элементов в коллекции
                              """
                )
        );
    }

    @Test
    void MenuInfoTest() {
        launchApplication(
                collectStrings("info", EXIT),
                collectStrings("Информация о коллекции:")
        );
    }

    @Test
    void MenuShowTest() {
        launchApplication(
                collectStrings("show", EXIT),
                collectStrings("Элементы коллекции:")
        );
    }

    @Test
    void MenuAddTest() {
        launchApplication(
                collectStrings("add", "Дима", "123L", "asdgasdgds", "34", "46L", "47", EXIT),
                collectStrings("Добавление элемента в коллекцию:",
                        "Введите имя: ",
                        "Создание координат: ",
                        "Введите x: ",
                        "Некорректный аргумент для переменной х!",
                        "Введите x: ",
                        "Некорректный аргумент для переменной х!",
                        "Введите x: ",
                        "Введите y: ",
                        "Некорректный аргумент для переменной y!",
                        "Введите y: "
                        )
        );
    }

    @Test
    void MenuUpdateIdTest() {
        launchApplication(
                collectStrings("update_id", EXIT),
                collectStrings("Обновлен элемент коллекции:")
        );
    }

    @Test
    void MenuRemoveIdTest() {
        launchApplication(
                collectStrings("remove_by_id", EXIT), //Как обозначить удаление конкретного id?
                collectStrings("Удален элемент коллекции:")
        );
    }

    @Test
    void MenuClearTest() {
        launchApplication(
                collectStrings("clear", EXIT),
                collectStrings("Коллекция очищена")
        );
    }

    @Test
    void MenuSaveTest() {
        launchApplication(
                collectStrings("save", EXIT),
                collectStrings("Коллекция сохранена в файл")
        );
    }

    @Test
    void MenuExecuteScriptTest() {
        launchApplication(
                collectStrings("execute_script", EXIT),
                collectStrings("Считывание и исполнение скрипта")
        );
    }

    @Test
    void MenuAddIfMaxTest() {
        launchApplication(
                collectStrings("add_if_max", EXIT),
                collectStrings("Если элемент больше максимального, добавление в коллекцию")
        );
    }

    @Test
    void MenuAddIfMinTest() {
        launchApplication(
                collectStrings("add_if_min", EXIT),
                collectStrings("Если элемент меньше минимального, добавление в коллекцию")
        );
    }

    @Test
    void MenuHistoryTest() {
        launchApplication(
                collectStrings("history", EXIT),
                collectStrings("Последние 11 команд:")
        );
    }

    @Test
    void MenuMaxSoundtrackNameTest() {
        launchApplication(
                collectStrings("max_soundtrack", EXIT),
                collectStrings("SoundtrackName является максимальным:")
        );
    }

    @Test
    void MenuFilterStartsWithNameTest() {
        launchApplication(
                collectStrings("filter_name", EXIT),
                collectStrings("Значение поля name начинается с заданной подстроки:")
        );
    }

    @Test
    void MenuPrintUniqueWeaponTypeTest() {
        launchApplication(
                collectStrings("unique_weapon", EXIT),
                collectStrings("Уникальные значения поля weaponType:")
        );
    }
    // TODO: Расписать все тесты на все пункты меню.

}
