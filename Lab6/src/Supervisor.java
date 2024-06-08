

import java.util.ArrayList;
import java.util.Scanner;

public class Supervisor extends Thread{
    boolean stop = false;
    PlaceHandler PH = new PlaceHandler();
    public Controller controller;
    Scanner in = new Scanner(System.in);


    Supervisor_Transition_ts_1 ts_1;
    Supervisor_Transition_ts_2 ts_2;
    Supervisor_Transition_ts_3 ts_3;

    public void run(){
        PH.AddPlace(new UserPlace("ps_i1",null));
        PH.AddPlace(new ListUserPlace("ps_1",new ArrayList<InputUser>()));
        PH.AddPlace(new IntPlace("ps_2",0));
        PH.AddPlace(new IntPlace("ps_o1",null));
        PH.AddPlace(new IntPlace("ps_3",0));
        PH.AddPlace(new IntPlace("ps_o2",null));
        PH.AddPlace(new IntPlace("ps_i2",null));

        ts_1 = new Supervisor_Transition_ts_1("ts_1",PH,0);
        ts_2 = new Supervisor_Transition_ts_2("ts_2",PH,0);
        ts_3 = new Supervisor_Transition_ts_3("ts_3",PH,0);
        ts_2.ControllerPH=controller.PH;

        System.out.println("Supervisor: Input ps_i1.r:");
        Integer R = in.nextInt();
        System.out.println("Supervisor: Input ps_i1.e:");
        Integer E = in.nextInt();
        System.out.println("Supervisor: Input ps_i1.l:");
        Integer L = in.nextInt();

        InputUser input = new InputUser(R, E, L);
        this.PH.GetPlaceByName("ps_i1").Set(input);

        while(!stop){
            ts_1.TransitionGuardsMappings();
            ts_2.TransitionGuardsMappings();
            ts_3.TransitionGuardsMappings();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }







    }

}
