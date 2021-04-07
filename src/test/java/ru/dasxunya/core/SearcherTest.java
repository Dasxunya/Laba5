package ru.dasxunya.core;

import org.junit.jupiter.api.*;
import ru.dasxunya.utils.*;

import java.util.*;
import java.util.function.*;

import static ru.dasxunya.UtilsTest.*;

public class SearcherTest {
	@Test
	void SearchByIDWithoutHumans() {
		String input = Utils.collectStrings();
		String expected = Utils.collectStrings("В коллекции нет объектов! Поиск по идентификатору невозможен!");


		runTest(input, expected, Searcher::searchByID);
	}

	@Test
	void SearchByIDWithHumans() {
		String input = Utils.collectStrings("", "ABC", "-10", "2", id.toString());
		String expected = Utils.collectStrings("Введите идентификатор: ",
		                                       "Некорректный идентификатор!",
		                                       "Введите идентификатор: ",
		                                       "Некорректный идентификатор!",
		                                       "Введите идентификатор: ",
		                                       "Идентификатор не может быть отрицательным!",
		                                       "Введите идентификатор: ",
		                                       "Такого идентификатора не существует!",
		                                       "Введите идентификатор: ");

		Consumer<Scanner> method = scanner -> {
			AddExampleHumanToCollection();
			Searcher.searchByID(scanner);
		};

		runTest(input, expected, method);


	}
}
