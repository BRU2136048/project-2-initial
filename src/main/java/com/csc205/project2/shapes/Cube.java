package com.csc205.project2.shapes;

/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: ChatGPT 5.5
 * Generation Date: 2026-05-14
 *
 * Original Prompt:
 * "Create Five Concrete Shape Classes"
 *
 * Follow-up Prompts (if any):
 * 1. "Implement validation and constructors"
 * 2. "Implement factory pattern support"
 *
 * Manual Modifications:
 * - Added overloaded constructor for factory support
 * - Added validation directly inside constructors
 * - Refactored constructor chaining
 *
 * Formula Verification:
 * - Volume formula verified against: https://mathworld.wolfram.com/Cube.html
 * - Surface area formula verified against: https://mathworld.wolfram.com/Cube.html
 */
public class Cube extends Shape3D {

    private double sideLength;

    /**
     * Constructs a Cube with a default name.
     *
     * @param color the color of the cube
     * @param sideLength the side length
     */
    public Cube(String color, double sideLength) {
        this("Cube", color, sideLength);
    }

    /**
     * Constructs a Cube with a custom name.
     *
     * @param name the custom name
     * @param color the color
     * @param sideLength the side length
     */
    public Cube(String name,
                String color,
                double sideLength) {

        super(name, color);

        if (sideLength <= 0) {
            throw new IllegalArgumentException(
                    "Side length must be greater than zero."
            );
        }

        this.sideLength = sideLength;
    }

    /**
     * Calculates cube volume.
     *
     * @return cube volume
     */
    @Override
    protected double calculateVolume() {
        return Math.pow(sideLength, 3);
    }

    /**
     * Calculates cube surface area.
     *
     * @return cube surface area
     */
    @Override
    protected double calculateSurfaceArea() {
        return 6 * Math.pow(sideLength, 2);
    }

    /**
     * Gets side length.
     *
     * @return side length
     */
    public double getSideLength() {
        return sideLength;
    }

    /**
     * Sets side length.
     *
     * @param sideLength the new side length
     */
    public void setSideLength(double sideLength) {

        if (sideLength <= 0) {
            throw new IllegalArgumentException(
                    "Side length must be greater than zero."
            );
        }

        this.sideLength = sideLength;
    }

    /**
     * Returns formatted cube information.
     *
     * @return formatted string
     */
    @Override
    public String toString() {
        return String.format(
                "Cube{name='%s', color='%s', sideLength=%.2f}",
                getName(),
                getColor(),
                sideLength
        );
    }
}