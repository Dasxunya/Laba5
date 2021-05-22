package ru.dasxunya.menu;

import static ru.dasxunya.utils.Historian.*;

/**
 * The type Exit.
 */
public class Exit {
    /**
     * Run.
     *
	 */
    public static void run() {
		AddHistory("exit");

		System.out.println("Завершение работы программы...");
	}
}
