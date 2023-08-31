package Constructor;

class Rectangle {

    int height, width;

    Rectangle() {
        height = 0;
        width = 0;
    }

    Rectangle(int w, int h) {
        height = h;
        width = w;
    }

    Rectangle(int side) {
        height = side;
        width = side;
    }

    public static void main(String[] args) {
        Rectangle deftRect = new Rectangle();
        Rectangle customRect = new Rectangle(100, 80);
        Rectangle square = new Rectangle(10);

        System.out.println("Default Rectangle : " + deftRect.width + "x" + deftRect.height);
        System.out.println("Custom Rectangle : " + customRect.width + "x" + customRect.height);
        System.out.println("Square : " + square.width + "x" + square.height);

    }
}
