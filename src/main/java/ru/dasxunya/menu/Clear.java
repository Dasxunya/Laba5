package ru.dasxunya.menu;

import ru.dasxunya.App;

import java.util.Scanner;

public class Clear {
    public static void clear(Scanner scanner) {
        System.out.println("Коллекция очищена!");

        App.humanBeings.clear();

    }
}

