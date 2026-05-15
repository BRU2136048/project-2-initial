package com.csc205.project2.shapes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ConeTest {

    private static final double DELTA = 0.001;

    @Test
    void constructorAndGettersShouldWork() {
        Cone cone = new Cone("Orange", 3, 4);

        assertEquals("Cone", cone.getName());
        assertEquals("Orange", cone.getColor());
        assertEquals(3, cone.getRadius());
        assertEquals(4, cone.getHeight());
    }

    @Test
    void settersShouldWork() {
        Cone cone = new Cone("Orange", 3, 4);

        cone.setRadius(6);
        cone.setHeight(8);
        cone.setColor("White");

        assertEquals(6, cone.getRadius());
        assertEquals(8, cone.getHeight());
        assertEquals("White", cone.getColor());
    }

    @Test
    void coneVolumeCalculation() {
        Cone cone = new Cone("Orange", 3, 4);

        assertEquals(37.699, cone.getVolume(), DELTA);
    }

    @Test
    void coneSurfaceAreaCalculation() {
        Cone cone = new Cone("Orange", 3, 4);

        assertEquals(75.398, cone.getSurfaceArea(), DELTA);
    }

    @Test
    void coneSlantHeightCalculation() {
        Cone cone = new Cone("Orange", 3, 4);

        assertEquals(5, cone.getSlantHeight(), DELTA);
    }

   @Test
void coneWithZeroRadiusShouldThrowException() {

    IllegalArgumentException exception =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Cone("Orange", 0, 4)
            );

    assertEquals(
            "Radius must be greater than zero.",
            exception.getMessage()
    );
}

@Test
void coneWithZeroHeightShouldThrowException() {

    IllegalArgumentException exception =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Cone("Orange", 3, 0)
            );

    assertEquals(
            "Height must be greater than zero.",
            exception.getMessage()
    );
}

@Test
void coneWithNegativeValuesShouldThrowException() {

    IllegalArgumentException radiusException =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Cone("Orange", -3, 4)
            );

    assertEquals(
            "Radius must be greater than zero.",
            radiusException.getMessage()
    );

    IllegalArgumentException heightException =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Cone("Orange", 3, -4)
            );

    assertEquals(
            "Height must be greater than zero.",
            heightException.getMessage()
    );
}

@Test
void coneWithNullColorShouldThrowException() {

    IllegalArgumentException exception =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new Cone(null, 3, 4)
            );

    assertEquals(
            "Color cannot be null or blank.",
            exception.getMessage()
    );
}

    @Test
    void coneWithVerySmallValuesShouldWork() {
        Cone cone = new Cone("Orange", 0.0001, 0.0001);

        assertTrue(cone.getVolume() > 0);
        assertTrue(cone.getSurfaceArea() > 0);
    }

    @Test
    void coneAsShape3DShouldWorkPolymorphically() {
        Shape3D shape = new Cone("Orange", 3, 4);

        assertEquals(37.699, shape.getVolume(), DELTA);
        assertEquals(75.398, shape.getSurfaceArea(), DELTA);
    }
}