package ru.dasxunya.utils;

import ru.dasxunya.core.*;

import static ru.dasxunya.core.App.*;

public class Historian {
	public static void AddHistory(String text) {
		if (history.size() == 11)
		{
			history.removeFirst();
		}
		history.add(text);
	}
}
