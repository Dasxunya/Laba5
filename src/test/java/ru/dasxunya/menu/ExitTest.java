package ru.dasxunya.menu;

import org.junit.jupiter.api.*;
import ru.dasxunya.utils.*;

import static ru.dasxunya.UtilsTest.*;
import static ru.dasxunya.utils.Utils.*;

public class ExitTest {
	@Test
	void MenuExitTest() {
		String input = Utils.collectStrings(EXIT);
		String expected = Utils.collectStrings("Завершение работы программы...");

		runTest(input, expected, main);

	}
}
