package ru.dasxunya;

public class Car {
    private String name;
    private boolean cool;

    public Car(String name, boolean cool) {
        this.name = name;
        this.cool = cool;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", cool=" + cool +
                '}';
    }
}
