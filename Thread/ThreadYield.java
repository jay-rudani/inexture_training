package Thread;

class YieldExample implements Runnable {

    private String name;

    public YieldExample(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " - Iteration " + i);
            Thread.yield();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadYield {

    public static void main(String[] args) {
        Thread t1 = new Thread(new YieldExample("Thread 1"));
        Thread t2 = new Thread(new YieldExample("Thread 2"));

        t1.start();
        t2.start();
    }
}
