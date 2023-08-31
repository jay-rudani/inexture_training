package Blocks;

// it is a block which is executed when the class is loaded into memory, before any instance of that class is
// created or any static member is accessed.
class StaticBlock {

    static int staticVariable;

    static {
        staticVariable = 10;
        System.out.println("Static block is executed");
    }

    public static void main(String[] args) {
        System.out.println("Value of staticVariable : " + staticVariable);
    }
}
