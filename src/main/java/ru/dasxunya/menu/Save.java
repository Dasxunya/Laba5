package ru.dasxunya.menu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import ru.dasxunya.core.App;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static ru.dasxunya.utils.Historian.AddHistory;
import static ru.dasxunya.utils.Utils.SYSTEM_VARIABLE;
import static ru.dasxunya.utils.Utils.getObjectMapper;

/**
 * The type Save.
 */
public class Save {
    /**
     * Run.
     *
	 */
    public static void run() {
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
