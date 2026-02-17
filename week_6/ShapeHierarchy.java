package week_6;
import java.text.DecimalFormat;

public class ShapeHierarchy {
	
	public static void main(String[] args) {
		// Here we create our objects along with arguments
		Shape circle = new Circle(5);
		Shape rectangle = new Rectangle(5, 10); 
		Shape triangle = new Triangle(6, 4, 3, 3);	
		
		// Display all shape info
		circle.displayShapeInfo();
		rectangle.displayShapeInfo();
		triangle.displayShapeInfo();
	}
}

abstract class Shape {
	// Formatting just for cleaner outputs
	static final DecimalFormat df = new DecimalFormat("0.##");
	// Abstract methods so every subclasses must have them as well
	abstract double calculateArea();
	abstract double calculatePerimeter();
	abstract void displayShapeInfo();
}

// Circle class
class Circle extends Shape {
	final double pi = Math.PI;
	double radius;

	Circle (double radius) {
		this.radius = radius;
	}
	double calculateArea() {
		return pi * radius * radius;
	}
	double calculatePerimeter() {
		return 2 * pi * radius;
	}
	void displayShapeInfo() {
		double area = calculateArea(), circumference = calculatePerimeter();
		System.out.println("Circle: Radius = " + df.format(radius) +
        ", Area = " + df.format(area) +
        ", Circumference = " + df.format(circumference));
	}
}

// Rectangle class
class Rectangle extends Shape {
	double width, length;
	Rectangle (double width, double length) {
		this.width = width;
		this.length = length;
	}
	double calculateArea() {
		return width * length;
	}
	double calculatePerimeter() {
		return 2 * (width + length);
	}
	void displayShapeInfo() {
		double area = calculateArea(), perimeter = calculatePerimeter();
		System.out.printf("Rectangle: Length = " + df.format(length) +
        ", Width = " + df.format(width) +
        ", Area = %.2f"  +
        ", Perimeter = %.2f\n", area, perimeter);
	}
}
// Triangle class
class Triangle extends Shape {
	double base, height, sideA, sideB;
	
	// I added 2 more parameters because it's necessary for calculating the perimeter
	Triangle (double base, double height, double sideA, double sideB) {
		this.base = base;
		this.height = height;
		this.sideA = sideA;
		this.sideB = sideB;
	}
	double calculateArea() {
		return 0.5 * base * height;
	}
	double calculatePerimeter() {
		return sideA + sideB + base;
	}
	void displayShapeInfo() {
		double area = calculateArea(), perimeter = calculatePerimeter();
		System.out.printf("Triangle: Base = " + df.format(base) +
        ", Height = " + df.format(height) +
        ", SideA = " + df.format(sideA) +
        ", SideB = " + df.format(sideB) +
        ", Area = %.2f" +
        ", Perimeter = %.2f\n", area, perimeter);
	}
}