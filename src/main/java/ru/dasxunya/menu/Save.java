package ru.dasxunya.menu;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.*;
import ru.dasxunya.core.*;

import java.io.*;
import java.util.*;

import static ru.dasxunya.utils.Historian.*;
import static ru.dasxunya.utils.Utils.*;

/**
 * The type Save.
 */
public class Save {
    /**
     * Run.
     *
     * @param scanner the scanner
     */
    public static void run(Scanner scanner) {
		AddHistory("save");

		// https://www.baeldung.com/jackson-object-mapper-tutorial
		// https://www.baeldung.com/jackson-jsonmappingexception
		// https://www.baeldung.com/jackson-serialize-dates

		System.out.println("Сохранение коллекции в файл: ");

		ObjectMapper objectMapper = getObjectMapper();


		try {
			// https://attacomsian.com/blog/jackson-read-write-json
			ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
			String output = writer.writeValueAsString(App.humanBeings);
			String filename = System.getenv(SYSTEM_VARIABLE);
			try(FileOutputStream fos=new FileOutputStream(filename);
			    PrintStream printStream = new PrintStream(fos))
			{
				printStream.println(output);
				System.out.println("Коллекция сохранена в файл!");
			}
			catch(IOException ex){

				System.out.println(ex.getMessage());
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}



	}


}
