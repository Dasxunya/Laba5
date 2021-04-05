package ru.dasxunya;

import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;
import java.util.function.Consumer;

public class Utils {
    public static final PrintStream originalOutput = System.out;
    public static final InputStream originalInput = System.in;
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String EXIT = "exit";
    public static ByteArrayOutputStream outputContent;
    public static ByteArrayInputStream inputContent;
    public static Scanner scanner = new Scanner(System.in);
    public static Integer id = 1;
    public static Coordinates coordinates = new Coordinates(100000L, 5);
    public static ZonedDateTime creationDate = ZonedDateTime.of(2021,4, 5, 12, 0, 0, 0, ZoneId.of("Europe/Moscow"));
    public static WeaponType weaponType = WeaponType.AXE;
    public static Mood mood = Mood.CALM;
    public static Car car = new Car("Мой автомобиль.", true);
    public static HumanBeing humanBeing = new HumanBeing(id, "Имя", coordinates, creationDate, false, false, 9D, "Soundtrack", weaponType, mood, car);

    public static void setUpStreams() {
        outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
    }

    public static void provideInput(String data) {
        inputContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputContent);
        scanner = new Scanner(System.in);
    }

    public static void restoreStreams() {
        System.setOut(originalOutput);
        System.setIn(originalInput);
    }

    public static String collectStrings(String... cases) {
        return String.join(LINE_SEPARATOR, cases).concat(LINE_SEPARATOR);
    }

    public static void launchApplication(String input, String expected)
    {
        Consumer<Scanner> method = (scanner) -> App.main(new String[0]);
        runTest(input, expected, method);
    }

    public static void runTest(String input, String expected, Consumer<Scanner> method) {
        Utils.setUpStreams();

        Utils.provideInput(input);

        method.accept(Utils.scanner);

        String actual = Utils.outputContent.toString();

        Utils.restoreStreams();

        App.humanBeings.clear();

        Assertions.assertEquals(expected, actual);
    }



}
