package ru.dasxunya.menu;


import ru.dasxunya.core.*;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static ru.dasxunya.utils.Historian.*;

/**
 * The type Execute script.
 */
public class ExecuteScript {
    /**
     * Run.
     *
     * @param filename the scanner
     */
    public static void run(String filename) {
        AddHistory("execute_script");
        System.out.println("Считывание и исполнение скрипта: ");

        // https://www.java.com/ru/download/help/path.html

        if (Files.exists(Paths.get(filename)) && !Files.isRegularFile(Paths.get(filename))) {
            System.out.println("Нельзя передать специальный файл в качестве скрипта!");
        }
        else {
            if (App.execute_script_completed) {
                System.out.println("Нельзя выполнять скрипт внутри другого вызова скрипта!");
            } else {
                FileReader fileReader = null;
                try {
                    fileReader = new FileReader(filename);

                    Scanner newScanner = new Scanner(fileReader);

                    App.execute_script_completed = true;
                    App.Menu(newScanner);
                    fileReader.close();
                    App.execute_script_completed = false;
                } catch (FileNotFoundException | NullPointerException exception) {
                    System.out.println("Файл не найден (проверьте права доступа или создайте файл)!");
                } catch (IOException exception) {
                    System.out.println("Проблема с доступом к файлу!");
                }

            }


        }
    }
}
