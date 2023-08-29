package MethodChainingAndCategory;

class MethodChainingAndCategory {

    public void noArgNoReturnType() {
        System.out.println("No arg no return type");
    }

    public void withArgNoReturnType(String msg) {
        System.out.println("with arg no return type : " + msg);
    }

    public String noArgWithReturnType() {
        return "Hello";
    }

    public int withArgWithReturnType(int x) {
        return x;
    }

    public static void main(String[] args) {
        String obj1 = new MethodChainingAndCategory()
                .noArgWithReturnType();
        int obj2 = new MethodChainingAndCategory()
                .withArgWithReturnType(8);

        System.out.println(obj1);
        System.out.println(obj2);

        MethodChainingAndCategory obj3 = new MethodChainingAndCategory();
        obj3.noArgNoReturnType();
        obj3.withArgNoReturnType("World");
    }
}
