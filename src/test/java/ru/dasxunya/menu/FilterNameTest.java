package ru.dasxunya.menu;

import org.junit.jupiter.api.*;
import ru.dasxunya.utils.*;

import java.util.*;
import java.util.function.*;

import static ru.dasxunya.UtilsTest.*;

public class FilterNameTest {
	@Test
	void MenuFilterNameWithoutHumansTest() {
		String input = Utils.collectStrings();
		String expected = Utils.collectStrings("Значение поля name начинается с заданной подстроки: ",
		                                       "Коллекция пустая! Поиск невозможен!"
		                                      );

		Consumer<Scanner> method = scanner -> {
			FilterName.run(scanner);
		};

		runTest(input, expected, method);

	}

	@Test
	void MenuFilterNameWithHumansTest() {
		String input = Utils.collectStrings("А");
		String expected = Utils.collectStrings("Значение поля name начинается с заданной подстроки: ",
		                                       "Введите имя: ",
		                                       stringHumanBeingWithNormalSpeed,
		                                       stringHumanBeingWithHighSpeed
		                                      );

		Consumer<Scanner> method = scanner -> {
			Add3ExampleHumansToCollection();
			FilterName.run(scanner);
		};

		runTest(input, expected, method);

	}
}
