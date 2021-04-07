package ru.dasxunya.menu;

import ru.dasxunya.core.*;

import java.util.*;

import static ru.dasxunya.utils.Historian.*;

/**
 * The type History.
 */
public class History {
    /**
     * Run.
     *
     * @param scanner the scanner
     */
    public static void run(Scanner scanner) {
		AddHistory("history");
		System.out.println("Последние 11 команд: ");
		for (String text : App.history) {
			System.out.println(text);
		}
	}


}
