package ru.dasxunya.menu;

import org.junit.jupiter.api.*;
import ru.dasxunya.utils.*;

import java.util.*;
import java.util.function.*;

import static ru.dasxunya.UtilsTest.*;

public class UniqueWeaponTypeTest {
	@Test
	void MenuPrintUniqueWeaponTypeWithoutHumans() {
		String input = Utils.collectStrings("unique_weapon");
		String expected = Utils.collectStrings("Уникальные значения поля weaponType: ",
		                                       "Значения поля weaponType отсутствуют!");
		Consumer<Scanner> method = scanner -> {
			UniqueWeapon.run();
		};

		runTest(input, expected, method);
	}

	@Test
	void MenuPrintUniqueWeaponTypeWithHumans() {

		String input = Utils.collectStrings("unique_weapon");
		String expected = Utils.collectStrings("Уникальные значения поля weaponType: ",
		                                       "AXE",
		                                       "PISTOL");
		Consumer<Scanner> method = scanner -> {
			Add3ExampleHumansToCollection();
			UniqueWeapon.run();
		};

		runTest(input, expected, method);
	}
}
