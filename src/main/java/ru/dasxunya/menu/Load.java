package ru.dasxunya.menu;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.dasxunya.core.App;
import ru.dasxunya.core.HumanBeing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;

import static ru.dasxunya.utils.Utils.SYSTEM_VARIABLE;
import static ru.dasxunya.utils.Utils.getObjectMapper;

/**
 * The type Load.
 */
public class Load {
    /**
     * Run.
     *
	 */
    public static void run() {
		String filename = System.getenv(SYSTEM_VARIABLE);


		// https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
		StringBuilder jsonStringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(filename)))
		{

			String currentLine;
			while ((currentLine = br.readLine()) != null)
			{
				jsonStringBuilder.append(currentLine).append("\n");
			}

			// https://www.baeldung.com/jackson-object-mapper-tutorial
			ObjectMapper objectMapper = getObjectMapper();
			HumanBeing[] humanBeings = objectMapper.readValue(jsonStringBuilder.toString(), HumanBeing[].class);
			App.humanBeings = new TreeSet<>(Arrays.asList(humanBeings));
		}
		catch (IOException e)
		{
			System.out.println("Проблемы с файлом humans.json!");
		}


	}
}
