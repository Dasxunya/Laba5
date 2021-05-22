package ru.dasxunya.menu;

import ru.dasxunya.core.*;

import java.util.*;

import static ru.dasxunya.utils.Historian.*;
import static ru.dasxunya.utils.Searcher.*;

/**
 * The type Update.
 */
public class Update {
    /**
     * Run.
     *
     * @param scanner the scanner
     */
    public static void run(Scanner scanner) {
		AddHistory("update_id");

		Integer id = searchByID(scanner);
		if (id == null) return;

		System.out.println("Обновление элемента в коллекции: ");

		HumanBeing humanBeing = Add.getParameterHumanBeing(scanner, id);
		App.humanBeings.removeIf((human -> human.getId().equals(id)));
		App.humanBeings.add(humanBeing);
	}
}
