

public class Robot extends Thread {
    boolean stop = false;
    PlaceHandler PH = new PlaceHandler();

    public Controller controller;

    Robot_Transition_t_1 t_1;
    Robot_Transition_t_2 t_2;

    public void run(){
        PH.AddPlace(new IntPlace("p_0",0));
        PH.AddPlace(new IntPlace("p_i",0));
        PH.AddPlace(new IntPlace("p_1",0));
        PH.AddPlace(new IntPlace("p_o",0));

        t_1 = new Robot_Transition_t_1("t_1",PH,0);
        t_2 = new Robot_Transition_t_2("t_2",PH,5);
        t_2.ControllerPH = controller.PH;

        while(!stop){
            t_1.TransitionGuardsMappings();
            t_2.TransitionGuardsMappings();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void StopThread(){
        this.stop = true;
    }
}
