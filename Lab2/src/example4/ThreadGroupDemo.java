package example4;

public class ThreadGroupDemo {
    public static void main(String args[]) throws Exception {
        ThreadGroup tg = new ThreadGroup("Group of threads");
        ThreadEx fir1 = new ThreadEx(tg, "ThreadEx #1");
        ThreadEx fir2 = new ThreadEx(tg, "ThreadEx #2");
        ThreadEx fir3 = new ThreadEx(tg, "ThreadEx #3");
        fir1.start();
        fir2.start();
        fir3.start();
        Thread.sleep(1000);
        System.out.println(tg.activeCount() + " Thread(s) in group: \"" + tg.getName() + "\".");
        Thread thrds[] = new Thread[tg.activeCount()];
        tg.enumerate(thrds);
        for (Thread t : thrds) {
            System.out.println(t.getName());
        }
        fir1.stopThread();
        Thread.sleep(1000);
        System.out.println(tg.activeCount() + " Thread(s) in group: \"" + tg.getName() + "\".");
        tg.interrupt();
    }
}