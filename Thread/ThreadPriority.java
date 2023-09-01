package Thread;

class ThreadPriority extends Thread {

    @Override
    public void run() {
        System.out.println("inside run() method");
    }

    public static void main(String[] args) {
        ThreadPriority t1 = new ThreadPriority();
        ThreadPriority t2 = new ThreadPriority();
        ThreadPriority t3 = new ThreadPriority();

        System.out.println("t1 priority : " + t1.getPriority());
        System.out.println("t2 priority : " + t2.getPriority());
        System.out.println("t3 priority : " + t3.getPriority());

        t1.setPriority(6);
        t2.setPriority(3);
        t3.setPriority(9);

        System.out.println("t1 priority : " + t1.getPriority());
        System.out.println("t2 priority : " + t2.getPriority());
        System.out.println("t3 priority : " + t3.getPriority());

        System.out.println("Currently executing thread : " + Thread.currentThread().getName());
        System.out.println("Priority of the main thread : " + Thread.currentThread().getPriority());

        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println("Priority of the main thread : " + Thread.currentThread().getPriority());
    }
}
