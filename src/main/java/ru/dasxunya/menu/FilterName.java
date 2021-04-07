package ru.dasxunya.menu;


import ru.dasxunya.core.*;

import java.util.*;
import java.util.stream.*;

import static ru.dasxunya.menu.Add.*;
import static ru.dasxunya.utils.Historian.*;

/**
 * The type Filter name.
 */
public class FilterName {
    /**
     * Run.
     *
     * @param scanner the scanner
     */
    public static void run(Scanner scanner) {
		AddHistory("filter_name");

		System.out.println("Значение поля name начинается с заданной подстроки: ");

		if (App.humanBeings.isEmpty())
		{
			System.out.println("Коллекция пустая! Поиск невозможен!");
		}
		else {
			String name = getParameterName(scanner);

			// https://metanit.com/java/tutorial/10.6.php
			List<HumanBeing> humanBeingsWithSubstringName = App.humanBeings.stream().filter(humanBeing -> humanBeing.getName().indexOf(name) == 0).collect(Collectors.toList());

			Collections.sort(humanBeingsWithSubstringName);

			for (HumanBeing humanBeing : humanBeingsWithSubstringName) {
				System.out.println(humanBeing);
			}
		}
	}
}
