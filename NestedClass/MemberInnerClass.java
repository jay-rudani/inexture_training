package NestedClass;

class MemberInnerClass {

    static int a = 10;
    int b = 20;
    private int c = 30;
    protected int d = 40;

    public class InnerClass {
        void display() {
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);
        }
    }

    public static void main(String[] args) {
        MemberInnerClass memberInnerClassObj = new MemberInnerClass();
        InnerClass innerClassObj = memberInnerClassObj.new InnerClass();
        innerClassObj.display();
    }

}
