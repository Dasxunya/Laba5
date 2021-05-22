package ru.dasxunya.menu;

import ru.dasxunya.core.*;

import static ru.dasxunya.utils.Historian.*;

/**
 * The type History.
 */
public class History {
    /**
     * Run.
     *
	 */
    public static void run() {
		AddHistory("history");
		System.out.println("Последние 11 команд: ");
		for (String text : App.history) {
			System.out.println(text);
		}
	}


}
