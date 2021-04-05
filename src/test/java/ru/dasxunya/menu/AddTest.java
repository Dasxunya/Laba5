package ru.dasxunya.menu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.dasxunya.App;
import ru.dasxunya.AppTest;
import ru.dasxunya.Utils;

import java.beans.Expression;
import java.util.Scanner;

public class AddTest {

    @Test
    void getParameterNameTest() {
        String input = Utils.collectStrings(
                "",
                "Дима");
        String expected = Utils.collectStrings(
                "Введите имя: ",
                "Введите значение для имени!",
                "Введите имя: ");

        Utils.runTest(input, expected, Add::getParameterName);
    }

    @Test
    void getParameterCoordinatesTest() {
        String input = Utils.collectStrings("123L", "34", "46L", "47");
        String expected = Utils.collectStrings(
                "Создание координат: ",
                "Введите x: ",
                "Некорректный аргумент для переменной х!",         //x > -146 и не может быть null, y <270
                "Введите x: ",
                "Введите y: ",
                "Некорректный аргумент для переменной y!",
                "Введите y: ");

        Utils.runTest(input, expected, Add::getParameterCoordinates);
    }

    @Test
    void getParameterRealHeroTest() {
        String input = Utils.collectStrings("ssjhfd", "true");
        String expected = Utils.collectStrings(
                "Является ли человек реальным: ",
                "Человеческое существо реально? ",
                "Некорректный аргумент для realHero (Необходимо: true или false)! ",
                "Человеческое существо реально? ");

        Utils.runTest(input, expected, Add::getParameterRealHero);
    }

    @Test
    void getParameterHasToothpickTest() {
        String input = Utils.collectStrings("shfshf", "false");
        String expected = Utils.collectStrings(
                "Имеется ли у существа зубочистка: ",
                "Человеческое существо с зубочисткой? ",
                "Некорректный аргумент для hasToothpick (Необходимо: true или false)! ",
                "Человеческое существо с зубочисткой? ");

        Utils.runTest(input, expected, Add::getParameterHasToothpick);
    }

    @Test
    void getParameterImpactSpeedTest() {
        String input = Utils.collectStrings("sdfhdsf", "-10", "11", "5");
        String expected = Utils.collectStrings(
                "Скорость удара существа: ",
                "Введите скорость удара: ",
                "Некорректный аргумент для переменной impactSpeed (Необходимо: [0;10])! ",
                "Введите скорость удара: ",
                "impactSpeed не может быть отрицательным!",
                "Введите скорость удара: ",
                "impactSpeed не может быть больше 10!",
                "Введите скорость удара: ");

        Utils.runTest(input, expected, Add::getParameterImpactSpeed);
    }

    @Test
    void getParameterSoundtrackNameTest() {
        String input = Utils.collectStrings("", "Soundtrack");
        String expected = Utils.collectStrings(
                "Саундтрек: ",
                "Введите имя саундтрека: ",
                "soundtrackName не может быть пустым!",
                "Введите имя саундтрека: ");

        Utils.runTest(input, expected, Add::getParameterSoundtrackName);
    }

    @Test
    void getParameterWeaponTypeTest() {
        String input = Utils.collectStrings("fhfss", "axe");
        String expected = Utils.collectStrings(
                "Тип оружия: ",
                "Введите тип оружия: ",
                "Поле не может быть null и должно соответствовать представленному набору(AXE, RIFLE, PISTOL, KNIFE, BAT)!",
                "Введите тип оружия: ");

        Utils.runTest(input, expected, Add::getParameterWeaponType);
    }

    @Test
    void getParameterMoodTest() {
        String input = Utils.collectStrings("", "SADNESS");
        String expected = Utils.collectStrings(
                "Введите настроение: ",
                "Поле не может быть null и должно соответствовать представленному набору(SADNESS, LONGING, CALM, RAGE)!",
                "Введите настроение: ");

        Utils.runTest(input, expected, Add::getParameterMood);
    }

    @Test
    void getParameterCarTest() {
        String input = Utils.collectStrings("", "hgjf", "cghv", "true");
        String expected = Utils.collectStrings(
                "Характеристики машины: ",
                "Введите название автомобиля: ",
                "Введите значение для названия автомобиля!",
                "Введите название автомобиля: ",
                "Машина хорошая?",
                "Некорректный аргумент для Cool (Необходимо: true или false)!",
                "Машина хорошая?");

        Utils.runTest(input, expected, Add::getParameterCar);
    }

}
