package ru.dasxunya.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.dasxunya.App;
import ru.dasxunya.Utils;

import java.util.Scanner;
import java.util.function.Consumer;

public class ClearTest {
    @Test
    void getParameterWeaponTypeTest() {
        App.humanBeings.add(Utils.humanBeing);

        String input = Utils.collectStrings();
        String expected = Utils.collectStrings("Коллекция очищена!");

        Consumer<Scanner> method = scanner -> {
            Clear.clear(scanner);
            Assertions.assertEquals(0, App.humanBeings.size());
        };

        Utils.runTest(input, expected, method);


    }
}
