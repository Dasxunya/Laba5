package ru.dasxunya.core;

import ru.dasxunya.menu.*;
import java.util.*;

/**
 * The type App.
 */
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
    private Double impactSpeed; //Максимальное значение поля: 10, Поле МОЖЕТ быть null
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

	/**
	 * The constant humanBeings.
	 */
	public static TreeSet<HumanBeing> humanBeings = new TreeSet<>();
	/**
	 * The constant history.
	 */
	public static LinkedList<String> history = new LinkedList<>();

	public static boolean execute_script_completed = false;
	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Load.run();
		Menu(scanner);
	}

	/**
	 * Menu.
	 *
	 * @param scanner the scanner
	 */
	public static void Menu(Scanner scanner) {
		String command;

		while (true) {
			System.out.println("Введите команду: ");
			command = scanner.nextLine();

			switch (command) {
				case "help":
					Help.run();
					break;
				case "info":
					Info.run();
					break;
				case "show":
					Show.run();
					break;
				case "add":
					Add.run(scanner);
					break;
				case "update_id":
					Update.run(scanner);
					break;
				case "remove_by_id":
					RemoveById.run(scanner);
					break;
				case "clear":
					Clear.run();
					break;
				case "save":
					Save.run();
					break;
				case "add_if_max":
					AddIfMax.run(scanner);
					break;
				case "add_if_min":
					AddIfMin.run(scanner);
					break;
				case "history":
					History.run();
					break;
				case "max_soundtrack":
					MaxSoundtrack.run();
					break;
				case "filter_name":
					FilterName.run(scanner);
					break;
				case "unique_weapon":
					UniqueWeapon.run();
					break;
				case "exit":
					Exit.run();
					return;
				default:
					String commandExecuteScript = "execute_script ";
					if (command.indexOf(commandExecuteScript) == 0)
					{
						String path = command.substring(commandExecuteScript.length()).trim();
						ExecuteScript.run(path);
					}

					break;
			}
		}
	}

}
