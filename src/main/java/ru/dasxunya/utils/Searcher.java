package ru.dasxunya.utils;

import ru.dasxunya.core.*;

import java.util.*;

/**
 * The type Searcher.
 */
public class Searcher {
    /**
     * Search by id integer.
     *
     * @param scanner the scanner
     * @return the integer
     */
    public static Integer searchByID(Scanner scanner) {
		if (App.humanBeings.size() == 0) {
			System.out.println("В коллекции нет объектов! Поиск по идентификатору невозможен!");
			return null;
		}

		Integer id;

		while (true) {
			System.out.println("Введите идентификатор: ");

			try {
				String text = scanner.nextLine();
				id = Integer.parseInt(text);
				if (id < 0) {
					throw new IllegalArgumentException("Идентификатор не может быть отрицательным!");
				}
				Integer finalId = id;
				if (App.humanBeings.stream().noneMatch((humanBeing -> humanBeing.getId() == finalId))) {
					System.out.println("Такого идентификатора не существует!");
					continue;
				}

				break;
			} catch (NumberFormatException exception) {
				System.out.println("Некорректный идентификатор!");
			} catch (IllegalArgumentException exception) {
				System.out.println(exception.getMessage());
			}
		}

		return id;
	}
}
