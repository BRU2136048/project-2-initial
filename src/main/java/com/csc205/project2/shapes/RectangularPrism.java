package com.csc205.project2.shapes;

/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: ChatGPT 5.5
 * Generation Date: 2026-05-14
 */

public class RectangularPrism extends Shape3D {

    private double length;
    private double width;
    private double height;

    public RectangularPrism(
            String color,
            double length,
            double width,
            double height) {

        this(
                "Rectangular Prism",
                color,
                length,
                width,
                height
        );
    }

    public RectangularPrism(
            String name,
            String color,
            double length,
            double width,
            double height) {

        super(name, color);

        if (length <= 0) {
            throw new IllegalArgumentException(
                    "Length must be greater than zero."
            );
        }

        if (width <= 0) {
            throw new IllegalArgumentException(
                    "Width must be greater than zero."
            );
        }

        if (height <= 0) {
            throw new IllegalArgumentException(
                    "Height must be greater than zero."
            );
        }

        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    protected double calculateVolume() {
        return length * width * height;
    }

    @Override
    protected double calculateSurfaceArea() {
        return 2 * (
                length * width +
                length * height +
                width * height
        );
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {

        if (length <= 0) {
            throw new IllegalArgumentException(
                    "Length must be greater than zero."
            );
        }

        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {

        if (width <= 0) {
            throw new IllegalArgumentException(
                    "Width must be greater than zero."
            );
        }

        this.width = width;
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
                "RectangularPrism{name='%s', color='%s', length=%.2f, width=%.2f, height=%.2f}",
                getName(),
                getColor(),
                length,
                width,
                height
        );
    }
}