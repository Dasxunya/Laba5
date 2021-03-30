package ru.dasxunya;

import org.junit.jupiter.api.*;

public class CarTest {
    @Test
    void CreateCarWithParameters() {
        Car car = new Car("Мой автомобиль.", true);
    }
}

