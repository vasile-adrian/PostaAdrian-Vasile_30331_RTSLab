package App1;

import example1.FileService;
import example1.RThread;
import example1.WThread;

public class Main {
    private static boolean stopThreads = false;
    public static void main(String[] args){
        FileService service = new FileService("messages.txt");
        example1.RThread reader = new RThread(service);
        example1.WThread writer = new WThread(service);
        reader.start();
        writer.start();
    }
    public static boolean isStopThreads(){
        return stopThreads;
    }
}