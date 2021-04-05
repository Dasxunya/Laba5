package ru.dasxunya.menu;

import ru.dasxunya.App;
import ru.dasxunya.HumanBeing;

import java.util.Scanner;

public class Update {
    public static void update(Scanner scanner) {



        if (App.humanBeings.size() == 0)
        {
            System.out.println("В коллекции нет объектов! Обновление по идентификатору невозможно!");
            return;
        }

        Integer id;
        while (true) {
            System.out.println("Введите идентификатор:");

            try {
                String text = scanner.nextLine();
                id = Integer.parseInt(text);
                if (id < 0) {
                    throw new IllegalArgumentException("id не может быть отрицательным!");
                }
                Integer finalId = id;
                if (App.humanBeings.stream().noneMatch((humanBeing -> humanBeing.getId() == finalId)))
                {
                    System.out.println("Такого идентификатора не существует!");
                    continue;
                }

                break;
            } catch (NumberFormatException exception) {
                System.out.println("Некорректный аргумент для переменной id!");
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        System.out.println("Обновление элемента в коллекции: ");
       // TODO: вытащить по идентификатору

        HumanBeing humanBeing = Add.getParameterHumanBeing(scanner);

        humanBeing.setId(id);
        Integer finalId1 = id;
        App.humanBeings.removeIf((human -> human.getId() == finalId1));
        App.humanBeings.add(humanBeing);
    }
}
