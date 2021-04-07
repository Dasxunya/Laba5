package ru.dasxunya.menu;

import ru.dasxunya.core.*;

import javax.sound.midi.*;
import java.time.*;
import java.util.*;

import static ru.dasxunya.utils.Historian.*;

public class Add {


	public static void run(Scanner scanner) {
		AddHistory("add");
		System.out.println("Добавление элемента в коллекцию: ");

		HumanBeing humanBeing = getParameterHumanBeing(scanner, getParameterId());
		App.humanBeings.add(humanBeing);
	}


	public static HumanBeing getParameterHumanBeing(Scanner scanner, Integer ID) {
		Integer id = ID;
		String name = getParameterName(scanner);
		Coordinates coordinates = getParameterCoordinates(scanner);
		ZonedDateTime creationDate = ZonedDateTime.now();
		Boolean realHero = getParameterRealHero(scanner);
		Boolean hasToothpick = getParameterHasToothpick(scanner);
		Double impactSpeed = getParameterImpactSpeed(scanner);
		String soundtrackName = getParameterSoundtrackName(scanner);
		WeaponType weaponType = getParameterWeaponType(scanner);
		Mood mood = getParameterMood(scanner);
		Car car = getParameterCar(scanner);

		return new HumanBeing(id, name, coordinates, creationDate, realHero, hasToothpick, impactSpeed, soundtrackName, weaponType, mood, car);
	}

	public static Car getParameterCar(Scanner scanner) {
		System.out.println("Характеристики машины: ");
		String nameCar = getParameterNameCar(scanner);
		boolean cool = getParameterCool(scanner);
		Car car = new Car(nameCar, cool);
		return car;
	}

	public static boolean getParameterCool(Scanner scanner) {
		boolean cool;
		while (true) {
			System.out.println("Машина хорошая?");
			String text = scanner.nextLine();

			if (text.equals("true")) {
				cool = true;
				break;
			}
			if (text.equals("false")) {
				cool = false;
				break;
			}

			System.out.println("Некорректный аргумент для Cool (Необходимо: true или false)!");
		}
		return cool;
	}

