package ru.dasxunya.menu;

import org.junit.jupiter.api.*;
import ru.dasxunya.utils.*;

import static ru.dasxunya.UtilsTest.*;
import static ru.dasxunya.utils.Utils.*;

public class HelpTest {
	@Test
	void MenuHelpTest() {
		String input = Utils.collectStrings("help", EXIT);
		String expected = Utils.collectStrings("""
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
								""",
		                                       "Завершение работы программы...");

		runTest(input, expected, main);
	}
}
