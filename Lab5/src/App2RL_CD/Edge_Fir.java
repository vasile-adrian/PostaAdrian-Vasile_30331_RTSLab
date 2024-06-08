package App2RL_CD;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class Edge_Fir extends Thread{
    Lock l;
    CountDownLatch cd;
    int []a = new int[2];
    int delay;
    Edge_Fir(Lock l, CountDownLatch cd, int delay, int a0, int a1){
        this.l = l; this.cd = cd; this.delay = delay;
        this.a[0] = a0; this.a[1] = a1;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " - Edge - State 1");
        l.lock();
        System.out.println(this.getName() + " - Edge - State 2");
        int k = (int) Math.round(Math.random()*(a[1]-a[0]) + a[0]);
        for(int i=0;i<1000*k;i++){ i++; i--; }
        try{
            Thread.sleep(delay*300);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        l.unlock();
        System.out.println(this.getName() + " - Edge - State 3");
        this.cd.countDown();
        try {
            this.cd.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
