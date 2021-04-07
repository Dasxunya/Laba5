package ru.dasxunya.core;

/**
 * The type Coordinates.
 */
public class Coordinates {
	private  Long x;
	private  int y;

    /**
     * Instantiates a new Coordinates.
     *
     * @param x the x
     * @param y the y
     */
    public Coordinates(Long x, int y) {
		this.x = x;
		this.y = y;
	}

    /**
     * Instantiates a new Coordinates.
     */
    public Coordinates() {
	}

	@Override
	public String toString() {
		return "Coordinates{" +
		       "x=" + x +
		       ", y=" + y +
		       '}';
	}
}
