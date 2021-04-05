package ru.dasxunya;

public class Coordinates {
    private Long x;
    private int y;

    public Coordinates(Long x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
