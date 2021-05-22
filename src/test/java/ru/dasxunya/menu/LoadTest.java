package ru.dasxunya.menu;

import org.junit.jupiter.api.*;
import ru.dasxunya.core.*;

import java.util.*;
import java.util.function.*;

import static ru.dasxunya.UtilsTest.*;

public class LoadTest {
	@Test
	void Loading() {
		String input = "";
		String expected = "";

		Consumer<Scanner> method = scanner -> {
			Load.run();
			Assertions.assertEquals(3, App.humanBeings.size());
		};

		runTest(input, expected, method);
	}
}
