package ru.dasxunya.menu;

import java.util.*;

import static ru.dasxunya.utils.Historian.*;

/**
 * The type Exit.
 */
public class Exit {
    /**
     * Run.
     *
     * @param scanner the scanner
     */
    public static void run(Scanner scanner) {
		AddHistory("exit");

		System.out.println("Завершение работы программы...");
	}
}
