AI GENERATION DOCUMENTATION
AI Tool Used: [ChatGPT 5.5]
Generation Date: [14 May 2025]

Original Prompt:

ROLE:
You are an expert Java software engineer, object-oriented programming instructor, and AI-assisted development specialist.

ROLE:
You are an expert Java software engineer, object-oriented programming instructor, and AI-assisted development specialist.

TASK:
Create an abstract Java class named Shape3D.

Requirements:
- Package: com.csc205.project2.shapes
- Implements the ThreeDimensionalShape interface
- Fields:
  - private String name
  - private String color
- Include:
  - Constructors
  - Getters and setters
  - Input validation
  - JavaDoc comments
  - A formatted toString() method

Methods:
- public double getVolume()
  - Must call calculateVolume()
- public double getSurfaceArea()
  - Must call calculateSurfaceArea()

Abstract methods:
- protected abstract double calculateVolume()
- protected abstract double calculateSurfaceArea()

Use encapsulation, inheritance, abstraction, and professional Java naming conventions.

CONSTRAINTS
- Follow Java naming conventions
- Include complete JavaDoc comments
- Use encapsulation properly
- Ensure the class is reusable and extensible
- Use Java naming conventions
- Apply encapsulation
- Follow SOLID principles where appropriate
- Use meaningful variable and method names

---
 Follow-up Prompts (if any):
  1. "[ROLE:
You are an expert Java software engineer, object-oriented programming instructor, and AI-assisted development specialist.

TASK:
Create five concrete Java classes named Sphere, Cube, Cylinder, RectangularPrism, Cone

Create a concrete Java class named Sphere.
Requirements:
- Package: com.csc205.project2.shapes
- Extends Shape3D
- Field:
  - private double radius
- Include:
  - Constructor
  - Getter and setter for radius
  - Validation for radius
  - JavaDoc comments
  - Overridden toString()

Implement:
- calculateVolume()
  - Formula: (4.0 / 3.0) * Math.PI * Math.pow(radius, 3)
- calculateSurfaceArea()
  - Formula: 4 * Math.PI * Math.pow(radius, 2)

Create a concrete Java class named Cube.

Requirements:
- Package: com.csc205.project2.shapes
- Extends Shape3D
- Field:
  - private double sideLength
- Include:
  - Constructor
  - Getter and setter for sideLength
  - Validation for sideLength
  - JavaDoc comments
  - Overridden toString()

Implement:
- calculateVolume()
  - Formula: Math.pow(sideLength, 3)
- calculateSurfaceArea()
  - Formula: 6 * Math.pow(sideLength, 2)

Create a concrete Java class named Cylinder.

Requirements:
- Package: com.csc205.project2.shapes
- Extends Shape3D
- Fields:
  - private double radius
  - private double height
- Include:
  - Constructor
  - Getters and setters
  - Validation for radius and height
  - JavaDoc comments
  - Overridden toString()

Implement:
- calculateVolume()
  - Formula: Math.PI * Math.pow(radius, 2) * height
- calculateSurfaceArea()
  - Formula: 2 * Math.PI * radius * (radius + height)

Create a concrete Java class named RectangularPrism.

Requirements:
- Package: com.csc205.project2.shapes
- Extends Shape3D
- Fields:
  - private double length
  - private double width
  - private double height
- Include:
  - Constructor
  - Getters and setters
  - Validation for all dimensions
  - JavaDoc comments
  - Overridden toString()

Implement:
- calculateVolume()
  - Formula: length * width * height
- calculateSurfaceArea()
  - Formula: 2 * (length * width + length * height + width * height)

Create a concrete Java class named Cone.

Requirements:
- Package: com.csc205.project2.shapes
- Extends Shape3D
- Fields:
  - private double radius
  - private double height
- Include:
  - Constructor
  - Getters and setters
  - Validation for radius and height
  - JavaDoc comments
  - Overridden toString()

Implement:
- calculateVolume()
  - Formula: (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height
- calculateSurfaceArea()
  - Formula: Math.PI * radius * (radius + Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2)))]"
  
  
2. "[Create a Java class named ShapeFactory.

Requirements:
- Package: com.csc205.project2.shapes
- Use the Factory Pattern
- Provide a static create method
- Allow creation of:
  - Sphere
  - Cube
  - Cylinder
  - RectangularPrism
  - Cone

Requirements:
- Handle invalid shape types
- Validate incorrect dimension counts
- Throw meaningful exceptions
- Include JavaDoc comments

Example:
Shape3D shape = ShapeFactory.create(Sphere.class, "Red Ball", "Red", 5.0);]"

3. "[Create a Java class named ShapeDriver.

Requirements:
- Package: com.csc205.project2
- Demonstrate polymorphism using Shape3D references
- Store multiple shapes in:
  - Arrays
  - ArrayLists
  - Collections

Program must:
- Create several sample shapes
- Display each shape’s information
- Display surface area and volume
- Determine:
  - Shape with largest volume
  - Shape with largest surface area
  - Shape with best volume-to-surface-area ratio

Optional:
- Use Stream API
- Sort shapes
- Format output professionally]"

4. "[Create JUnit 5 tests for each class:]"

Classes to test:
- SphereTest
- CubeTest
- CylinderTest
- RectangularPrismTest
- ConeTest
- ShapeFactoryTest

Test categories:
1. Constructor tests
2. Getter and setter tests
3. Volume calculation tests
4. Surface area calculation tests
5. Negative input validation tests
6. Zero-value boundary tests
7. Polymorphism tests using Shape3D references
8. Factory creation tests

Use assertEquals with a delta for decimal comparisons.
Use assertThrows for invalid input.]"

