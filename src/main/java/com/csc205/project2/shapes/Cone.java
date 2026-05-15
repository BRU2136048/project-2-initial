package com.csc205.project2.shapes;

/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: ChatGPT 5.5
 * Generation Date: 2026-05-14
 */

public class Cone extends Shape3D {

    private double radius;
    private double height;

    public Cone(String color, double radius, double height) {
        this("Cone", color, radius, height);
    }

    public Cone(
            String name,
            String color,
            double radius,
            double height) {

        super(name, color);

        if (radius <= 0) {
            throw new IllegalArgumentException(
                    "Radius must be greater than zero."
            );
        }

        if (height <= 0) {
            throw new IllegalArgumentException(
                    "Height must be greater than zero."
            );
        }

        this.radius = radius;
        this.height = height;
    }

    @Override
    protected double calculateVolume() {
        return (1.0 / 3.0) *
                Math.PI *
                Math.pow(radius, 2) *
                height;
    }

    @Override
    protected double calculateSurfaceArea() {

        double slantHeight =
                Math.sqrt(
                        Math.pow(radius, 2) +
                        Math.pow(height, 2)
                );

        return Math.PI * radius * (radius + slantHeight);
    }

    public double getSlantHeight() {
        return Math.sqrt(
                Math.pow(radius, 2) +
                Math.pow(height, 2)
        );
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {

        if (height <= 0) {
            throw new IllegalArgumentException(
                    "Height must be greater than zero."
            );
        }

        this.height = height;
    }

    @Override
    public String toString() {
        return String.format(
                "Cone{name='%s', color='%s', radius=%.2f, height=%.2f}",
                getName(),
                getColor(),
                radius,
                height
        );
    }
}