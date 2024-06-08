package Lab7_App3;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String []args) throws InterruptedException {

        CountDownLatch cd = new CountDownLatch(3);
        Object lock = new Object();

        E_Fir e_fir1 = new E_Fir(lock,cd,7,3,5);
        E_Fir e_fir2 = new E_Fir(lock,cd,8,4,6);

        e_fir1.start();
        e_fir2.start();

        S_Fir s_fir = new S_Fir(lock,cd,7,2,3);
        s_fir.start();
    }
}
