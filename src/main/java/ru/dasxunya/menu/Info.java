package ru.dasxunya.menu;

import ru.dasxunya.core.*;

import java.util.*;

import static ru.dasxunya.utils.Historian.*;

/**
 * The type Info.
 */
public class Info {
    /**
     * Run.
     *
     * @param scanner the scanner
     */
    public static void run(Scanner scanner) {
		AddHistory("info");

		System.out.println("Информация о коллекции HumanBeings: ");

		if (App.humanBeings.isEmpty())
		{
			System.out.println("Коллекция пуста!");
		}
		else {
			System.out.println("Количество: " + App.humanBeings.size());
			App.humanBeings.forEach(System.out::println);
		}
	}
}
