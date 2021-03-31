package ru.dasxunya;

import java.util.Scanner;
import java.util.TreeSet;

/*
Реализовать консольное приложение, которое реализует управление коллекцией объектов в интерактивном режиме. В коллекции необходимо хранить объекты класса HumanBeing, описание которого приведено ниже.

Разработанная программа должна удовлетворять следующим требованиям:

Класс, коллекцией экземпляров которого управляет программа, должен реализовывать сортировку по умолчанию.
Все требования к полям класса (указанные в виде комментариев) должны быть выполнены.
Для хранения необходимо использовать коллекцию типа java.util.TreeSet
При запуске приложения коллекция должна автоматически заполняться значениями из файла.
Имя файла должно передаваться программе с помощью: переменная окружения.
Данные должны храниться в файле в формате json
Чтение данных из файла необходимо реализовать с помощью класса java.io.FileReader
Запись данных в файл необходимо реализовать с помощью класса java.io.PrintWriter
Все классы в программе должны быть задокументированы в формате javadoc.
Программа должна корректно работать с неправильными данными (ошибки пользовательского ввода, отсутсвие прав доступа к файлу и т.п.).
В интерактивном режиме программа должна поддерживать выполнение следующих команд:

help : вывести справку по доступным командам+
info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)+
show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении+
add {element} : добавить новый элемент в коллекцию+
update id {element} : обновить значение элемента коллекции, id которого равен заданному+
remove_by_id id : удалить элемент из коллекции по его id+
clear : очистить коллекцию+
save : сохранить коллекцию в файл+
execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.+
exit : завершить программу (без сохранения в файл)+
add_if_max {element}+ : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
add_if_min {element}+ : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
history : вывести последние 11 команд (без их аргументов)
max_by_soundtrack_name : вывести любой объект из коллекции, значение поля soundtrackName которого является максимальным
filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки
print_unique_weapon_type : вывести уникальные значения поля weaponType всех элементов в коллекции
Формат ввода команд:

Все аргументы команды, являющиеся стандартными типами данных (примитивные типы, классы-оболочки, String, классы для хранения дат), должны вводиться в той же строке, что и имя команды.
Все составные типы данных (объекты классов, хранящиеся в коллекции) должны вводиться по одному полю в строку.
При вводе составных типов данных пользователю должно показываться приглашение к вводу, содержащее имя поля (например, "Введите дату рождения:")
Если поле является enum'ом, то вводится имя одной из его констант (при этом список констант должен быть предварительно выведен).
При некорректном пользовательском вводе (введена строка, не являющаяся именем константы в enum'е; введена строка вместо числа; введённое число не входит в указанные границы и т.п.) должно быть показано сообщение об ошибке и предложено повторить ввод поля.
Для ввода значений null использовать пустую строку.
Поля с комментарием "Значение этого поля должно генерироваться автоматически" не должны вводиться пользователем вручную при добавлении.
Описание хранимых в коллекции классов:

public class HumanBeing {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой+(проверка на пустое имя!)

    private Coordinates coordinates; //Поле не может быть null+
    private java.time.ZonedDateTime creationDate; (?)//Поле не может быть null, Значение этого поля должно генерироваться автоматически

    private Boolean realHero; //Поле не может быть null
    private boolean hasToothpick;
    private Double impactSpeed; //Максимальное значение поля: 10, Поле может быть null
    private String soundtrackName; //Поле не может быть null

    private WeaponType weaponType; //Поле не может быть null
    private Mood mood; //Поле может быть null
    private Car car; //Поле может быть null
}
public class Coordinates {
    private Long x; //Значение поля должно быть больше -146, Поле не может быть null
    private int y; //Максимальное значение поля: 270
}
public class Car {
    private String name; //Поле может быть null
    private boolean cool;
}
public enum WeaponType {
    AXE,
    PISTOL,
    RIFLE,
    KNIFE,
    BAT;
}
public enum Mood {
    SADNESS,
    LONGING,
    CALM,
    RAGE;
}
Отчёт по работе должен содержать:

Текст задания.
Диаграмма классов разработанной программы.
Исходный код программы.
Выводы по работе.
 */
public class App {

