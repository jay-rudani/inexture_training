package Blocks;

// it is a section of code defined within a class but outside any method or constructor
// it is executed when an instance of class is created, before the constructor is called
class InstanceBlock {

    InstanceBlock() {
        System.out.println("default constructor is executed");
    }

    {
        System.out.println("instance block is executed");
    }

    public static void main(String[] args) {
        new InstanceBlock();
    }
}
