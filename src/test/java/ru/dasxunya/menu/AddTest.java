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

    @BeforeEach
    void setUp() {
        Utils.setUpStreams();
    }

    @AfterEach
    void tearDown() {
        Utils.restoreStreams();
    }

    @Test
    void getParameterNameTest() {
        String input = Utils.collectStrings(
                "",
                "Дима");
        String expected = Utils.collectStrings(
                "Введите имя: ",
                "Введите значение для имени!",
                "Введите имя: ");

        Utils.provideInput(input);

        Add.getParameterName(Utils.scanner);

        String actual = Utils.outputContent.toString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getParameterCoordinatesTest() {
        String input = Utils.collectStrings(
                "",
                "Дима");
        String expected = Utils.collectStrings(
                "Введите имя: ",
                "Введите значение для имени!",
                "Введите имя: ");

        Utils.provideInput(input);

        Add.getParameterCoordinates(Utils.scanner);

        String actual = Utils.outputContent.toString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getParameterRealHeroTest() {
    }

    @Test
    void getParameterHasToothpickTest() {
    }

    @Test
    void getParameterImpactSpeedTest() {
    }

    @Test
    void getParameterSoundtrackNameTest() {
    }

    @Test
    void getParameterMoodTest() {
    }

    @Test
    void getParameterCarTest() {
    }

}
