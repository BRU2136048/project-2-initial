package com.csc205.project2.shapes;

/**
 * Factory class for creating Shape3D objects.
 */
public final class ShapeFactory {

    private ShapeFactory() {
        // Prevent object creation
    }

    public static Shape3D create(
            Class<? extends Shape3D> shapeClass,
            String name,
            double... dimensions) {

        if (shapeClass == null) {
            throw new IllegalArgumentException("Shape class cannot be null.");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Shape name cannot be null or blank.");
        }

        if (dimensions == null) {
            throw new IllegalArgumentException("Dimensions cannot be null.");
        }

        if (shapeClass == Sphere.class) {
            validateDimensionCount("Sphere", dimensions, 1);
            return new Sphere(name, "Unspecified", dimensions[0]);
        }

        if (shapeClass == Cube.class) {
            validateDimensionCount("Cube", dimensions, 1);
            return new Cube(name, "Unspecified", dimensions[0]);
        }

        if (shapeClass == Cylinder.class) {
            validateDimensionCount("Cylinder", dimensions, 2);
            return new Cylinder(name, "Unspecified", dimensions[0], dimensions[1]);
        }

        if (shapeClass == RectangularPrism.class) {
            validateDimensionCount("Rectangular Prism", dimensions, 3);
            return new RectangularPrism(
                    name,
                    "Unspecified",
                    dimensions[0],
                    dimensions[1],
                    dimensions[2]
            );
        }

        if (shapeClass == Cone.class) {
            validateDimensionCount("Cone", dimensions, 2);
            return new Cone(name, "Unspecified", dimensions[0], dimensions[1]);
        }

        throw new IllegalArgumentException(
                "Unsupported shape type: " + shapeClass.getSimpleName()
        );
    }

    private static void validateDimensionCount(
            String shapeName,
            double[] dimensions,
            int expectedCount) {

        if (dimensions.length != expectedCount) {
            throw new IllegalArgumentException(
                    shapeName + " requires " + expectedCount + " dimension(s)."
            );
        }
    }
}