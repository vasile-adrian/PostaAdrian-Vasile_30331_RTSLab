package App1Semaphore;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class FirS extends Thread{

    Semaphore s;
    CyclicBarrier cb;
    FirS(){
        s = new Semaphore(2);
        cb = new CyclicBarrier(3,new Runnable(){
            public void run(){
                System.out.println("Join routine implemented with barrier.");
            }
        });
    }

    public void run(){

        while(true) {
            FirE f1 = new FirE(this.cb,this.s, 4, 2, 4, 4,6);
            FirE f2 = new FirE(this.cb,this.s, 5, 3, 5, 5,7);
            System.out.println(this.getName() + " Generating thread start:");
            f1.start();
            f2.start();
            try{
                cb.await();
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
