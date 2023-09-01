package Thread;

class ThreadSleep1 extends Thread {

    @Override
    public void run() {

        for (int i = 1; i < 6; i++) {
            try {
                // thread will sleep for 1000ms
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ThreadSleep1 t1 = new ThreadSleep1();
        ThreadSleep1 t2 = new ThreadSleep1();
        t1.start();
        t2.start();
    }
}
