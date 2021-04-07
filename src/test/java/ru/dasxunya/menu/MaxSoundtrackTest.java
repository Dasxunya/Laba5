package ru.dasxunya.menu;

import org.junit.jupiter.api.*;
import ru.dasxunya.utils.*;

import java.util.*;
import java.util.function.*;

import static ru.dasxunya.UtilsTest.*;

public class MaxSoundtrackTest {
	@Test
	void MenuMaxSoundtrackNameWithoutHumansTest() {
		String input = Utils.collectStrings("max_soundtrack");
		String expected = Utils.collectStrings("SoundtrackName является максимальным: ",
		                                       "Такой SoundtrackName отсутствует!");

		Consumer<Scanner> method = scanner -> {
			MaxSoundtrack.run(scanner);
		};

		runTest(input, expected, method);
	}

	@Test

	void MenuMaxSoundtrackNameWithHumansTest() {
		String input = Utils.collectStrings("max_soundtrack");
		String expected = Utils.collectStrings("SoundtrackName является максимальным: ",
		                                       stringHumanBeingWithHighSpeed);

		Consumer<Scanner> method = scanner -> {
			Add3ExampleHumansToCollection();
			MaxSoundtrack.run(scanner);
		};

		runTest(input, expected, method);
	}
}
