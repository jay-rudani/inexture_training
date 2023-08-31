package OOPs.Abstraction;

interface Shape {

    double area();

    // this can be overridden
    default void display() {
        System.out.println("Inside interface : default display() method");
    }

    static void show() {
        System.out.println("Inside interface : static show() method");
    }
}

class Rectangle implements Shape {

    private double height, width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double area() {
        return width * height;
    }

}

class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void display() {
        System.out.println("Inside display() of circle");
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

}

class InterfaceDemo {

    public static void main(String[] args) {
        Circle circle = new Circle(2);
        circle.display();
        System.out.println("area of circle : " + circle.area());

        Rectangle rectangle = new Rectangle(10, 11);
        rectangle.display();
        System.out.println("area of rectangle : " + rectangle.area());
    }
}
