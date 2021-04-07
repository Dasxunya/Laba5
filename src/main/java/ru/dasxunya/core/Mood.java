package ru.dasxunya.core;

/**
 * The enum Mood.
 */
public enum Mood {
    /**
     * Sadness mood.
     */
    SADNESS,
    /**
     * Longing mood.
     */
    LONGING,
    /**
     * Calm mood.
     */
    CALM,
    /**
     * Rage mood.
     */
    RAGE;

	@Override
	public String toString() {
		return name();
	}

}
