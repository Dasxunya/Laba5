package ru.dasxunya.menu;

import com.fasterxml.jackson.core.*;
import org.junit.jupiter.api.*;
import ru.dasxunya.utils.*;

import java.util.*;
import java.util.function.*;

import static ru.dasxunya.UtilsTest.*;

public class SaveTest {
	@Test
	void MenuSaveTest() throws JsonProcessingException {
		String input = "";
		String expected = Utils.collectStrings(
				"Сохранение коллекции в файл: ",
				"Коллекция сохранена в файл!");

		Consumer<Scanner> method = scanner -> {
			Add3ExampleHumansToCollection();
			Save.run();
		};

		runTest(input, expected, method);
	}
}
