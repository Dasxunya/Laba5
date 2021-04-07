package ru.dasxunya.menu;

import ru.dasxunya.core.*;

import java.util.*;

import static ru.dasxunya.utils.Historian.*;
import static ru.dasxunya.utils.Searcher.*;

public class RemoveById {
	public static void run(Scanner scanner) {
		AddHistory("remove_by_id");

		System.out.println("Удаление элемента коллекции: ");

		Integer id = searchByID(scanner);
		if (id == null) return;

		App.humanBeings.removeIf((human -> human.getId() == id));
		System.out.println("Объект удален из коллекции!");
	}
}
