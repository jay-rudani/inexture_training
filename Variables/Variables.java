package Variables;

class Variables {

    // instance variable
    int x = 10;

    // static variable
    static int y = 12;

    void xLocal() {
        // local variable
        int x = 11;
        System.out.println("Block var x : " + x);
    }

    public static void main(String[] args) {
        System.out.println("Static var y : " + y);
        Variables obj = new Variables();
        System.out.println("instance var x : " + obj.x);
        obj.xLocal();
    }
}
