package com.csc205.project2.shapes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ShapeDriver {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Shape3D> shapes = new ArrayList<>();

        shapes.add(new Sphere("Red", 5.0));
        shapes.add(new Cube("Blue", 4.0));
        shapes.add(new Cylinder("Green", 3.0, 7.0));
        shapes.add(new RectangularPrism("Purple", 2.0, 4.0, 6.0));
        shapes.add(new Cone("Orange", 3.0, 4.0));

        System.out.println("=== 3D Shape Analysis System ===\n");

        boolean running = true;

        while (running) {
            printMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> displayShapes(shapes);
                case 2 -> addCustomShape(shapes);
                case 3 -> analyzeShapes(shapes);
                case 4 -> performanceTest(shapes);
                case 5 -> {
                    System.out.println("\nExiting Shape Analysis System.");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println("""
                Menu:
                1. Display all shapes
                2. Create a custom shape
                3. Analyze shapes
                4. Run performance timing test
                5. Exit
                """);
    }

    private static void displayShapes(List<Shape3D> shapes) {
        System.out.println("\nCreated Shapes:");

        for (int i = 0; i < shapes.size(); i++) {
            Shape3D shape = shapes.get(i);

            System.out.printf("%d. %s%n", i + 1, shape);
            System.out.printf("   - Surface Area: %.2f square units%n", shape.getSurfaceArea());
            System.out.printf("   - Volume: %.2f cubic units%n%n", shape.getVolume());
        }
    }

    private static void analyzeShapes(List<Shape3D> shapes) {
        if (shapes.isEmpty()) {
            System.out.println("No shapes available for analysis.\n");
            return;
        }

        Shape3D largestVolume = shapes.stream()
                .max(Comparator.comparingDouble(Shape3D::getVolume))
                .orElseThrow();

        Shape3D largestSurfaceArea = shapes.stream()
                .max(Comparator.comparingDouble(Shape3D::getSurfaceArea))
                .orElseThrow();

        Shape3D mostEfficient = shapes.stream()
                .max(Comparator.comparingDouble(shape -> shape.getVolume() / shape.getSurfaceArea()))
                .orElseThrow();

        System.out.println("\nAnalysis Results:");
        System.out.printf("- Largest Volume: %s (%.2f)%n",
                largestVolume.getName(), largestVolume.getVolume());

        System.out.printf("- Largest Surface Area: %s (%.2f)%n",
                largestSurfaceArea.getName(), largestSurfaceArea.getSurfaceArea());

        System.out.printf("- Most Efficient Volume/Surface Ratio: %s (%.2f)%n%n",
                mostEfficient.getName(),
                mostEfficient.getVolume() / mostEfficient.getSurfaceArea());
    }

    private static void addCustomShape(List<Shape3D> shapes) {
        System.out.println("""
                
                Choose a shape to create:
                1. Sphere
                2. Cube
                3. Cylinder
                4. Rectangular Prism
                5. Cone
                """);

        int choice = readInt("Enter shape type: ");
        String color = readString("Enter color: ");

        try {
            Shape3D shape;

            switch (choice) {
                case 1 -> {
                    double radius = readDouble("Enter radius: ");
                    shape = new Sphere(color, radius);
                }
                case 2 -> {
                    double sideLength = readDouble("Enter side length: ");
                    shape = new Cube(color, sideLength);
                }
                case 3 -> {
                    double radius = readDouble("Enter radius: ");
                    double height = readDouble("Enter height: ");
                    shape = new Cylinder(color, radius, height);
                }
                case 4 -> {
                    double length = readDouble("Enter length: ");
                    double width = readDouble("Enter width: ");
                    double height = readDouble("Enter height: ");
                    shape = new RectangularPrism(color, length, width, height);
                }
                case 5 -> {
                    double radius = readDouble("Enter radius: ");
                    double height = readDouble("Enter height: ");
                    shape = new Cone(color, radius, height);
                }
                default -> {
                    System.out.println("Invalid shape type.\n");
                    return;
                }
            }

            shapes.add(shape);
            System.out.println("Shape created successfully.\n");

        } catch (IllegalArgumentException exception) {
            System.out.println("Error creating shape: " + exception.getMessage() + "\n");
        }
    }

    private static void performanceTest(List<Shape3D> shapes) {
        if (shapes.isEmpty()) {
            System.out.println("No shapes available for performance testing.\n");
            return;
        }

        long startTime = System.nanoTime();

        double totalVolume = 0;
        double totalSurfaceArea = 0;

        for (int i = 0; i < 1_000_000; i++) {
            for (Shape3D shape : shapes) {
                totalVolume += shape.getVolume();
                totalSurfaceArea += shape.getSurfaceArea();
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("\nPerformance Timing Results:");
        System.out.printf("- Total Volume Calculated: %.2f%n", totalVolume);
        System.out.printf("- Total Surface Area Calculated: %.2f%n", totalSurfaceArea);
        System.out.printf("- Calculation Time: %,d nanoseconds%n", duration);
        System.out.printf("- Calculation Time: %.4f milliseconds%n%n", duration / 1_000_000.0);
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine());

                if (value <= 0) {
                    System.out.println("Value must be greater than zero.");
                    continue;
                }

                return value;
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static String readString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine();

            if (value == null || value.isBlank()) {
                System.out.println("Input cannot be blank.");
                continue;
            }

            return value;
        }
    }
}