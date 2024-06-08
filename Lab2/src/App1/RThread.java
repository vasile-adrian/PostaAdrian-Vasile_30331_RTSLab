package App1;

import example1.FileService;
import example1.Main;

public class RThread extends Thread{
    FileService service;
    public RThread(FileService service) {
        this.service = service;
    }
    public void run(){

        while (!Main.isStopThreads()){
            synchronized (service) {
                try {
                    String readMsg = service.read();
                    System.out.println(readMsg);
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}