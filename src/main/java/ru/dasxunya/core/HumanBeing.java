package ru.dasxunya.core;

import com.fasterxml.jackson.annotation.*;

import java.time.*;

/**
 * The type Human being.
 */
public class HumanBeing implements Comparable<HumanBeing> {
	private Integer id;
	private String name;
	private Coordinates coordinates;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private java.time.ZonedDateTime creationDate;
	private Boolean realHero;
	private boolean hasToothpick;
	private Double impactSpeed;
	private String soundtrackName;
	private WeaponType weaponType;
	private Mood mood;
	private Car car;

    /**
     * Instantiates a new Human being.
     */
    public HumanBeing() {
	}

    /**
     * Instantiates a new Human being.
     *
     * @param id             the id
     * @param name           the name
     * @param coordinates    the coordinates
     * @param creationDate   the creation date
     * @param realHero       the real hero
     * @param hasToothpick   the has toothpick
     * @param impactSpeed    the impact speed
     * @param soundtrackName the soundtrack name
     * @param weaponType     the weapon type
     * @param mood           the mood
     * @param car            the car
     */
    public HumanBeing(Integer id, String name, Coordinates coordinates, ZonedDateTime creationDate, boolean realHero, boolean hasToothpick, Double impactSpeed, String soundtrackName, WeaponType weaponType, Mood mood, Car car) {
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

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
		return id;
	}

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
		return name;
	}

    /**
     * Gets coordinates.
     *
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
		return coordinates;
	}

    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    public ZonedDateTime getCreationDate() {
		return creationDate;
	}

    /**
     * Gets real hero.
     *
     * @return the real hero
     */
    public Boolean getRealHero() {
		return realHero;
	}

    /**
     * Is has toothpick boolean.
     *
     * @return the boolean
     */
    public boolean isHasToothpick() {
		return hasToothpick;
	}

    /**
     * Gets impact speed.
     *
     * @return the impact speed
     */
    public Double getImpactSpeed() {
		return impactSpeed;
	}

    /**
     * Gets soundtrack name.
     *
     * @return the soundtrack name
     */
    public String getSoundtrackName() {
		return soundtrackName;
	}

    /**
     * Gets weapon type.
     *
     * @return the weapon type
     */
    public WeaponType getWeaponType() {
		return weaponType;
	}

    /**
     * Gets mood.
     *
     * @return the mood
     */
    public Mood getMood() {
		return mood;
	}

    /**
     * Gets car.
     *
     * @return the car
     */
    public Car getCar() {
		return car;
	}

	@Override
	public int compareTo(HumanBeing other) {
		return this.id - other.id;
	}
}
