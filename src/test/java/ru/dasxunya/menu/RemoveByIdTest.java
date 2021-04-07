package ru.dasxunya.menu;

import org.junit.jupiter.api.*;
import ru.dasxunya.core.*;
import ru.dasxunya.utils.*;

import java.util.*;
import java.util.function.*;

import static ru.dasxunya.UtilsTest.*;

public class RemoveByIdTest {
	@Test
	void RemoveByIdWithHumans() {

		String input = Utils.collectStrings(id.toString());
		String expected = Utils.collectStrings("Удаление элемента коллекции: ",
		                                       "Введите идентификатор: ",
		                                       "Объект удален из коллекции!"
		                                      );

		Consumer<Scanner> method = scanner -> {
			AddExampleHumanToCollection();
			RemoveById.run(scanner);
			Assertions.assertEquals(0, App.humanBeings.size());
		};

		runTest(input, expected, method);
	}


}
