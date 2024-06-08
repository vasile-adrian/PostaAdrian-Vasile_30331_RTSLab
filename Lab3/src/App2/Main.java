package App2;

import java.util.Stack;

public class Main {

    public static void main(String[] args){
        Integer monitor1 = 1;
        Integer monitor2 = 2;
        Stack<Integer> monitors = new Stack<>();
        monitors.push(monitor1);
        monitors.push(monitor2);
        new ExecutionThreads(monitors, 4,2,4, 4, 6).start();
        new ExecutionThreads(monitors, 5, 3, 5, 5, 7).start();
    }

}
