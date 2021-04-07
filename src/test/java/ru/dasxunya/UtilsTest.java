package ru.dasxunya;

import org.junit.jupiter.api.*;
import ru.dasxunya.core.*;
import ru.dasxunya.utils.*;

import java.time.*;
import java.util.*;
import java.util.function.*;

public class UtilsTest {

	public static Integer id = 1;
	public static Coordinates coordinates = new Coordinates(100000L, 5);
	public static ZonedDateTime creationDate = ZonedDateTime.of(2021, 4, 5, 12, 0, 0, 0, ZoneId.of("Europe/Moscow"));
	public static WeaponType weaponType = WeaponType.AXE;
	public static Mood mood = Mood.CALM;
	public static Car car = new Car("Мой автомобиль.", true);
	public static HumanBeing humanBeingWithLowSpeed = new HumanBeing(5, "Дмитрий", coordinates, creationDate, false, false, 1D, "In Flames - Cloud Connected", WeaponType.PISTOL, mood, car);
	public static HumanBeing humanBeingWithNormalSpeed = new HumanBeing(id, "Алексей", coordinates, creationDate, false, false, 5D, "Bad Boys Blue - Kisses & Tears", weaponType, mood, car);
	public static HumanBeing humanBeingWithHighSpeed = new HumanBeing(10, "Андрей", coordinates, creationDate, false, false, 10D, "Кино - Хочу перемен", weaponType, mood, car);

	public static String stringHumanBeingWithLowSpeed =  "HumanBeing{id=5, name='Дмитрий', coordinates=Coordinates{x=100000, y=5}, creationDate=2021-04-05T12:00+03:00[Europe/Moscow], realHero=false, hasToothpick=false, impactSpeed=1.0, soundtrackName='In Flames - Cloud Connected', weaponType=PISTOL, mood=CALM, car=Car{name='Мой автомобиль.', cool=true}}";
	public static String stringHumanBeingWithNormalSpeed = "HumanBeing{id=1, name='Алексей', coordinates=Coordinates{x=100000, y=5}, creationDate=2021-04-05T12:00+03:00[Europe/Moscow], realHero=false, hasToothpick=false, impactSpeed=5.0, soundtrackName='Bad Boys Blue - Kisses & Tears', weaponType=AXE, mood=CALM, car=Car{name='Мой автомобиль.', cool=true}}";
	public static String stringHumanBeingWithHighSpeed =  "HumanBeing{id=10, name='Андрей', coordinates=Coordinates{x=100000, y=5}, creationDate=2021-04-05T12:00+03:00[Europe/Moscow], realHero=false, hasToothpick=false, impactSpeed=10.0, soundtrackName='Кино - Хочу перемен', weaponType=AXE, mood=CALM, car=Car{name='Мой автомобиль.', cool=true}}";
	public static Consumer<Scanner> main = (scanner) -> App.main(new String[0]);

	public static void AddExampleHumanToCollection() {
		App.humanBeings.add(humanBeingWithNormalSpeed);
	}

	public static void Add3ExampleHumansToCollection() {
		App.humanBeings.add(humanBeingWithLowSpeed);
		App.humanBeings.add(humanBeingWithNormalSpeed);
		App.humanBeings.add(humanBeingWithHighSpeed);
	}

	public static void runTest(String input, String expected, Consumer<Scanner> method) {
		ru.dasxunya.utils.Utils.setUpStreams();

		ru.dasxunya.utils.Utils.provideInput(input);

		method.accept(Utils.scanner);

		String actual = Utils.outputContent.toString();

		ru.dasxunya.utils.Utils.restoreStreams();

		App.humanBeings.clear();

		App.history.clear();

		Utils.SYSTEM_VARIABLE = "TEST_SCRIPT";

		Assertions.assertEquals(expected, actual);
	}

	public static String GetTestInputStringsFromAddWithLowSpeed() {
		return ru.dasxunya.utils.Utils.collectStringsWithoutEndLineSeparator("Дима", "34", "47", "true", "false", "1", "Soundtrack", "KNIFE", "SADNESS", "LADA", "true");
	}

	public static String GetTestInputStringsFromAddWithNormalSpeed() {
		return ru.dasxunya.utils.Utils.collectStringsWithoutEndLineSeparator("Дима", "34", "47", "true", "false", "5", "Soundtrack", "KNIFE", "SADNESS", "LADA", "true");
	}

	public static String GetTestInputStringsFromAddWithHighSpeed() {
		return ru.dasxunya.utils.Utils.collectStringsWithoutEndLineSeparator("Дима", "34", "47", "true", "false", "10", "Soundtrack", "KNIFE", "SADNESS", "LADA", "true");
	}

	public static String GetTestOutputStringsFromAdd() {
		return ru.dasxunya.utils.Utils.collectStringsWithoutEndLineSeparator("Введите имя: ",
		                                                                     "Создание координат: ",
		                                                                     "Введите x: ",
		                                                                     "Введите y: ",
		                                                                     "Является ли человек реальным: ",
		                                                                     "Человеческое существо реально?",
		                                                                     "Имеется ли у существа зубочистка: ",
		                                                                     "Человеческое существо с зубочисткой?",
		                                                                     "Скорость удара существа: ",
		                                                                     "Введите скорость удара: ",
		                                                                     "Саундтрек: ",
		                                                                     "Введите имя саундтрека: ",
		                                                                     "Тип оружия: ",
		                                                                     "Введите тип оружия: ",
		                                                                     "Возможные типы оружия: (AXE, RIFLE, PISTOL, KNIFE, BAT)",
		                                                                     "Введите настроение: ",
		                                                                     "Возможные типы настроения: (SADNESS, LONGING, CALM, RAGE)",
		                                                                     "Характеристики машины: ",
		                                                                     "Введите название автомобиля: ",
		                                                                     "Машина хорошая?"
		                                                                    );
	}

}
