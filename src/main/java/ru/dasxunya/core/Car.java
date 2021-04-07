package ru.dasxunya.core;

public class Car {
	private  String name;
	private  boolean cool;

	public Car(String name, boolean cool) {
		this.name = name;
		this.cool = cool;
	}

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
