package ru.dasxunya.menu;

import org.junit.jupiter.api.*;
import ru.dasxunya.utils.*;

import java.util.*;
import java.util.function.*;

import static ru.dasxunya.UtilsTest.*;

public class InfoTest {
	@Test
	void InfoWithoutHumans() {
		String input = Utils.collectStrings("info");
		String expected = Utils.collectStrings("Информация о коллекции HumanBeings: ",
		                                       "Коллекция пуста!"
		                                      );

		Consumer<Scanner> method = scanner -> {
			Info.run(scanner);
		};

		runTest(input, expected, method);
	}

	@Test
	void InfoWithHumans() {
		String input = Utils.collectStrings("info");
		String expected = Utils.collectStrings("Информация о коллекции HumanBeings: ",
		                                       "Количество: 3",
		                                       stringHumanBeingWithNormalSpeed,
		                                       stringHumanBeingWithLowSpeed,
		                                       stringHumanBeingWithHighSpeed);

		Consumer<Scanner> method = scanner -> {
			Add3ExampleHumansToCollection();
			Info.run(scanner);
		};

		runTest(input, expected, method);
	}

}
