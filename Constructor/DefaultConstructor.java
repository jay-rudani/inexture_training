package Constructor;

class DefaultConstructor {

    int x;

    public DefaultConstructor() {
        x = 10;
    }

    public static void main(String[] args) {
        System.out.println("Value of x : " + new DefaultConstructor().x);
    }
}
