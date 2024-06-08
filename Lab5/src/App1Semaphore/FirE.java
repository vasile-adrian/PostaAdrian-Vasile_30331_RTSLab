package App1Semaphore;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class FirE extends Thread{

    Semaphore s;
    CyclicBarrier cb;
    int a[] = new int[4];
    int delay;

    public FirE(CyclicBarrier cb, Semaphore s, int delay, int a0, int a1, int a2, int a3){
        this.cb = cb; this.s = s; this.delay = delay;
        this.a[0] = a0; this.a[1] = a1; this.a[2] = a2; this.a[3] = a3;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " State 1");
        int k = (int) Math.round(Math.random()*(a[1]-a[0]) + a[0]);
        for(int i=0;i<1000*k;i++) { i++; i--;}
        try {
            s.acquire(1);
            System.out.println(this.getName() + " State 2");
            k = (int) Math.round(Math.random()*(a[3]-a[2]) + a[2]);
            for(int i=0;i<1000*k;i++){ i++; i--; }
            if(s.availablePermits()<1) {
                s.release();
                s.acquire(2);
            }
            else{
                s.acquire(1);
            }
            System.out.println(this.getName() + " State 3");
            Thread.sleep(delay*300);
            System.out.println(this.getName() + " State 4");
            s.release(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            cb.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

    }
}
