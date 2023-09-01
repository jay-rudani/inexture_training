package Thread;

class JoinExample extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(300);
                System.out.println("the current thread name is : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}

class ThreadJoin1 {
    public static void main(String[] args) {
        JoinExample t1 = new JoinExample();
        JoinExample t2 = new JoinExample();
        JoinExample t3 = new JoinExample();

        t1.start();
        try {
            System.out.println("the current thread name is : " + Thread.currentThread().getName());
            t1.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        t2.start();
        try {
            System.out.println("the current thread name is : " + Thread.currentThread().getName());
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        t3.start();
    }
}
