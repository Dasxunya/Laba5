package ru.dasxunya.menu;


import ru.dasxunya.core.*;

import static ru.dasxunya.utils.Historian.*;

/**
 * The type Clear.
 */
public class Clear {
    /**
     * Run.
     *
	 */
    public static void run() {
		AddHistory("clear");

		App.humanBeings.clear();

		System.out.println("Коллекция очищена!");
	}
}

