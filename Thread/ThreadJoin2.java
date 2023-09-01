package Thread;

class JoinExample1 extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(i);
        }
    }
}

class ThreadJoin2 {

    public static void main(String[] args) {
        JoinExample1 t1 = new JoinExample1();
        JoinExample1 t2 = new JoinExample1();
        JoinExample1 t3 = new JoinExample1();

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        t2.start();
        t3.start();
    }
}
