package ru.dasxunya.menu;

import org.junit.jupiter.api.*;
import ru.dasxunya.utils.*;

import java.util.*;
import java.util.function.*;

import static ru.dasxunya.UtilsTest.*;
import static ru.dasxunya.utils.Utils.*;

public class AddTest {

	@Test
	void getParameterNameTest() {
		String input = Utils.collectStrings(
				"",
				"Дима"
		                                   );
		String expected = Utils.collectStrings(
				"Введите имя: ",
				"Введите значение для имени!",
				"Введите имя: "
		                                      );

		runTest(input, expected, Add::getParameterName);
	}

	@Test
	void getParameterCoordinatesTest() {
		String input = Utils.collectStrings("123L", "-200", "34", "46L", "271", "47");
		String expected = Utils.collectStrings(
				"Создание координат: ",
				"Введите x: ",
				"Некорректный аргумент для переменной х!",
				"Введите x: ",
				"X должен быть больше -146!",
				"Введите x: ",
				"Введите y: ",
				"Некорректный аргумент для переменной y!",
				"Введите y: ",
				"Y должен быть меньше 270!",
				"Введите y: "
				);

		runTest(input, expected, Add::getParameterCoordinates);
	}

	@Test
	void getParameterRealHeroTest() {
		String input = Utils.collectStrings("ssjhfd", "true");
		String expected = Utils.collectStrings(
				"Является ли человек реальным: ",
				"Человеческое существо реально?",
				"Некорректный аргумент для realHero (Необходимо: true или false)!",
				"Человеческое существо реально?"
		                                      );

		runTest(input, expected, Add::getParameterRealHero);
	}

	@Test
	void getParameterHasToothpickTest() {
		String input = Utils.collectStrings("shfshf", "false");
		String expected = Utils.collectStrings(
				"Имеется ли у существа зубочистка: ",
				"Человеческое существо с зубочисткой?",
				"Некорректный аргумент для hasToothpick (Необходимо: true или false)!",
				"Человеческое существо с зубочисткой?"
		                                      );

		runTest(input, expected, Add::getParameterHasToothpick);
	}

	@Test
	void getParameterImpactSpeedTest() {
		String input = Utils.collectStrings("sdfhdsf", "-10", "11", "5");
		String expected = Utils.collectStrings(
				"Скорость удара существа: ",
				"Введите скорость удара: ",
				"Некорректный аргумент для переменной impactSpeed (Необходимо: [0;10])!",
				"Введите скорость удара: ",
				"impactSpeed не может быть отрицательным!",
				"Введите скорость удара: ",
				"impactSpeed не может быть больше 10!",
				"Введите скорость удара: "
		                                      );

		runTest(input, expected, Add::getParameterImpactSpeed);
	}

	@Test
	void getParameterImpactSpeedNullTest() {
		String input = Utils.collectStrings("   ");
		String expected = Utils.collectStrings(
				"Скорость удара существа: ",
				"Введите скорость удара: "
		                                      );

		runTest(input, expected, Add::getParameterImpactSpeed);
	}

	@Test
	void getParameterSoundtrackNameTest() {
		String input = Utils.collectStrings("", "Soundtrack");
		String expected = Utils.collectStrings(
				"Саундтрек: ",
				"Введите имя саундтрека: ",
				"soundtrackName не может быть пустым!",
				"Введите имя саундтрека: "
		                                      );

		runTest(input, expected, Add::getParameterSoundtrackName);
	}

	@Test
	void getParameterWeaponTypeTest() {
		String input = Utils.collectStrings("fhfss", "axe");
		String expected = Utils.collectStrings(
				"Тип оружия: ",
				"Введите тип оружия: ",
				"Возможные типы оружия: (AXE, RIFLE, PISTOL, KNIFE, BAT)",
				"Некорректный аргумент! Он должен соответствовать представленному набору (AXE, RIFLE, PISTOL, KNIFE, BAT)!",
				"Введите тип оружия: ",
				"Возможные типы оружия: (AXE, RIFLE, PISTOL, KNIFE, BAT)"
		                                      );

		runTest(input, expected, Add::getParameterWeaponType);
	}

	@Test
	void getParameterWeaponTypeNullTest() {
		String input = Utils.collectStrings("   ");
		String expected = Utils.collectStrings(
				"Тип оружия: ",
				"Введите тип оружия: ",
				"Возможные типы оружия: (AXE, RIFLE, PISTOL, KNIFE, BAT)"
		                                      );

		runTest(input, expected, Add::getParameterWeaponType);
	}

	@Test
	void getParameterMoodTest() {
		String input = Utils.collectStrings("asdgasdgs", "SADNESS");
		String expected = Utils.collectStrings(
				"Введите настроение: ",
				"Возможные типы настроения: (SADNESS, LONGING, CALM, RAGE)",
				"Некорректный аргумент! Он должен соответствовать представленному набору (SADNESS, LONGING, CALM, RAGE)!",
				"Введите настроение: ",
				"Возможные типы настроения: (SADNESS, LONGING, CALM, RAGE)"
		                                      );

		runTest(input, expected, Add::getParameterMood);
	}

	@Test
	void getParameterMoodNullTest() {
		String input = Utils.collectStrings("   ");
		String expected = Utils.collectStrings(
				"Введите настроение: ",
				"Возможные типы настроения: (SADNESS, LONGING, CALM, RAGE)"
		                                      );

		runTest(input, expected, Add::getParameterMood);
	}
	@Test
	void getParameterCarTest() {
		String input = Utils.collectStrings("", "cghv", "true");
		String expected = Utils.collectStrings(
				"Характеристики машины: ",
				"Введите название автомобиля: ",
				"Машина хорошая?",
				"Некорректный аргумент для Cool (Необходимо: true или false)!",
				"Машина хорошая?"
		                                      );

		runTest(input, expected, Add::getParameterCar);
	}

	@Test
	void MenuAddTest() {
		String input = Utils.collectStrings(GetTestInputStringsFromAddWithNormalSpeed(), EXIT);
		String expected = Utils.collectStrings("Добавление элемента в коллекцию: ",
		                                       GetTestOutputStringsFromAdd());

		Consumer<Scanner> method = scanner -> {
			Add.run(scanner);
		};

		runTest(input, expected, method);
	}
}
