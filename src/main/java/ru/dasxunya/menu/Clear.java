package ru.dasxunya.menu;


import ru.dasxunya.core.*;

import java.util.*;

import static ru.dasxunya.utils.Historian.*;

/**
 * The type Clear.
 */
public class Clear {
    /**
     * Run.
     *
     * @param scanner the scanner
     */
    public static void run(Scanner scanner) {
		AddHistory("clear");

		App.humanBeings.clear();

		System.out.println("Коллекция очищена!");
	}
}

