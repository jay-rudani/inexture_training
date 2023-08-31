package NestedClass;

class AnonymousInnerClass {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("Thread is running");
            }
        };

        Thread t1 = new Thread(runnable);
        t1.start();
    }
}
