package ru.dasxunya.menu;

import ru.dasxunya.core.*;

import java.util.*;

import static ru.dasxunya.utils.Historian.*;

/**
 * The type Show.
 */
public class Show {
    /**
     * Run.
     *
     * @param scanner the scanner
     */
    public static void run(Scanner scanner) {
		AddHistory("show");

		System.out.println("Элементы коллекции: ");

		if (App.humanBeings.isEmpty())
		{
			System.out.println("Коллекция пуста!");
		}
		else {
			for (HumanBeing humanBeing : App.humanBeings) {
				System.out.println(humanBeing);
			}
		}


	}
}
