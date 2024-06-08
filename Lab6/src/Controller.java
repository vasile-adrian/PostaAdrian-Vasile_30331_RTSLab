import java.util.Scanner;

public class Controller extends Thread{

    boolean stop = false;
    public Robot robot;
    PlaceHandler PH = new PlaceHandler();
    Supervisor supervisor;

    Controller_Transition_t_1 t_1;
    Controller_Transition_t_2 t_2;
    Controller_Transition_t_o1 t_o1;

    Controller_Transition_t_o2 t_o2;


    Scanner in = new Scanner(System.in);

    public void run(){
        PH.AddPlace(new IntPlace("p_i1",null));
        PH.AddPlace(new IntPlace("p_1",0));
        PH.AddPlace(new IntPlace("p_o1",null));
        PH.AddPlace(new IntPlace("p_2",null));
        PH.AddPlace(new IntPlace("p_i2",null));

        t_1 = new Controller_Transition_t_1("t_1",PH,0);
        t_2 = new Controller_Transition_t_2("t_2",PH,0);
        t_o1 = new Controller_Transition_t_o1("t_o1",PH,0);
        t_o2 = new Controller_Transition_t_o2("t_o2",PH,0);


        t_o2.RobotPH = robot.PH;

        t_o1.SupervisorPH = supervisor.PH;

        while(!stop){
            t_1.TransitionGuardsMappings();
            t_2.TransitionGuardsMappings();
            t_o2.TransitionGuardsMappings();
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
