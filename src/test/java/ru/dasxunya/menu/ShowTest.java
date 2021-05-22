package ru.dasxunya.menu;

import org.junit.jupiter.api.*;
import ru.dasxunya.utils.*;

import java.util.*;
import java.util.function.*;

import static ru.dasxunya.UtilsTest.*;

public class ShowTest {
	@Test
	void ShowWithoutHumans() {
		String input = Utils.collectStrings();
		String expected = Utils.collectStrings("Элементы коллекции: ",
		                                       "Коллекция пуста!");

		Consumer<Scanner> method = scanner -> {
			Show.run();
		};

		runTest(input, expected, method);
	}

	@Test
	void ShowWithHumans() {
		String input = Utils.collectStrings();
		String expected = Utils.collectStrings("Элементы коллекции: ",
		                                       stringHumanBeingWithNormalSpeed);

		Consumer<Scanner> method = scanner -> {
			AddExampleHumanToCollection();
			Show.run();
		};

		runTest(input, expected, method);
	}
}
