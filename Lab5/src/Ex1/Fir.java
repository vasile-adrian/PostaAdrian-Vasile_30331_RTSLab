package Ex1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class Fir extends Thread{

    CyclicBarrier cb;
    public Fir(CyclicBarrier cb){
        this.cb = cb;
    }

    public void run(){
        while(true){
            activitate();
            try{
                cb.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }catch (BrokenBarrierException e){
                e.printStackTrace();
            }
            activitate();
        }
    }

    public void activitate(){
        System.out.println(this.getName() + "> activitate");
        try{
            Thread.sleep(Math.round(Math.random() * 3 + 3 ) *1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
