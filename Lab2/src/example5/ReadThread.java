package example5;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class ReadThread extends Thread{

    private PipedInputStream pi;
    ReadThread(){
        pi = new PipedInputStream();
    }
    public void run(){
        try{
            while (true){
                if(pi.available()>0){
                    System.out.println("Read Threaad is received: " +pi.read());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    void connect(PipedOutputStream os) throws Exception{
        pi.connect(os);
    }
}
