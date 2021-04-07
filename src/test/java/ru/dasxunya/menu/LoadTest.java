package ru.dasxunya.menu;

import org.junit.jupiter.api.*;
import ru.dasxunya.core.*;
import ru.dasxunya.utils.*;

import java.util.*;
import java.util.function.*;

import static ru.dasxunya.UtilsTest.*;
import static ru.dasxunya.utils.Utils.*;

public class LoadTest {
	@Test
	void Loading() {
		String input = "";
		String expected = "";

		Consumer<Scanner> method = scanner -> {
			Load.run(scanner);
			Assertions.assertEquals(3, App.humanBeings.size());
		};

		runTest(input, expected, method);
	}
}
