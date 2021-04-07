package ru.dasxunya.core;

/**
 * The type Car.
 */
public class Car {
	private  String name;
	private  boolean cool;

    /**
     * Instantiates a new Car.
     *
     * @param name the name
     * @param cool the cool
     */
    public Car(String name, boolean cool) {
		this.name = name;
		this.cool = cool;
	}

    /**
     * Instantiates a new Car.
     */
    public Car() {
	}

	@Override
	public String toString() {
		return "Car{" +
		       "name='" + name + '\'' +
		       ", cool=" + cool +
		       '}';
	}
}
