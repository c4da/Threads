public class Main {
    public static void main(String[] args) {

        System.out.println("Hello from main thread!");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();
        new Thread(){
            @Override
            public void run() {
                System.out.println("Hello from the anonymous");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println("Hello from the anonymous class myRunnable");
                try {
                    anotherThread.join();
                    System.out.println("AnotherThread terminated, so Im running again");
                } catch (InterruptedException e) {
                    System.out.println("I couldnt wait I was interrupted");
                }
            }
        });
        myRunnableThread.start();
//        anotherThread.interrupt();

        System.out.println("Hello again from my thread.");
    }
}