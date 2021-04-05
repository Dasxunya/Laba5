package ru.dasxunya.menu;

import org.junit.jupiter.api.Test;
import ru.dasxunya.App;
import ru.dasxunya.Utils;

public class UpdateTest {
    @Test
    void MenuUpdateByIdWithoutHumans() {
        String input = Utils.collectStrings(
                "update",
                Utils.id.toString());

        String expected = Utils.collectStrings(
                "В коллекции нет объектов! Обновление по идентификатору невозможно!"
        );

        Utils.runTest(input, expected, Update::update);
    }

    @Test
    void MenuUpdateByIdWithHumans() {
        App.humanBeings.add(Utils.humanBeing);

        String input = Utils.collectStrings(
                "2",
                "",
                "-10",
                Utils.id.toString(),
                "Михаил", "34", "47", "true", "false", "5", "Soundtrack", "KNIFE", "SADNESS", "LADA", "true",
                Utils.EXIT
        );

        String expected = Utils.collectStrings(
                "Введите идентификатор:",
                "Такого идентификатора не существует!",
                "Введите идентификатор:",
                "Некорректный аргумент для переменной id!",
                "Введите идентификатор:",
                "id не может быть отрицательным!",
                "Введите идентификатор:",
                "Обновление элемента в коллекции: ",
                "Введите имя: ",
                "Создание координат: ",
                "Введите x: ",
                "Введите y: ",
                "Является ли человек реальным: ",
                "Человеческое существо реально? ",
                "Имеется ли у существа зубочистка: ",
                "Человеческое существо с зубочисткой? ",
                "Скорость удара существа: ",
                "Введите скорость удара: ",
                "Саундтрек: ",
                "Введите имя саундтрека: ",
                "Тип оружия: ",
                "Введите тип оружия: ",
                "Введите настроение: ",
                "Характеристики машины: ",
                "Введите название автомобиля: ",
                "Машина хорошая?"
        );

        Utils.runTest(input, expected, Update::update);
    }
}
