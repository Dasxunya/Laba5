package ru.dasxunya.menu;

import org.junit.jupiter.api.*;
import ru.dasxunya.core.*;
import ru.dasxunya.utils.*;

import java.util.*;
import java.util.function.*;

import static ru.dasxunya.UtilsTest.*;
import static ru.dasxunya.utils.Utils.*;

public class HistoryTest {
	@Test
	void MenuHistoryTest() {
		String input = Utils.collectStrings("history", "history", "history", "history", "history", "history", "history", "history", "history", "history", "history", "history", EXIT);
		String expected = Utils.collectStrings(
				"Введите команду: ",
				"Последние 11 команд: ",
				"history",
				"Введите команду: ",
				"Последние 11 команд: ",
				"history", "history",
				"Введите команду: ",
				"Последние 11 команд: ",
				"history", "history", "history",
				"Введите команду: ",
				"Последние 11 команд: ",
				"history", "history", "history", "history",
				"Введите команду: ",
				"Последние 11 команд: ",
				"history", "history", "history", "history", "history",
				"Введите команду: ",
				"Последние 11 команд: ",
				"history", "history", "history", "history", "history", "history",
				"Введите команду: ",
				"Последние 11 команд: ",
				"history", "history", "history", "history", "history", "history", "history",
				"Введите команду: ",
				"Последние 11 команд: ",
				"history", "history", "history", "history", "history", "history", "history", "history",
				"Введите команду: ",
				"Последние 11 команд: ",
				"history", "history", "history", "history", "history", "history", "history", "history", "history",
				"Введите команду: ",
				"Последние 11 команд: ",
				"history", "history", "history", "history", "history", "history", "history", "history", "history", "history",
				"Введите команду: ",
				"Последние 11 команд: ",
				"history", "history", "history", "history", "history", "history", "history", "history", "history", "history", "history",
				"Введите команду: ",
				"Последние 11 команд: ",
				"history", "history", "history", "history", "history", "history", "history", "history", "history", "history", "history",
				"Введите команду: ",
				"Завершение работы программы..."
		                                      );

		Consumer<Scanner> method = scanner -> {
			main.accept(scanner);
			Assertions.assertEquals(11, App.history.size());
		};

		runTest(input, expected, method);
	}
}
