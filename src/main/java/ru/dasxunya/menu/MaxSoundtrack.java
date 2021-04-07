package ru.dasxunya.menu;

import ru.dasxunya.core.*;

import java.util.*;

import static ru.dasxunya.utils.Historian.*;

/**
 * The type Max soundtrack.
 */
public class MaxSoundtrack {
    /**
     * Run.
     *
     * @param scanner the scanner
     */
    public static void run(Scanner scanner) {
		AddHistory("max_soundtrack");

		System.out.println("SoundtrackName является максимальным: ");

		if (App.humanBeings.isEmpty())
		{
			System.out.println("Такой SoundtrackName отсутствует!");
		}
		else {
			HumanBeing humanBeingWithMaxSoundtrack = App.humanBeings.stream().max(Comparator.comparing(human -> human.getSoundtrackName())).orElse(null);

			System.out.println(humanBeingWithMaxSoundtrack);
		}

	}
}
