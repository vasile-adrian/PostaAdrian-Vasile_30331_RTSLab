package App1Lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;

public class FirE extends Thread{

    Lock l1 ,l2;
    CyclicBarrier cb;
    int a[] = new int[4];
    int delay;

    public FirE(CyclicBarrier cb, Lock l1, Lock l2, int delay, int a0, int a1, int a2, int a3){
        this.cb = cb; this.l1 = l1; this.l2 = l2; this.delay = delay;
        this.a[0] = a0; this.a[1] = a1; this.a[2] = a2; this.a[3] = a3;
    }

    public void run(){
        System.out.println(this.getName() + " State 1");
        int k = (int) Math.round(Math.random()*(a[1]-a[0]) + a[0]);
        for(int i=0;i<1000*k;i++) { i++; i--;}
        System.out.println(this.getName() + " State 2");
        try{
            l1.lock();
            k = (int) Math.round(Math.random()*(a[3]-a[2]) + a[2]);
            for(int i=0;i<1000*k;i++) { i++; i--;}
            if(this.l2.tryLock()) {
                try{
                    this.l2.lock();
                    System.out.println("Fir " + " State 3");
                    Thread.sleep(300 * delay);
                }catch (InterruptedException e){
                    throw new InterruptedException();
                }
                l1.unlock();
                l2.unlock();
            }
            else {
                l1.unlock();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Fir " + " State 4");
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
