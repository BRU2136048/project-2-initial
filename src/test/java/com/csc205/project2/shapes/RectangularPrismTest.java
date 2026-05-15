package com.csc205.project2.shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class RectangularPrismTest {

    private static final double DELTA = 0.001;

    @Test
    void constructorAndGettersShouldWork() {
        RectangularPrism prism = new RectangularPrism("Purple", 2, 3, 4);

        assertEquals("Rectangular Prism", prism.getName());
        assertEquals("Purple", prism.getColor());
        assertEquals(2, prism.getLength());
        assertEquals(3, prism.getWidth());
        assertEquals(4, prism.getHeight());
    }

    @Test
    void rectangularPrismVolumeCalculation() {
        RectangularPrism prism = new RectangularPrism("Purple", 2, 3, 4);

        assertEquals(24, prism.getVolume(), DELTA);
    }

    @Test
    void rectangularPrismSurfaceAreaCalculation() {
        RectangularPrism prism = new RectangularPrism("Purple", 2, 3, 4);

        assertEquals(52, prism.getSurfaceArea(), DELTA);
    }

    @Test
void rectangularPrismWithZeroValueShouldThrowException() {

    IllegalArgumentException lengthException =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new RectangularPrism("Purple", 0, 3, 4)
            );

    assertEquals(
            "Length must be greater than zero.",
            lengthException.getMessage()
    );

    IllegalArgumentException widthException =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new RectangularPrism("Purple", 2, 0, 4)
            );

    assertEquals(
            "Width must be greater than zero.",
            widthException.getMessage()
    );

    IllegalArgumentException heightException =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new RectangularPrism("Purple", 2, 3, 0)
            );

    assertEquals(
            "Height must be greater than zero.",
            heightException.getMessage()
    );
}
    @Test
void rectangularPrismWithNegativeValueShouldThrowException() {

    IllegalArgumentException lengthException =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new RectangularPrism("Purple", -2, 3, 4)
            );

    assertEquals(
            "Length must be greater than zero.",
            lengthException.getMessage()
    );

    IllegalArgumentException widthException =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new RectangularPrism("Purple", 2, -3, 4)
            );

    assertEquals(
            "Width must be greater than zero.",
            widthException.getMessage()
    );

    IllegalArgumentException heightException =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new RectangularPrism("Purple", 2, 3, -4)
            );

    assertEquals(
            "Height must be greater than zero.",
            heightException.getMessage()
    );
}

    @Test
void rectangularPrismWithNullColorShouldThrowException() {

    IllegalArgumentException exception =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new RectangularPrism(null, 2, 3, 4)
            );

    assertEquals(
            "Color cannot be null or blank.",
            exception.getMessage()
    );
}
    @Test
    void rectangularPrismWithVerySmallValuesShouldWork() {
        RectangularPrism prism = new RectangularPrism("Purple", 0.0001, 0.0001, 0.0001);

        assertTrue(prism.getVolume() > 0);
        assertTrue(prism.getSurfaceArea() > 0);
    }

    @Test
    void rectangularPrismAsShape3DShouldWorkPolymorphically() {
        Shape3D shape = new RectangularPrism("Purple", 2, 3, 4);

        assertEquals(24, shape.getVolume(), DELTA);
        assertEquals(52, shape.getSurfaceArea(), DELTA);
    }
}