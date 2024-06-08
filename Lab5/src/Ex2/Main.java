package Ex2;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args){
        CountDownLatch cdl = new CountDownLatch(4); // this count blocks the execution because the await method will
        // block the threads until the counter reaches zero and with 3 threads decrementing it, it will never reach
        // zero before each thread calls await.
        Fir f1 = new Fir(cdl);
        Fir f2 = new Fir(cdl);
        Fir f3 = new Fir(cdl);
        f1.start();
        f2.start();
        f3.start();
    }

}
