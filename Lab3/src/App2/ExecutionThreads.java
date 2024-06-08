package App2;

import java.util.Stack;

public class ExecutionThreads extends Thread {
    Stack<Integer> monitors;
    int sleep, activity1_min, activity1_max,activity2_min, activity2_max;
    public ExecutionThreads(Stack<Integer> monitors, int sleep, int activity1_min, int activity1_max, int activity2_min, int activity2_max){
        this.monitors = monitors;
        this.sleep = sleep;
        this.activity1_min = activity1_min;
        this.activity1_max = activity1_max;
        this.activity2_min = activity2_min;
        this.activity2_max = activity2_max;
    }

    public void run(){
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (activity1_max - activity1_min) + activity1_min);
        for (int i = 0; i < k*100000; i++){
            i++; i--;
        }

        synchronized (monitors.get(0)){
            System.out.println(this.getName() + " - STATE 2");
            k = (int) Math.round(Math.random() * (activity2_max - activity2_min) + activity2_min);
            for (int i = 0; i < k*100000; i++){
                i++; i--;
            }
            System.out.println(this.getName() + " - STATE 3");
            synchronized (monitors.get(1)){
                System.out.println(this.getName() + " - STATE 4");
                try{
                    Thread.sleep(sleep * 500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println(this.getName() + " - STATE 5");
    }
}
