package com.csc205.project2.shapes;

/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: ChatGPT 5.5
 * Generation Date: 2026-05-14
 *
 * Formula Verification:
 * - Volume formula verified against: https://www.mathsisfun.com/geometry/sphere.html
 * - Surface area formula verified against: https://www.mathsisfun.com/geometry/sphere.html
 */

public class Sphere extends Shape3D {

    private double radius;

    public Sphere(String color, double radius) {
        this("Sphere", color, radius);
    }

    public Sphere(String name, String color, double radius) {

        super(name, color);

        if (radius <= 0) {
            throw new IllegalArgumentException(
                    "Radius must be greater than zero."
            );
        }

        this.radius = radius;
    }

    @Override
    protected double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    protected double calculateSurfaceArea() {
        return 4.0 * Math.PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {

        if (radius <= 0) {
            throw new IllegalArgumentException(
                    "Radius must be greater than zero."
            );
        }

        this.radius = radius;
    }

    @Override
    public String toString() {
        return String.format(
                "Sphere{name='%s', color='%s', radius=%.2f}",
                getName(),
                getColor(),
                radius
        );
    }
}