package com.csc205.project2.shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CylinderTest {

    private static final double DELTA = 0.001;

    @Test
    void constructorAndGettersShouldWork() {
        Cylinder cylinder = new Cylinder("Red", 3, 5);

        assertEquals("Cylinder", cylinder.getName());
        assertEquals("Red", cylinder.getColor());
        assertEquals(3, cylinder.getRadius());
        assertEquals(5, cylinder.getHeight());
    }

    @Test
    void settersShouldWork() {
        Cylinder cylinder = new Cylinder("Red", 3, 5);

        cylinder.setRadius(4);
        cylinder.setHeight(10);
        cylinder.setColor("Black");

        assertEquals(4, cylinder.getRadius());
        assertEquals(10, cylinder.getHeight());
        assertEquals("Black", cylinder.getColor());
    }

    @Test
    void cylinderVolumeCalculation() {
        Cylinder cylinder = new Cylinder("Red", 3, 5);

        assertEquals(141.371, cylinder.getVolume(), DELTA);
    }

    @Test
    void cylinderSurfaceAreaCalculation() {
        Cylinder cylinder = new Cylinder("Red", 3, 5);

        assertEquals(150.796, cylinder.getSurfaceArea(), DELTA);
    }

    @Test
void cylinderWithZeroRadiusShouldThrowException() {

    IllegalArgumentException exception =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Cylinder("Red", 0, 5)
            );

    assertEquals(
            "Radius must be greater than zero.",
            exception.getMessage()
    );
}

@Test
void cylinderWithZeroHeightShouldThrowException() {

    IllegalArgumentException exception =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Cylinder("Red", 3, 0)
            );

    assertEquals(
            "Height must be greater than zero.",
            exception.getMessage()
    );
}

@Test
void cylinderWithNegativeValuesShouldThrowException() {

    IllegalArgumentException radiusException =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Cylinder("Red", -3, 5)
            );

    assertEquals(
            "Radius must be greater than zero.",
            radiusException.getMessage()
    );

    IllegalArgumentException heightException =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Cylinder("Red", 3, -5)
            );

    assertEquals(
            "Height must be greater than zero.",
            heightException.getMessage()
    );
}

@Test
void cylinderWithNullColorShouldThrowException() {

    IllegalArgumentException exception =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Cylinder(null, 3, 5)
            );

    assertEquals(
            "Color cannot be null or blank.",
            exception.getMessage()
    );
}

    @Test
    void cylinderWithVerySmallValuesShouldWork() {
        Cylinder cylinder = new Cylinder("Red", 0.0001, 0.0001);

        assertTrue(cylinder.getVolume() > 0);
        assertTrue(cylinder.getSurfaceArea() > 0);
    }

    @Test
    void cylinderAsShape3DShouldWorkPolymorphically() {
        Shape3D shape = new Cylinder("Red", 3, 5);

        assertEquals(141.371, shape.getVolume(), DELTA);
        assertEquals(150.796, shape.getSurfaceArea(), DELTA);
    }
}