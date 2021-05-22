package ru.dasxunya.menu;

import org.junit.jupiter.api.*;
import ru.dasxunya.core.*;
import ru.dasxunya.utils.*;

import java.util.*;
import java.util.function.*;

import static ru.dasxunya.UtilsTest.*;

public class ClearTest {
	@Test
	void ClearTest() {
		String input = Utils.collectStrings();
		String expected = Utils.collectStrings("Коллекция очищена!");

		Consumer<Scanner> method = scanner -> {
			AddExampleHumanToCollection();
			Clear.run();
			Assertions.assertEquals(0, App.humanBeings.size());
		};

		runTest(input, expected, method);
	}
}
