package Exercise1;

public class Controller {

    private Model model;
    private Window window;

    public Controller(Model model, Window window){
        this.model = model;
        this.window = window;
        this.model.addObserver(this.window);
    }

    public void setProgressValue(int id, int val){
        model.setProgressValues(id, val);
    }

}
