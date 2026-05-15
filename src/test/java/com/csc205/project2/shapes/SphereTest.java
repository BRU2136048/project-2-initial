package com.csc205.project2.shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class SphereTest {

    private static final double DELTA = 0.001;

    @Test
    void constructorAndGettersShouldWork() {
        Sphere sphere = new Sphere("Blue", 3);

        assertEquals("Sphere", sphere.getName());
        assertEquals("Blue", sphere.getColor());
        assertEquals(3, sphere.getRadius());
    }

    @Test
    void settersShouldWork() {
        Sphere sphere = new Sphere("Blue", 3);

        sphere.setColor("Red");
        sphere.setRadius(5);

        assertEquals("Red", sphere.getColor());
        assertEquals(5, sphere.getRadius());
    }

    @Test
    void sphereVolumeCalculation() {
        Sphere sphere = new Sphere("Blue", 3);

        assertEquals(113.097, sphere.getVolume(), DELTA);
    }

    @Test
    void sphereSurfaceAreaCalculation() {
        Sphere sphere = new Sphere("Blue", 3);

        assertEquals(113.097, sphere.getSurfaceArea(), DELTA);
    }

    @Test
void sphereWithZeroRadiusShouldThrowException() {

    IllegalArgumentException exception =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Sphere("Blue", 0)
            );

    assertEquals(
            "Radius must be greater than zero.",
            exception.getMessage()
    );
}

   @Test
void sphereWithNegativeRadiusShouldThrowException() {

    IllegalArgumentException exception =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Sphere("Blue", -1)
            );

    assertEquals(
            "Radius must be greater than zero.",
            exception.getMessage()
    );
}

    @Test
void sphereWithNullColorShouldThrowException() {

    IllegalArgumentException exception =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Sphere(null, 3)
            );

    assertEquals(
            "Color cannot be null or blank.",
            exception.getMessage()
    );
}

    @Test
void sphereWithBlankColorShouldThrowException() {

    IllegalArgumentException exception =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Sphere("   ", 3)
            );

    assertEquals(
            "Color cannot be null or blank.",
            exception.getMessage()
    );
}

    @Test
    void sphereWithVerySmallRadiusShouldWork() {
        Sphere sphere = new Sphere("Blue", 0.0001);

        assertTrue(sphere.getVolume() > 0);
        assertTrue(sphere.getSurfaceArea() > 0);
    }

    @Test
    void sphereWithLargeRadiusShouldWork() {
        Sphere sphere = new Sphere("Blue", 1_000_000);

        assertTrue(sphere.getVolume() > 0);
        assertTrue(sphere.getSurfaceArea() > 0);
    }

    @Test
    void sphereAsShape3DShouldWorkPolymorphically() {
        Shape3D shape = new Sphere("Blue", 3);

        assertEquals(113.097, shape.getVolume(), DELTA);
        assertEquals(113.097, shape.getSurfaceArea(), DELTA);
    }
}