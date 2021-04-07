package ru.dasxunya.menu;


import ru.dasxunya.core.*;

import java.io.*;
import java.util.*;

import static ru.dasxunya.utils.Historian.*;
import static ru.dasxunya.utils.Utils.*;

public class ExecuteScript {
	public static void run(Scanner scanner)  {
		AddHistory("execute_script");

		System.out.println("Считывание и исполнение скрипта: ");

		// TODO: На локальном компьютере надо добавить переменную окружения!
		// https://www.java.com/ru/download/help/path.html

		String filename = System.getenv(SYSTEM_VARIABLE);

		FileReader fileReader = null;
		try {
			fileReader = new FileReader(filename);
			Scanner newScanner = new Scanner(fileReader);
			App.Menu(newScanner);
			fileReader.close();
		}
		catch (FileNotFoundException | NullPointerException exception)
		{
			System.out.println("Файл не найден!");
		} catch (IOException exception) {
			System.out.println("Проблема с доступом к файлу!");
		}


	}
}
