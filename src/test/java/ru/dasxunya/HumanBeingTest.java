package ru.dasxunya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.dasxunya.Utils.*;

public class HumanBeingTest {

    @Test
    void CreateHumanBeingWithParameters() {
        HumanBeing humanBeing = new HumanBeing(id, "Имя", coordinates, creationDate, false, false, 9D, "Soundtrack", weaponType, mood, car);

        Assertions.assertThrows(NullPointerException.class, () -> new HumanBeing(null, "Имя", coordinates, creationDate, false, false, 9D, "Soundtrack", weaponType, mood, car), "id оказался null!");
        Assertions.assertThrows(IllegalArgumentException.class, () -> new HumanBeing(-1, "Имя", coordinates, creationDate, false, false, 9D, "Soundtrack", weaponType, mood, car), "id не может быть отрицательным или равным нулю!");
        Assertions.assertThrows(IllegalArgumentException.class, () -> new HumanBeing(0, "Имя", coordinates, creationDate, false, false, 9D, "Soundtrack", weaponType, mood, car), "id не может быть отрицательным или равным нулю!");
        Assertions.assertThrows(NullPointerException.class, () -> new HumanBeing(id, null, coordinates, creationDate, false, false, 9D, "Soundtrack", weaponType, mood, car), "name не может быть null!");
        Assertions.assertThrows(IllegalArgumentException.class, () -> new HumanBeing(id, "", coordinates, creationDate, false, false, 9D, "Soundtrack", weaponType, mood, car), "Введите значение для name!");
        Assertions.assertThrows(NullPointerException.class, () -> new HumanBeing(id, "Имя", null, creationDate, false, false, 9D, "Soundtrack", weaponType, mood, car), "coordinates не может быть null!");
        Assertions.assertThrows(NullPointerException.class, () -> new HumanBeing(id, "Имя", coordinates, null, false, false, 9D, "Soundtrack", weaponType, mood, car), "creationDate не может быть null!");
        Assertions.assertThrows(IllegalArgumentException.class, () -> new HumanBeing(id, "Имя", coordinates, creationDate, false, false, 11D, "Soundtrack", weaponType, mood, car), "impactSpeed не может быть больше 10!");
        Assertions.assertThrows(IllegalArgumentException.class, () -> new HumanBeing(id, "Имя", coordinates, creationDate, false, false, -10D, "Soundtrack", weaponType, mood, car), "impactSpeed не может быть отрицательным!");
        Assertions.assertThrows(NullPointerException.class, () -> new HumanBeing(id, "Имя", coordinates, creationDate, false, false, 9D, null, weaponType, mood, car), "soundtrackName не может быть null!");
        Assertions.assertThrows(NullPointerException.class, () -> new HumanBeing(id, "Имя", coordinates, creationDate, false, false, 9D, "Soundtrack", null, mood, car), "weaponType не может быть null!");

        App.humanBeings.add(humanBeing);
        launchApplication(
                collectStrings("show", EXIT),
                collectStrings(
                        "Элементы коллекции:",
                        "HumanBeing{id=1, name='Имя', coordinates=Coordinates{x=100000, y=5}, creationDate=2021-04-05T12:00+03:00[Europe/Moscow], realHero=false, hasToothpick=false, impactSpeed=9.0, soundtrackName='Soundtrack', weaponType=WeaponType{}, mood=Mood{}, car=Car{name='Мой автомобиль.', cool=true}}")
        );
    }
}
