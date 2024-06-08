package Lab7App4;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args){
        Semaphore s = new Semaphore(2);
        Fir f1, f2, f3;
        f1 = new Fir(s,1,5,3,6);
        f2 = new Fir(s,2,3,4,7);
        f3 = new Fir(s,3,6,5,7);
        f1.start();
        f2.start();
        f3.start();
    }

}