	public static String getParameterNameCar(Scanner scanner) {
		String nameCar = null;
		while (true) {
			System.out.println("Введите название автомобиля: ");

			try {
				nameCar = scanner.nextLine().trim();
				if (nameCar.equals("")) {
					nameCar = null;
					break;
				}
				break;
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
		return nameCar;
	}

	public static Mood getParameterMood(Scanner scanner) {
		Mood mood = null;

		while (true) {
			System.out.println("Введите настроение: ");
			System.out.println("Возможные типы настроения: (SADNESS, LONGING, CALM, RAGE)");
			try {
				String text = scanner.nextLine().trim();
				if (!text.equals("")) {
					mood = Mood.valueOf(text.toUpperCase());
				}
				break;


			} catch (IllegalArgumentException exception) {
				System.out.println("Некорректный аргумент! Он должен соответствовать представленному набору (SADNESS, LONGING, CALM, RAGE)!");
			}
		}
		return mood;
	}

	public static WeaponType getParameterWeaponType(Scanner scanner) {
		System.out.println("Тип оружия: ");
		WeaponType weaponType = null;

		while (true) {
			System.out.println("Введите тип оружия: ");
			System.out.println("Возможные типы оружия: (AXE, RIFLE, PISTOL, KNIFE, BAT)");
			try {
				String text = scanner.nextLine().trim();
				if (!text.equals("")) {
					weaponType = WeaponType.valueOf(text.toUpperCase());
				}
				break;

			} catch (IllegalArgumentException exception) {
				System.out.println("Некорректный аргумент! Он должен соответствовать представленному набору (AXE, RIFLE, PISTOL, KNIFE, BAT)!");
			}
		}
		return weaponType;
	}

	public static String getParameterSoundtrackName(Scanner scanner) {
		System.out.println("Саундтрек: ");
		String soundtrackName;
		while (true) {
			System.out.println("Введите имя саундтрека: ");

			try {
				soundtrackName = scanner.nextLine().trim();
				if (soundtrackName == null) {
					throw new NullPointerException("soundtrackName не может быть null!");
				}
				if (soundtrackName.equals("")) {
					throw new IllegalArgumentException("soundtrackName не может быть пустым!");
				}
				break;
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
		return soundtrackName;
	}

	public static Double getParameterImpactSpeed(Scanner scanner) {
		System.out.println("Скорость удара существа: ");
		Double impactSpeed = null;
		while (true) {
			System.out.println("Введите скорость удара: ");

			try {
				String text = scanner.nextLine().trim();
				if (text.equals(""))
				{
					impactSpeed = null;
					break;
				}

				impactSpeed = Double.parseDouble(text);
				if (impactSpeed < 0) {
					throw new IllegalArgumentException("impactSpeed не может быть отрицательным!");
				}
				if (impactSpeed > 10) {
					throw new IllegalArgumentException("impactSpeed не может быть больше 10!");
				}
				break;
			} catch (NumberFormatException exception) {
				System.out.println("Некорректный аргумент для переменной impactSpeed (Необходимо: [0;10])!");
			} catch (IllegalArgumentException exception) {
				System.out.println(exception.getMessage());
			}
		}
		return impactSpeed;
	}

	public static Boolean getParameterHasToothpick(Scanner scanner) {
		System.out.println("Имеется ли у существа зубочистка: ");
		String command;
		Boolean hasToothpick;
		while (true) {
			System.out.println("Человеческое существо с зубочисткой?");
			command = scanner.nextLine();
			if (command.equals("true")) {
				hasToothpick = true;
				break;
			}
			if (command.equals("false")) {
				hasToothpick = false;
				break;
			}
			System.out.println("Некорректный аргумент для hasToothpick (Необходимо: true или false)!");
		}
		return hasToothpick;
	}

	public static Boolean getParameterRealHero(Scanner scanner) {
		String command;
		System.out.println("Является ли человек реальным: ");

		Boolean realHero;
		while (true) {
			System.out.println("Человеческое существо реально?");
			command = scanner.nextLine();
			if (command.equals("true")) {
				realHero = true;
				break;
			}
			if (command.equals("false")) {
				realHero = false;
				break;
			}
			System.out.println("Некорректный аргумент для realHero (Необходимо: true или false)!");
		}
		return realHero;
	}

	public static Coordinates getParameterCoordinates(Scanner scanner) {
		System.out.println("Создание координат: ");

		Long x = getParameterX(scanner);
		int y = getParameterY(scanner);

		Coordinates coordinates = new Coordinates(x, y);
		return coordinates;
	}

	public static int getParameterY(Scanner scanner) {
		int y;

		while (true) {
			System.out.println("Введите y: ");

			try {
				y = Integer.parseInt(scanner.nextLine());
				if (y > 270)
				{
					System.out.println("Y должен быть меньше 270!");
					continue;
				}
				break;
			} catch (NumberFormatException exception) {
				System.out.println("Некорректный аргумент для переменной y!");
			}
		}
		return y;
	}

	public static Long getParameterX(Scanner scanner) {
		Long x = null;
		while (true) {
			System.out.println("Введите x: ");

			try {
				x = Long.valueOf(scanner.nextLine().trim());
				if (x <= -146)
				{
					System.out.println("X должен быть больше -146!");
					continue;
				}
				break;
			} catch (NumberFormatException exception) {
				System.out.println("Некорректный аргумент для переменной х!");
			}
		}
		return x;
	}

	public static String getParameterName(Scanner scanner) {
		String name;

		while (true) {
			System.out.println("Введите имя: ");

			try {
				name = scanner.nextLine().trim();
				if (name.equals("")) {
					throw new IllegalArgumentException("Введите значение для имени!");
				}
				break;
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
		return name;
	}


	public static Integer  getParameterId() {
		HumanBeing humanBeingWithMaxID = App.humanBeings.stream().max(Comparator.comparing(human -> human.getId())).orElse(null);

		Integer id;
		if (humanBeingWithMaxID == null)
		{
			id = 1;
		}
		else {
			id = humanBeingWithMaxID.getId() + 1;
		}

		if (id <= 0) {
			throw new IllegalArgumentException("id не может быть отрицательным или равным нулю!");
		}
		return id;
	}
}
