package Lab7_App3;

import java.util.concurrent.CountDownLatch;

public class S_Fir extends Thread{

    CountDownLatch cd;
    Object lock;
    int delay;
    int []a = new int[2];
    S_Fir(Object o, CountDownLatch cd, int delay, int a_min, int a_max){
        this.lock = o; this.cd = cd; this.delay = delay;
        this.a[0] = a_min; this.a[1] = a_max;
    }


    public void run(){
        System.out.println(this.getName() + " StartingThread state 1.");


            try {
                Thread.sleep(300 * delay);
                System.out.println(this.getName() + " StartingThread state 2.");

                int k = (int) Math.round(Math.random() * (a[1] - a[0]) + a[0]);
                for (int i = 0; i < k * 1000; i++) {
                    i++;
                    i--;
                }
                synchronized (lock1) {
                this.lock1.notifyAll();
                }
                synchronized (lock2) {
                    this.lock2.notifyAll();
                }
                System.out.println(this.getName() + " StartingThread state 3.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cd.countDown();
        try {
            cd.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
