package Exercise1;

import java.util.Observable;

public class Model extends Observable {

    private int[] progressValue;
    public Model(int nbThreads) { progressValue = new int[nbThreads]; }

    public void setProgressValues(int id, int val){
        if(id >= 0 && id < progressValue.length){
            progressValue[id] = val;
            setChanged();
            notifyObservers(id);
        }
    }

    public int getProgressValue(int id){
        if(id >= 0 && id < progressValue.length){
            return progressValue[id];
        }
        return 0;
    }

}
