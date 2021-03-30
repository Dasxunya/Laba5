package ru.dasxunya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.Date;

public class HumanBeingTest {

    Coordinates coordinates = new Coordinates(100000L, 5);
    ZonedDateTime creationDate = ZonedDateTime.now();
    WeaponType weaponType = WeaponType.AXE;
    Mood mood = Mood.CALM;
    Car car = new Car("Мой автомобиль.", true);

    @Test
    void CreateHumanBeingWithParameters() {
        HumanBeing humanBeing = new HumanBeing(1233, "Имя", coordinates, creationDate, false, false, 9D, "Soundtrack", weaponType, mood, car);

        Assertions.assertThrows(NullPointerException.class, () -> new HumanBeing(null, "Имя", coordinates, creationDate, false, false, 9D, "Soundtrack", weaponType, mood, car), "id оказался null!");
        Assertions.assertThrows(IllegalArgumentException.class, () -> new HumanBeing(-1, "Имя", coordinates, creationDate, false, false, 9D, "Soundtrack", weaponType, mood, car), "id не может быть отрицательным или равным нулю!");
        Assertions.assertThrows(IllegalArgumentException.class, () -> new HumanBeing(0, "Имя", coordinates, creationDate, false, false, 9D, "Soundtrack", weaponType, mood, car), "id не может быть отрицательным или равным нулю!");
        Assertions.assertThrows(NullPointerException.class, () -> new HumanBeing(1233, null, coordinates, creationDate, false, false, 9D, "Soundtrack", weaponType, mood, car), "name не может быть null!");
        Assertions.assertThrows(IllegalArgumentException.class, () -> new HumanBeing(1233, "", coordinates, creationDate, false, false, 9D, "Soundtrack", weaponType, mood, car), "Введите значение для name!");
        Assertions.assertThrows(NullPointerException.class, () -> new HumanBeing(1233, "Имя", null, creationDate, false, false, 9D, "Soundtrack", weaponType, mood, car), "coordinates не может быть null!");
        Assertions.assertThrows(NullPointerException.class, () -> new HumanBeing(1233, "Имя", coordinates, null, false, false, 9D, "Soundtrack", weaponType, mood, car), "creationDate не может быть null!");
        Assertions.assertThrows(IllegalArgumentException.class, () -> new HumanBeing(1233, "Имя", coordinates, creationDate, false, false, 11D, "Soundtrack", weaponType, mood, car), "impactSpeed не может быть больше 10!");
        Assertions.assertThrows(IllegalArgumentException.class, () -> new HumanBeing(1233, "Имя", coordinates, creationDate, false, false, -10D, "Soundtrack", weaponType, mood, car), "impactSpeed не может быть отрицательным!");
        Assertions.assertThrows(NullPointerException.class, () -> new HumanBeing(1233, "Имя", coordinates, creationDate, false, false, 9D, null, weaponType, mood, car), "soundtrackName не может быть null!");
        Assertions.assertThrows(NullPointerException.class, () -> new HumanBeing(1233, "Имя", coordinates, creationDate, false, false, 9D, "Soundtrack", null, mood, car), "weaponType не может быть null!");

    }
}
