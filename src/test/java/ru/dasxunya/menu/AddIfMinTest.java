package ru.dasxunya.menu;

import org.junit.jupiter.api.*;
import ru.dasxunya.core.*;
import ru.dasxunya.utils.*;

import java.util.*;
import java.util.function.*;

import static ru.dasxunya.UtilsTest.*;
import static ru.dasxunya.utils.Utils.*;

public class AddIfMinTest {
	@Test
	void MenuAddIfMinWithoutHumansTest() {
		String input = Utils.collectStrings(GetTestInputStringsFromAddWithNormalSpeed(), EXIT);
		String expected = Utils.collectStrings("Если элемент меньше минимального, добавление в коллекцию: ",
		                                       GetTestOutputStringsFromAdd(),
		                                       "Скорость удара существа оказалась меньше минимальных значений в коллекции. Добавляем существо в коллекцию!"
		                                      );

		Consumer<Scanner> method = scanner -> {
			AddIfMin.run(scanner);
			Assertions.assertEquals(1, App.humanBeings.size());
		};

		runTest(input, expected, method);
	}

	@Test
	void MenuAddIfMinWithHumansAndNewMinTest() {
		String input = Utils.collectStrings(GetTestInputStringsFromAddWithLowSpeed(), EXIT);
		String expected = Utils.collectStrings("Если элемент меньше минимального, добавление в коллекцию: ",
		                                       GetTestOutputStringsFromAdd(),
		                                       "Скорость удара существа оказалась меньше минимальных значений в коллекции. Добавляем существо в коллекцию!"
		                                      );

		Consumer<Scanner> method = scanner -> {
			AddExampleHumanToCollection();
			AddIfMin.run(scanner);
			Assertions.assertEquals(2, App.humanBeings.size());
		};

		runTest(input, expected, method);
	}

	@Test
	void MenuAddIfMinWithHumansAndWithoutNewMinTest() {
		String input = Utils.collectStrings(GetTestInputStringsFromAddWithHighSpeed(), EXIT);
		String expected = Utils.collectStrings("Если элемент меньше минимального, добавление в коллекцию: ",
		                                       GetTestOutputStringsFromAdd(),
		                                       "Скорость удара существа оказалась больше минимальных значений в коллекции. Существо не добавляем!"
		                                      );

		Consumer<Scanner> method = scanner -> {
			AddExampleHumanToCollection();
			AddIfMin.run(scanner);
			Assertions.assertEquals(1, App.humanBeings.size());
		};

		runTest(input, expected, method);
	}
}
