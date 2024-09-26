class GraphicsEditor {
    static abstract class Shape {
        public abstract String getName();
    }
    static class Circle extends Shape {
        @Override
        public String getName() {
            return "Circle";
        }
    }
    static class Quad extends Shape {
        @Override
        public String getName() {
            return "Quad";
        }
    }
    static class Triangle extends Shape {
        @Override
        public String getName() {
            return "Triangle";
        }
    }
    static class Rectangle extends Shape {
        @Override
        public String getName() {
            return "Rectangle";
        }
    }
    static class Ellipse extends Shape {
        @Override
        public String getName() {
            return "Ellipse";
        }
    }
    static class ShapePrinter {
        public void printShapeName(Shape shape) {
            System.out.println("This shape is: " + shape.getName());
        }
    }
    static class GraphicsEditorTest {
        public static void main(String[] args) {
            Shape circle = new Circle();
            Shape quad = new Quad();
            Shape triangle = new Triangle();
            Shape rectangle = new Rectangle();
            Shape ellipse = new Ellipse();

            ShapePrinter printer = new ShapePrinter();

            printer.printShapeName(circle);
            printer.printShapeName(quad);
            printer.printShapeName(triangle);
            printer.printShapeName(rectangle);
            printer.printShapeName(ellipse);
        }
    }
}