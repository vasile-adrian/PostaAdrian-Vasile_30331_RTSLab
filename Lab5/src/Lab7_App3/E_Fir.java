package Lab7_App3;

import java.util.concurrent.CountDownLatch;

public class E_Fir extends Thread{

    Object o;
    CountDownLatch cd;
    int delay;
    int []a = new int[2];
    E_Fir(Object o, CountDownLatch cd, int delay, int a0, int a1){
        this.o = o; this.cd = cd; this.delay = delay;
        this.a[0] = a0; this.a[1] = a1;
    }

    public void run(){
        System.out.println(this.getName() + " ExecutionThread state 1.");

            try {
                Thread.sleep(300*delay);
                synchronized (this.o){
                    this.o.wait();
                }
                System.out.println(this.getName() + " ExecutionThread state 2.");
                int k = (int) Math.round(Math.random()*(a[1]-a[0]) + a[0]);
                for (int i = 0; i<k*1000; i++){ i++; i--; }
                System.out.println(this.getName() + " ExecutionThread state 3.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
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
