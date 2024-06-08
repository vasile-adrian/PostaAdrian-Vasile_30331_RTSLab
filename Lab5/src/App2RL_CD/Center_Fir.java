package App2RL_CD;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class Center_Fir extends Thread{
    Lock l1, l2;
    CountDownLatch cd;
    int delay, a[] = new int[2];
    Center_Fir(Lock l1, Lock l2, CountDownLatch cd, int a0, int a1, int delay){
        this.l1 = l1; this.l2 = l2; this.delay = delay; this.cd = cd;
        this.a[0] = a0; this.a[1] = a1;
    }
    public void run(){
        System.out.println(this.getName() + " - Center - State 1");
        l1.lock();
        l2.lock();
        System.out.println(this.getName() + " - Center - State 2");
        int k = (int) Math.round(Math.random()*(a[1]-a[0]) + a[0]);
        for(int i=0;i<1000*k;i++){ i++; i--; }
        try {
            Thread.sleep(delay*300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        l1.unlock();
        l2.unlock();
        System.out.println(this.getName() + " - Center - State 3");
        this.cd.countDown();
        try {
            this.cd.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
