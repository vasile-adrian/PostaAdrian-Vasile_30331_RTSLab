package App2RL_CD;

import App1Lock.FirE;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GFir extends Thread{

    CountDownLatch cd;
    Lock l1,l2;

    GFir(){
        l1 = new ReentrantLock();
        l2 = new ReentrantLock();
    }

    public void run(){
        while (true) {
            cd = new CountDownLatch(3);
            Edge_Fir f1 = new Edge_Fir(l1, cd, 4, 2, 4);
            Edge_Fir f2 = new Edge_Fir(l2, cd, 5, 2, 5);
            Center_Fir cf = new Center_Fir(l1, l2, cd, 3, 6, 3);
            System.out.println(this.getName() + " Generating thread start");
            f1.start();
            f2.start();
            cf.start();
            try {
                cd.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
