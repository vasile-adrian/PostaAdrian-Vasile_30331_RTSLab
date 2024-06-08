package Ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Fir extends Thread{

    List<Integer> list = new ArrayList<Integer>();
    int sleepTime;
    Exchanger<List<Integer>> exchanger;
    String name;

    Fir(int sT, Exchanger<List<Integer>> exchanger, String name){
        this.exchanger = exchanger;
        this.name = name;
        this.sleepTime = sT;
    }

    public void displayList(){
        //displays the list of the current thread
        for(int i = 0; i<this.list.size(); i++){
            System.out.println(this.list.get(i));
        }
    }

    public void run(){
        int noElem = (int)Math.round(Math.random() * 3 + 1);
        for( int i = 0; i<noElem; i++){
            int elem = (int)Math.round(Math.random() * 100);
            list.add(new Integer(elem));
        }
        this.displayList();
        try{
            Thread.sleep(this.sleepTime);
            this.list = exchanger.exchange(this.list);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        this.displayList();
    }

}
