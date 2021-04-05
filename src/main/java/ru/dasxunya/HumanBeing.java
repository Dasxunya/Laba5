package ru.dasxunya;

import java.time.ZonedDateTime;

public class HumanBeing {
    @Override
    public String toString() {
        return "HumanBeing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", realHero=" + realHero +
                ", hasToothpick=" + hasToothpick +
                ", impactSpeed=" + impactSpeed +
                ", soundtrackName='" + soundtrackName + '\'' +
                ", weaponType=" + weaponType +
                ", mood=" + mood +
                ", car=" + car +
                '}';
    }

    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным(?), Значение этого поля должно генерироваться автоматически(?)
    private String name; //Поле не может быть null, Строка не может быть пустой+
    private Coordinates coordinates; //Поле не может быть null+
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически(?)+
    private Boolean realHero; //Поле не может быть null(?)
    private boolean hasToothpick;
    private Double impactSpeed; //Максимальное значение поля: 10, Поле может быть null+
    private String soundtrackName; //Поле не может быть null+
    private WeaponType weaponType; //Поле не может быть null+
    private Mood mood; //Поле может быть null+
    private Car car; //Поле может быть null+

    public HumanBeing(Integer id, String name, Coordinates coordinates, ZonedDateTime creationDate, boolean realHero, boolean hasToothpick, Double impactSpeed, String soundtrackName, WeaponType weaponType, Mood mood, Car car) {
        // TODO: Сделать проверку на уникальный идентификатор
        if (id == null) {
            throw new NullPointerException("id оказался null!");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("id не может быть отрицательным или равным нулю!");
        }
        if (name == null) {
            throw new NullPointerException("name не может быть null!");
        }
        if (name.equals("")) {
            throw new IllegalArgumentException("Введите значение для name!");
        }
        if (coordinates == null) {
            throw new NullPointerException("coordinates не может быть null!");
        }
        if (creationDate == null) {
            throw new NullPointerException("creationDate не может быть null!");
        }
        if (impactSpeed < 0) {
            throw new IllegalArgumentException("impactSpeed не может быть отрицательным!");
        }
        if (impactSpeed > 10) {
            throw new IllegalArgumentException("impactSpeed не может быть больше 10!");
        }
        if (soundtrackName == null) {
            throw new NullPointerException("soundtrackName не может быть null!");
        }
        if (weaponType == null) {
            throw new NullPointerException("weaponType не может быть null!");
        }

        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.weaponType = weaponType;
        this.mood = mood;
        this.car = car;
    }
}
