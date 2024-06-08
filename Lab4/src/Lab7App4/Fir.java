package Lab7App4;

import java.util.Objects;
import java.util.concurrent.Semaphore;

public class Fir extends Thread{

    Semaphore s;
    int name, a[] = new int[2], delay;

    Fir(Semaphore s, int name, int delay, int a1, int a2){
        this.s = s; this.name = name; this.delay = delay;
        this.a[0] = a1; this.a[1] = a2;
    }

    public void run(){
        while(true){
            System.out.println("Thread " + name + " STATE 1");
            try {
                this.s.acquire(1);
                int k = (int) Math.round(Math.random()*(a[1] - a[0])+a[0]);
                for(int i=0;i<k*10000;i++){ i++; i--; }
                this.s.release(1);
                System.out.println("Thread " + name + " STATE 2");
                Thread.sleep(delay*300);
                System.out.println("Thread " + name + " STATE 3");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
