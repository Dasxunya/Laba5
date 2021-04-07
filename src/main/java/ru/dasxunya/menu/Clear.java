package ru.dasxunya.menu;


import ru.dasxunya.core.*;

import java.util.*;

import static ru.dasxunya.utils.Historian.*;

public class Clear {
	public static void run(Scanner scanner) {
		AddHistory("clear");

		App.humanBeings.clear();

		System.out.println("Коллекция очищена!");
	}
}

