package App1Lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FirS extends Thread{
    CyclicBarrier cb;
    Lock l1, l2;

    FirS(){
        l1 = new ReentrantLock();
        l2 = new ReentrantLock();
        cb = new CyclicBarrier(3);
    }

    public void run(){
        while (true) {
            FirE f1 = new FirE(cb, l1, l2, 4,2,4,4,6);
            FirE f2 = new FirE(cb, l2, l1, 5,3,5,5,7);
            System.out.println(this.getName() + " Generating thread start");
            f1.start();
            f2.start();
            try {
                cb.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
