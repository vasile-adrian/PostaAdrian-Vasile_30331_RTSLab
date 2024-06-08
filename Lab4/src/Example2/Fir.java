package Example2;

import java.util.Objects;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

public class Fir extends Thread {
    int name, delay, k, permit;
    Semaphore s;
    Fir(int n, Semaphore sa, int delay, int k, int permit){
        this.name = n; this.s = sa; this.delay = delay; this.k = k; this.permit = permit;
    }
    public void run(){
        while(true){
            try {
                System.out.println("Fir " + name + " State 1");
                Thread.sleep(this.delay * 500);
                System.out.println("Fir " + name + " State 2");
                this.s.acquire(2);// critical region
                System.out.println("Fir " + name + " toolk a token from the semaphore");
                System.out.println("Fir " + name + " State 3");
                for(int i = 0; i< k*100000; i++){ i++; i--; }
                this.s.release(2);   // end of critical region
                System.out.println("Fir " + name + " released a token from the semaphore");
                System.out.println("Fir " + name + " State 4");
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
