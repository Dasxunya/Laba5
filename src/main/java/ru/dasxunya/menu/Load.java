package ru.dasxunya.menu;

import com.fasterxml.jackson.databind.*;
import ru.dasxunya.core.*;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;

import static ru.dasxunya.utils.Utils.*;

public class Load {
	public static void run(Scanner scanner) {
		String filename = "humans.json";

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
			App.humanBeings = new TreeSet<HumanBeing>(Arrays.asList(humanBeings));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
}