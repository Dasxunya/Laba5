package ru.dasxunya.menu;

import java.util.*;

import static ru.dasxunya.utils.Historian.*;

public class Exit {
	public static void run(Scanner scanner) {
		AddHistory("exit");

		System.out.println("Завершение работы программы...");
	}
}
