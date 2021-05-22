package ru.dasxunya.utils;

import static ru.dasxunya.core.App.history;

/**
 * The type Historian.
 */
public class Historian {
    /**
     * Add history.
     *
     * @param text the text
     */
    public static void AddHistory(String text) {
		if (history.size() == 11)
		{
			history.removeFirst();
		}
		history.add(text);
	}
}
