package ru.dasxunya.menu;

import ru.dasxunya.*;

import java.time.ZonedDateTime;
import java.util.Scanner;

public class Add {


    public static void add(Scanner scanner) {
        String command;
        System.out.println("Добавление элемента в коллекцию:");

        HumanBeing humanBeing = getParameterHumanBeing(scanner);
        App.humanBeings.add(humanBeing);
    }


    static HumanBeing getParameterHumanBeing(Scanner scanner) {
        Integer id = getParameterId();
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

        HumanBeing humanBeing = new HumanBeing(id, name, coordinates, creationDate, realHero, hasToothpick, impactSpeed, soundtrackName, weaponType, mood, car);
        return humanBeing;
    }

    private static Car getParameterCar(Scanner scanner) {
        System.out.println("Характеристики машины: ");
        String nameCar = getParameterNameCar(scanner);
        boolean cool = getParameterCool(scanner);
        Car car = new Car(nameCar, cool);
        return car;
    }

    private static boolean getParameterCool(Scanner scanner) {
        boolean cool;
        while (true) {
            System.out.println("Машина хорошая? ");
            String text = scanner.next();

            if (text.equals("true")) {
                cool = true;
                break;
            }
            if (text.equals("false")) {
                cool = false;
                break;
            }

            System.out.println("Некорректный аргумент для hasToothpick (Необходимо: true или false)! ");
        }
        return cool;
    }

    private static String getParameterNameCar(Scanner scanner) {
        String nameCar;
        while (true) {
            System.out.println("Введите название автомобиля: ");

            try {
                nameCar = scanner.nextLine().trim();
                if (nameCar == null) {
                    throw new NullPointerException("Название автомобиля не может быть null!");
                }
                if (nameCar.equals("")) {
                    throw new IllegalArgumentException("Введите значение для названия автомобиля!");
                }
                break;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        return nameCar;
    }

    private static Mood getParameterMood(Scanner scanner) {
        Mood mood;

        while (true) {
            System.out.println("Введите тип оружия: ");

            try {
                String text = scanner.nextLine();
                mood = Mood.valueOf(text.toUpperCase());
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println("Поле не может быть null и должно соответствовать представленному набору(SADNESS, LONGING, CALM, RAGE)!");
            }
        }
        return mood;
    }

    private static WeaponType getParameterWeaponType(Scanner scanner) {
        System.out.println("Тип оружия: ");
        WeaponType weaponType;

        while (true) {
            System.out.println("Введите тип оружия: ");

            try {
                String text = scanner.nextLine();
                weaponType = WeaponType.valueOf(text.toUpperCase());
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println("Поле не может быть null и должно соответствовать представленному набору(AXE, RIFLE, PISTOL, KNIFE, BAT)!");
            }
        }
        return weaponType;
    }

    private static String getParameterSoundtrackName(Scanner scanner) {
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

    private static Double getParameterImpactSpeed(Scanner scanner) {
        System.out.println("Скорость удара существа: ");
        Double impactSpeed;
        while (true) {
            System.out.println("Введите скорость удара: ");

            try {
                impactSpeed = Double.parseDouble(scanner.next());
                if (impactSpeed < 0) {
                    throw new IllegalArgumentException("impactSpeed не может быть отрицательным!");         // не реагирует на ввод:/
                }
                if (impactSpeed > 10) {
                    throw new IllegalArgumentException("impactSpeed не может быть больше 10!");
                }
                break;
            } catch (NumberFormatException exception) {
                System.out.println("Некорректный аргумент для переменной impactSpeed (Необходимо: [0;10])! ");
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return impactSpeed;
    }

    private static Boolean getParameterHasToothpick(Scanner scanner) {
        System.out.println("Имеется ли у существа зубочистка: ");
        String command;
        Boolean hasToothpick;
        while (true) {
            System.out.println("Человеческое существо с зубочисткой? ");
            command = scanner.next();
            if (command.equals("true")) {
                hasToothpick = true;
                break;
            }
            if (command.equals("false")) {
                hasToothpick = false;
                break;
            }
            System.out.println("Некорректный аргумент для hasToothpick (Необходимо: true или false)! ");
        }
        return hasToothpick;
    }

    private static Boolean getParameterRealHero(Scanner scanner) {
        String command;
        System.out.println("Является ли человек реальным: ");

        Boolean realHero;
        while (true) {
            System.out.println("Человеческое существо реально? ");
            command = scanner.next();
            if (command.equals("true")) {
                realHero = true;
                break;
            }
            if (command.equals("false")) {
                realHero = false;
                break;
            }
            System.out.println("Некорректный аргумент для realHero (Необходимо: true или false)! ");
        }
        return realHero;
    }

    private static Coordinates getParameterCoordinates(Scanner scanner) {
        System.out.println("Создание координат: ");

        Long x = getParameterX(scanner);
        int y = getParameterY(scanner);

        Coordinates coordinates = new Coordinates(x, y);
        return coordinates;
    }

    private static int getParameterY(Scanner scanner) {
        int y;

        while (true) {
            System.out.println("Введите y: ");

            try {
                y = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException exception) {
                System.out.println("Некорректный аргумент для переменной y!");
            }
        }
        return y;
    }

    private static Long getParameterX(Scanner scanner) {
        Long x = null;
        while (true) {
            System.out.println("Введите x: ");

            try {
                x = Long.valueOf(scanner.next());
                break;
            } catch (NumberFormatException exception) {
                System.out.println("Некорректный аргумент для переменной х!");
            }
        }
        return x;
    }

    private static String getParameterName(Scanner scanner) {
        String name;

        while (true) {
            System.out.println("Введите имя: ");

            try {
                name = scanner.nextLine().trim();
                if (name == null) {
                    throw new NullPointerException("Имя не может быть null!");
                }
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


    private static Integer getParameterId() {
        // TODO: генерируем идентификатор.
        Integer id = 10;

        if (id == null) {
            throw new NullPointerException("id оказался null!");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("id не может быть отрицательным или равным нулю!");
        }
        return id;
    }
}
