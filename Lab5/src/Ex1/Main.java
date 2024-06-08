package Ex1;

import java.util.concurrent.CyclicBarrier;

public class Main {

    public static void main(String []args){
        CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("Barrier Routine");
            }
        });

        Fir f1 = new Fir(cb);
        Fir f2 = new Fir(cb);
        Fir f3 = new Fir(cb);
        f1.start();
        f2.start();
        f3.start();
    }

}
