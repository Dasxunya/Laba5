package ru.dasxunya.menu;

import ru.dasxunya.core.*;

import java.util.*;

import static ru.dasxunya.utils.Historian.*;

public class AddIfMin {
	public static void run(Scanner scanner) {
		AddHistory("add_if_min");

		System.out.println("Если элемент меньше минимального, добавление в коллекцию: ");

		HumanBeing humanBeing = Add.getParameterHumanBeing(scanner, Add.getParameterId());

		HumanBeing humanBeingWithMaxImpactSpeed = App.humanBeings.stream().min(Comparator.comparing(human -> human.getImpactSpeed())).orElse(null);

		if (App.humanBeings.isEmpty() || humanBeingWithMaxImpactSpeed.getImpactSpeed() > humanBeing.getImpactSpeed())
		{
			System.out.println("Скорость удара существа оказалась меньше минимальных значений в коллекции. Добавляем существо в коллекцию!");
			App.humanBeings.add(humanBeing);
		}
		else {
			System.out.println("Скорость удара существа оказалась больше минимальных значений в коллекции. Существо не добавляем!");
	}
	}
}
