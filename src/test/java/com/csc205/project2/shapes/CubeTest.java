package com.csc205.project2.shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CubeTest {

    private static final double DELTA = 0.001;

    @Test
    void constructorAndGettersShouldWork() {
        Cube cube = new Cube("Green", 4);

        assertEquals("Cube", cube.getName());
        assertEquals("Green", cube.getColor());
        assertEquals(4, cube.getSideLength());
    }

    @Test
    void settersShouldWork() {
        Cube cube = new Cube("Green", 4);

        cube.setColor("Yellow");
        cube.setSideLength(6);

        assertEquals("Yellow", cube.getColor());
        assertEquals(6, cube.getSideLength());
    }

    @Test
    void cubeVolumeCalculation() {
        Cube cube = new Cube("Green", 4);

        assertEquals(64, cube.getVolume(), DELTA);
    }

    @Test
    void cubeSurfaceAreaCalculation() {
        Cube cube = new Cube("Green", 4);

        assertEquals(96, cube.getSurfaceArea(), DELTA);
    }

    @Test
void cubeWithZeroSideLengthShouldThrowException() {

    IllegalArgumentException exception =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Cube("Green", 0)
            );

    assertEquals(
            "Side length must be greater than zero.",
            exception.getMessage()
    );
}

@Test
void cubeWithNegativeSideLengthShouldThrowException() {

    IllegalArgumentException exception =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Cube("Green", -4)
            );

    assertEquals(
            "Side length must be greater than zero.",
            exception.getMessage()
    );
}

@Test
void cubeWithNullColorShouldThrowException() {

    IllegalArgumentException exception =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Cube(null, 4)
            );

    assertEquals(
            "Color cannot be null or blank.",
            exception.getMessage()
    );
}

    @Test
    void cubeWithVerySmallSideLengthShouldWork() {
        Cube cube = new Cube("Green", 0.0001);

        assertTrue(cube.getVolume() > 0);
        assertTrue(cube.getSurfaceArea() > 0);
    }

    @Test
    void cubeWithLargeSideLengthShouldWork() {
        Cube cube = new Cube("Green", 1_000_000);

        assertTrue(cube.getVolume() > 0);
        assertTrue(cube.getSurfaceArea() > 0);
    }

    @Test
    void cubeAsShape3DShouldWorkPolymorphically() {
        Shape3D shape = new Cube("Green", 4);

        assertEquals(64, shape.getVolume(), DELTA);
        assertEquals(96, shape.getSurfaceArea(), DELTA);
    }
}