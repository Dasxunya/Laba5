package ru.dasxunya.core;

import com.fasterxml.jackson.annotation.*;

import java.time.*;

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

	public HumanBeing() {
	}

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

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public Boolean getRealHero() {
		return realHero;
	}

	public boolean isHasToothpick() {
		return hasToothpick;
	}

	public Double getImpactSpeed() {
		return impactSpeed;
	}

	public String getSoundtrackName() {
		return soundtrackName;
	}

	public WeaponType getWeaponType() {
		return weaponType;
	}

	public Mood getMood() {
		return mood;
	}

	public Car getCar() {
		return car;
	}

	@Override
	public int compareTo(HumanBeing other) {
		return this.id - other.id;
	}
}
