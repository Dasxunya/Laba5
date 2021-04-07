package ru.dasxunya.menu;

import org.junit.jupiter.api.*;
import ru.dasxunya.core.*;
import ru.dasxunya.utils.*;

import java.util.*;
import java.util.function.*;

import static ru.dasxunya.UtilsTest.*;
import static ru.dasxunya.utils.Utils.*;

public class AddIfMaxTest {

	@Test
	void MenuAddIfMaxWithoutHumansTest() {
		String input = Utils.collectStrings(GetTestInputStringsFromAddWithNormalSpeed(), EXIT);
		String expected = Utils.collectStrings("Если элемент больше максимального, добавление в коллекцию: ",
		                                       GetTestOutputStringsFromAdd(),
		                                       "Скорость удара существа оказалась больше максимальных значений в коллекции. Добавляем существо в коллекцию!"
		                                      );

		Consumer<Scanner> method = scanner -> {
			AddIfMax.run(scanner);
			Assertions.assertEquals(1, App.humanBeings.size());
		};

		runTest(input, expected, method);
	}

	@Test
	void MenuAddIfMaxWithHumansAndNewMaxTest() {
		String input = Utils.collectStrings(GetTestInputStringsFromAddWithHighSpeed(), EXIT);
		String expected = Utils.collectStrings("Если элемент больше максимального, добавление в коллекцию: ",
		                                       GetTestOutputStringsFromAdd(),
		                                       "Скорость удара существа оказалась больше максимальных значений в коллекции. Добавляем существо в коллекцию!"
		                                      );

		Consumer<Scanner> method = scanner -> {
			AddExampleHumanToCollection();
			AddIfMax.run(scanner);
			Assertions.assertEquals(2, App.humanBeings.size());
		};

		runTest(input, expected, method);
	}

	@Test
	void MenuAddIfMaxWithHumansAndWithoutNewMaxTest() {
		String input = Utils.collectStrings(GetTestInputStringsFromAddWithLowSpeed(), EXIT);
		String expected = Utils.collectStrings("Если элемент больше максимального, добавление в коллекцию: ",
		                                       GetTestOutputStringsFromAdd(),
		                                       "Скорость удара существа оказалась меньше максимальных значений в коллекции. Существо не добавляем!"
		                                      );


		Consumer<Scanner> method = scanner -> {
			AddExampleHumanToCollection();
			AddIfMax.run(scanner);
			Assertions.assertEquals(1, App.humanBeings.size());
		};

		runTest(input, expected, method);
	}
}
