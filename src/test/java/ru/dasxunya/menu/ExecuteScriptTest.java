package ru.dasxunya.menu;

import org.junit.jupiter.api.*;
import ru.dasxunya.utils.*;

import java.util.*;
import java.util.function.*;

import static ru.dasxunya.UtilsTest.*;

public class ExecuteScriptTest {
	@Test
	void ExecuteScriptWithoutExistFileTest() {
		String input = Utils.collectStrings();
		String expected = Utils.collectStrings("Считывание и исполнение скрипта: ",
		                                       "Файл не найден!"
		                                      );

//		Consumer<String> method = scanner -> {
//			Utils.SYSTEM_VARIABLE = "TTTTTTTTTTTTTTTTTTTTTT";
//			ExecuteScript.run(scanner);
//		};
//
//		runTest(input, expected, method);
	}

	@Test
	void ExecuteScriptWithExistFileTest() {
		String input = Utils.collectStrings();
		String expected = Utils.collectStrings("Считывание и исполнение скрипта: ",
		                                       "Элементы коллекции: ",
		                                       "Коллекция пуста!",
		                                       "Завершение работы программы..."
		                                      );

//		Consumer<Scanner> method = scanner -> {
//			ExecuteScript.run(scanner);
//		};
//
//		runTest(input, expected, method);
	}
}
