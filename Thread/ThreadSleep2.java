package Thread;

class ThreadSleep2 {

    public static void main(String[] args) {

        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println(i);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
