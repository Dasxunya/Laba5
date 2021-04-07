package ru.dasxunya.menu;

import org.junit.jupiter.api.*;
import ru.dasxunya.utils.*;

import java.util.*;
import java.util.function.*;

import static ru.dasxunya.UtilsTest.*;

public class UpdateTest {
	@Test
	void UpdateByIdWithHumans() {

		String input = Utils.collectStrings(id.toString(), GetTestInputStringsFromAddWithNormalSpeed());

		String expected = Utils.collectStrings(
				"Введите идентификатор: ",
				"Обновление элемента в коллекции: ",
				GetTestOutputStringsFromAdd()
		                                      );

		Consumer<Scanner> method = scanner -> {
			AddExampleHumanToCollection();
			Update.run(scanner);
		};

		runTest(input, expected, method);
	}
}
