package ru.dasxunya.menu;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.*;
import org.junit.jupiter.api.*;
import ru.dasxunya.core.*;
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
			Save.run(scanner);
		};

		runTest(input, expected, method);
	}
}
