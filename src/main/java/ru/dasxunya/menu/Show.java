package ru.dasxunya.menu;

import ru.dasxunya.App;
import ru.dasxunya.HumanBeing;

import java.util.Scanner;

public class Show {
    public static void show(Scanner scanner) {
        for (HumanBeing humanBeing : App.humanBeings) {
            System.out.println(humanBeing);
        }

    }
}
