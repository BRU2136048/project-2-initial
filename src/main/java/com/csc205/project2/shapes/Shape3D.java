package com.csc205.project2.shapes;

/**
 * Abstract base class for all three-dimensional shapes.
 */
public abstract class Shape3D implements ThreeDimensionalShape {

    private String name;
    private String color;

    public Shape3D(String name, String color) {

    if (name == null || name.isBlank()) {
        throw new IllegalArgumentException(
                "Name cannot be null or blank."
        );
    }

    if (color == null || color.isBlank()) {
        throw new IllegalArgumentException(
                "Color cannot be null or blank."
        );
    }

    this.name = name;
    this.color = color;
}
    @Override
    public double getVolume() {
        return calculateVolume();
    }

    @Override
    public double getSurfaceArea() {
        return calculateSurfaceArea();
    }

    protected abstract double calculateVolume();

    protected abstract double calculateSurfaceArea();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }

        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.isBlank()) {
            throw new IllegalArgumentException("Color cannot be null or blank.");
        }

        this.color = color;
    }

    @Override
    public String toString() {
        return String.format(
                "%s{name='%s', color='%s'}",
                getClass().getSimpleName(),
                name,
                color
        );
    }
}