package ru.dasxunya.menu;

import ru.dasxunya.core.*;

import java.util.*;

import static ru.dasxunya.utils.Historian.*;

/**
 * The type Unique weapon.
 */
public class UniqueWeapon {
    /**
     * Run.
     *
	 */
    public static void run() {
		AddHistory("unique_weapon");

		System.out.println("Уникальные значения поля weaponType: ");

		if (App.humanBeings.isEmpty())
		{
			System.out.println("Значения поля weaponType отсутствуют!");
		}
		else {
			SortedSet<String> weaponTypeSet = new TreeSet<>();

			for (HumanBeing humanBeing : App.humanBeings) {
				weaponTypeSet.add(humanBeing.getWeaponType().toString());
			}

			for (String weaponType : weaponTypeSet) {
				System.out.println(weaponType);
			}
		}
	}
}
