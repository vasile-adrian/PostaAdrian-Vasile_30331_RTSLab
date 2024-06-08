package Lab4App2Lock;

import java.util.concurrent.locks.Lock;

public class Fir extends Thread {

    Lock l1, l2;
    int []a = new int[4];
    int name, delay;
    Fir(int name, Lock l1, Lock l2, int a1, int a2, int a3, int a4, int delay){
        this.name = name; this.l1 = l1; this.l2 = l2; this.delay = delay;
        a[0] = a1; a[1] = a2; a[2] = a3; a[3] = a4;
    }

    public void run(){
        System.out.println("Fir " + name + " State 1");
        int k = (int) Math.round(Math.random()*(a[1] - a[0])+a[0]);
        for( int i=0; i < k*10000; i++){ i++; i--; }
        try {
            this.l1.lock();
            System.out.println("Fir " + name + " State 2");
            k = (int) Math.round(Math.random() * (a[3] - a[2]) + a[2]);
            for (int i = 0; i < k * 10000; i++) {
                i++;i--;
            }
            if(this.l2.tryLock()) {
                try{
                    this.l2.lock();
                    System.out.println("Fir " + name + " State 3");
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
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Fir " + name + " State 4");
        }
    }
}
