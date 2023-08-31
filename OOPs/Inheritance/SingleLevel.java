package OOPs.Inheritance;

class Vehicle {

    public void startEngine() {
        System.out.println("Starting engine...");
    }

    public void stopEngine() {
        System.out.println("Stopping engine...");
    }
}

class Car extends Vehicle {

    public void accelerate() {
        System.out.println("Car is accelerating...");
    }
}

class SingleLevel {

    public static void main(String[] args) {
        Car car = new Car();
        car.startEngine();
        car.accelerate();
        car.stopEngine();
    }
}
