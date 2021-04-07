package ru.dasxunya.core;

/**
 * The enum Weapon type.
 */
public enum WeaponType implements Comparable<WeaponType>{
    /**
     * Axe weapon type.
     */
    AXE,
    /**
     * Pistol weapon type.
     */
    PISTOL,
    /**
     * Rifle weapon type.
     */
    RIFLE,
    /**
     * Knife weapon type.
     */
    KNIFE,
    /**
     * Bat weapon type.
     */
    BAT;

	@Override
	public String toString() {
		return name();
	}

}
