package Ex2;

import java.util.concurrent.CountDownLatch;

public class Fir extends Thread{

    CountDownLatch cdl;
    public Fir(CountDownLatch cdl){
        this.cdl = cdl;
    }

    public void run(){
        while(true){
            activitate1();
            cdl.countDown();
            try{
                cdl.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            activitate2();
        }
    }

    private void activitate1(){
        System.out.println(this.getName() + "> activitate1");
        try{
            Thread.sleep(Math.round(Math.random() * 3 + 4) * 1000 );
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void activitate2(){
        System.out.println(this.getName() + "> activitate2");
        try{
            Thread.sleep(Math.round(Math.random() * 4 + 3) * 1000 );
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
