package ru.dasxunya;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    void MenuExitTest() {
        Utils.launchApplication(Utils.EXIT, "");
    }

    @Test
    void MenuHelpTest() {
        Utils.launchApplication(
                Utils.collectStrings("help", Utils.EXIT),
                Utils.collectStrings(

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
        Utils.launchApplication(
                Utils.collectStrings("info", Utils.EXIT),
                Utils.collectStrings("Информация о коллекции:")
        );
    }

    @Test
    void MenuShowTest() {
        Utils.launchApplication(
                Utils.collectStrings("show", Utils.EXIT),
                Utils.collectStrings("Элементы коллекции:")
        );
    }

    @Test
    void MenuAddTest() {

        String input = Utils.collectStrings("add", "Дима", "34", "47", "true", "false", "5", "Soundtrack", "KNIFE", "SADNESS", "LADA", "true", Utils.EXIT);
        Utils.launchApplication(
                input,
                Utils.collectStrings("Добавление элемента в коллекцию: ",
                        "Введите имя: ",
                        "Создание координат: ",
                        "Введите x: ",
                        "Введите y: ",
                        "Является ли человек реальным: ",
                        "Человеческое существо реально? ",
                        "Имеется ли у существа зубочистка: ",
                        "Человеческое существо с зубочисткой? ",
                        "Скорость удара существа: ",
                        "Введите скорость удара: ",
                        "Саундтрек: ",
                        "Введите имя саундтрека: ",
                        "Тип оружия: ",
                        "Введите тип оружия: ",
                        "Введите настроение: ",
                        "Характеристики машины: ",
                        "Введите название автомобиля: ",
                        "Машина хорошая?"
                ));
    }

//    @Test
//    void MenuUpdateIdTest() {
//        Utils.launchApplication(
//                Utils.collectStrings("update_id", Utils.EXIT),
//                Utils.collectStrings("Обновлен элемент коллекции:")
//        );
//    }

    @Test
    void MenuRemoveIdTest() {
        Utils.launchApplication(
                Utils.collectStrings("remove_by_id", Utils.EXIT), //Как обозначить удаление конкретного id?
                Utils.collectStrings("Удален элемент коллекции:")
        );
    }

    @Test
    void MenuClearTest() {
        Utils.launchApplication(
                Utils.collectStrings("clear", Utils.EXIT),
                Utils.collectStrings("Коллекция очищена")
        );
    }

    @Test
    void MenuSaveTest() {
        Utils.launchApplication(
                Utils.collectStrings("save", Utils.EXIT),
                Utils.collectStrings("Коллекция сохранена в файл")
        );
    }

    @Test
    void MenuExecuteScriptTest() {
        Utils.launchApplication(
                Utils.collectStrings("execute_script", Utils.EXIT),
                Utils.collectStrings("Считывание и исполнение скрипта")
        );
    }

    @Test
    void MenuAddIfMaxTest() {
        Utils.launchApplication(
                Utils.collectStrings("add_if_max", Utils.EXIT),
                Utils.collectStrings("Если элемент больше максимального, добавление в коллекцию")
        );
    }

    @Test
    void MenuAddIfMinTest() {
        Utils.launchApplication(
                Utils.collectStrings("add_if_min", Utils.EXIT),
                Utils.collectStrings("Если элемент меньше минимального, добавление в коллекцию")
        );
    }

    @Test
    void MenuHistoryTest() {
        Utils.launchApplication(
                Utils.collectStrings("history", Utils.EXIT),
                Utils.collectStrings("Последние 11 команд:")
        );
    }

    @Test
    void MenuMaxSoundtrackNameTest() {
        Utils.launchApplication(
                Utils.collectStrings("max_soundtrack", Utils.EXIT),
                Utils.collectStrings("SoundtrackName является максимальным:")
        );
    }

    @Test
    void MenuFilterStartsWithNameTest() {
        Utils.launchApplication(
                Utils.collectStrings("filter_name", Utils.EXIT),
                Utils.collectStrings("Значение поля name начинается с заданной подстроки:")
        );
    }

    @Test
    void MenuPrintUniqueWeaponTypeTest() {
        Utils.launchApplication(
                Utils.collectStrings("unique_weapon", Utils.EXIT),
                Utils.collectStrings("Уникальные значения поля weaponType:")
        );
    }
    // TODO: Расписать все тесты на все пункты меню.

}