    static TreeSet<HumanBeing> humanBeings = new TreeSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (scanner.hasNext()) {
            command = scanner.next();

            switch (command) {
                case "help" -> {
                    System.out.println(
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


                    );
                }
                case "info" -> {
                    System.out.println("Информация о коллекции:");
                }
                case "show" -> {
                    System.out.println("Элементы коллекции:");
                }
                case "add" -> {
                    System.out.println("Добавление элемента в коллекцию:");

                    // TODO: генерируем идентификатор.
                    Integer id = 10;

                    if (id == null) {
                        throw new NullPointerException("id оказался null!");
                    }
                    if (id <= 0) {
                        throw new IllegalArgumentException("id не может быть отрицательным или равным нулю!");
                    }

                    System.out.println("Введите имя: ");
                    String name = scanner.next();
                    if (name == null) {
                        throw new NullPointerException("name не может быть null!");
                    }
                    if (name.equals(" ")) {
                        throw new IllegalArgumentException("Введите значение для name!");
                    }

                    System.out.println("Создание координат: ");

                    Long x = null;
                    while (true) {
                        System.out.println("Введите x: ");

                        try {
                            x = Long.valueOf(scanner.next());
                            break;
                        } catch (NumberFormatException exception) {
                            System.out.println("Некорректный аргумент для переменной х!");
                        }
                    }

                    int y;

                    while (true) {
                        System.out.println("Введите y: ");

                        try {
                            y = Integer.parseInt(scanner.next());
                            break;
                        } catch (NumberFormatException exception) {
                            System.out.println("Некорректный аргумент для переменной y!");
                        }
                    }

                    Coordinates coordinates = new Coordinates(x, y);

                    System.out.println("Является ли человек реальным: ");

                   /* Boolean realHero;
                    while (true) {
                        System.out.println("Человеческое существо реально? ");
                        try {
                            if (scanner.next().equals("true")) {
                                realHero = true;
                                break;
                            }
                            if (scanner.next().equals("false")) {
                                realHero = false;
                                break;
                            }
                        } catch (NumberFormatException exception) {
                            System.out.println("Некорректный аргумент для realHero (Необходимо: true или false)! ");
                        }
                    }*/

                    System.out.println("Имеется ли у существа зубочистка: ");

                     /*Boolean hasToothpick;
                    while (true) {
                        System.out.println("Человеческое существо с зубочисткой? ");
                        try {
                            if (scanner.next().equals("true")) {
                                hasToothpick = true;
                                break;
                            }
                            if (scanner.next().equals("false")) {
                                hasToothpick = false;
                                break;
                            }
                        } catch (NumberFormatException exception) {
                            System.out.println("Некорректный аргумент для hasToothpick (Необходимо: true или false)! ");
                        }
                    }*/

                    System.out.println("Скорость удара существа: ");
                    Double impactSpeed;
                    while (true) {
                        System.out.println("Введите скорость удара: ");

                        try {
                            impactSpeed = Double.parseDouble(scanner.nextLine());
                            break;
                        } catch (NumberFormatException exception) {
                            System.out.println("Некорректный аргумент для переменной impactSpeed (Необходимо: [0;10])! ");
                        }
                    }

//                    HumanBeing humanBeing = new HumanBeing(id, name, coordinates, )
//
//
//                    humanBeings.add(humanBeing);
                }
                case "update_id" -> {
                    System.out.println("Обновлен элемент коллекции:");
                }
                case "remove_by_id" -> {
                    System.out.println("Удален элемент коллекции:");
                }
                case "clear" -> {
                    System.out.println("Коллекция очищена");
                }
                case "save" -> {
                    System.out.println("Коллекция сохранена в файл");
                }
                case "exit" -> {
                    return;
                }
                case "execute_script" -> {
                    System.out.println("Считывание и исполнение скрипта");
                }
                case "add_if_max" -> {
                    System.out.println("Если элемент больше максимального, добавление в коллекцию");
                }
                case "add_if_min" -> {
                    System.out.println("Если элемент меньше минимального, добавление в коллекцию");
                }
                case "history" -> {
                    System.out.println("Последние 11 команд:");
                }
                case "max_soundtrack" -> {
                    System.out.println("SoundtrackName является максимальным:");
                }
                case "filter_name" -> {
                    System.out.println("Значение поля name начинается с заданной подстроки:");
                }
                case "unique_weapon" -> {
                    System.out.println("Уникальные значения поля weaponType:");
                }
            }


        }
    }

}
