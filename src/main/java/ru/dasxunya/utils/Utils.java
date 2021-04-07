package ru.dasxunya.utils;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.*;
import com.fasterxml.jackson.datatype.jsr310.deser.*;
import com.fasterxml.jackson.datatype.jsr310.ser.*;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class Utils {
	public static final PrintStream originalOutput = System.out;
	public static final InputStream originalInput = System.in;
	public static final String LINE_SEPARATOR = System.lineSeparator();
	public static final String EXIT = "exit";
	public static ByteArrayOutputStream outputContent;
	public static ByteArrayInputStream inputContent;

	public static String SYSTEM_VARIABLE = "TEST_SCRIPT";
	public static Scanner scanner = new Scanner(System.in);

	public static void setUpStreams() {
		Utils.outputContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(Utils.outputContent));
	}

	public static void provideInput(String data) {
		Utils.inputContent = new ByteArrayInputStream(data.getBytes());
		System.setIn(Utils.inputContent);
		Utils.scanner = new Scanner(System.in);
	}

	public static void restoreStreams() {
		System.setOut(Utils.originalOutput);
		System.setIn(Utils.originalInput);
	}

	public static String collectStrings(String... cases) {
		return String.join(Utils.LINE_SEPARATOR, cases).concat(Utils.LINE_SEPARATOR);
	}

	public static String collectStringsWithoutEndLineSeparator(String... cases) {
		return String.join(Utils.LINE_SEPARATOR, cases);
	}

	public static ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		JavaTimeModule javaTimeModule = new JavaTimeModule();
		objectMapper.registerModule(javaTimeModule);
		return objectMapper;
	}
}
