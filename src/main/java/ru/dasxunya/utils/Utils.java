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

/**
 * The type Utils.
 */
public class Utils {
    /**
     * The constant originalOutput.
     */
    public static final PrintStream originalOutput = System.out;
    /**
     * The constant originalInput.
     */
    public static final InputStream originalInput = System.in;
    /**
     * The constant LINE_SEPARATOR.
     */
    public static final String LINE_SEPARATOR = System.lineSeparator();
    /**
     * The constant EXIT.
     */
    public static final String EXIT = "exit";
    /**
     * The constant outputContent.
     */
    public static ByteArrayOutputStream outputContent;
    /**
     * The constant inputContent.
     */
    public static ByteArrayInputStream inputContent;

    /**
     * The constant SYSTEM_VARIABLE.
     */
    public static String SYSTEM_VARIABLE = "TEST_SCRIPT";
    /**
     * The constant scanner.
     */
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Sets up streams.
     */
    public static void setUpStreams() {
		Utils.outputContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(Utils.outputContent));
	}

    /**
     * Provide input.
     *
     * @param data the data
     */
    public static void provideInput(String data) {
		Utils.inputContent = new ByteArrayInputStream(data.getBytes());
		System.setIn(Utils.inputContent);
		Utils.scanner = new Scanner(System.in);
	}

    /**
     * Restore streams.
     */
    public static void restoreStreams() {
		System.setOut(Utils.originalOutput);
		System.setIn(Utils.originalInput);
	}

    /**
     * Collect strings string.
     *
     * @param cases the cases
     * @return the string
     */
    public static String collectStrings(String... cases) {
		return String.join(Utils.LINE_SEPARATOR, cases).concat(Utils.LINE_SEPARATOR);
	}

    /**
     * Collect strings without end line separator string.
     *
     * @param cases the cases
     * @return the string
     */
    public static String collectStringsWithoutEndLineSeparator(String... cases) {
		return String.join(Utils.LINE_SEPARATOR, cases);
	}

    /**
     * Gets object mapper.
     *
     * @return the object mapper
     */
    public static ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		JavaTimeModule javaTimeModule = new JavaTimeModule();
		objectMapper.registerModule(javaTimeModule);
		return objectMapper;
	}
}
