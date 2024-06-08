package OER_TPN_LAB;

import Components.*;
import DataObjects.DataInteger;
import DataObjects.DataREL;
import DataObjects.DataRELQueue;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

import java.util.ArrayList;

public class Supervisor {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Supervisor Petri";
        pn.NetworkPort = 1082;

        //Places

        DataREL ps_i1 = new DataREL();
        ps_i1.SetName("ps_i1");
        pn.PlaceList.add(ps_i1);

        DataRELQueue ps_1 = new DataRELQueue();
        ps_1.SetName("ps_1");
        pn.PlaceList.add(ps_1);

        DataInteger ps_2 = new DataInteger();
        ps_2.SetName("ps_2");
        ps_2.SetValue(0);
        pn.PlaceList.add(ps_2);

        DataInteger ps_3 = new DataInteger();
        ps_3.SetName("ps_3");
        ps_3.SetValue(0);
        pn.PlaceList.add(ps_3);

        DataInteger ps_i2 = new DataInteger();
        ps_i2.SetName("ps_i2");
        pn.PlaceList.add(ps_i2);

        DataInteger ps_o2 = new DataInteger();
        ps_o2.SetName("ps_o2");
        pn.PlaceList.add(ps_o2);

        DataTransfer ps_o1 = new DataTransfer();
        ps_o1.SetName("ps_o1");
        ps_o1.Value = new TransferOperation("localhost","1080","p_i1");
        pn.PlaceList.add(ps_o1);


        // Transitions

        PetriTransition ts_1 = new PetriTransition(pn);
        ts_1.TransitionName = "ts_1";
        ts_1.InputPlaceName.add("ps_i1");
        ts_1.InputPlaceName.add("ps_1");

        Condition Ts1Ct1 = new Condition(ts_1,"ps_i1", TransitionCondition.NotNull);

        GuardMapping grdTs_1 = new GuardMapping();
        grdTs_1.condition = Ts1Ct1;

        grdTs_1.Activations.add(new Activation(ts_1,"ps_i1", TransitionOperation.AddElement,"ps_1"));

        ts_1.GuardMappingList.add(grdTs_1);

        ts_1.Delay = 0;
        pn.Transitions.add(ts_1);



        PetriTransition ts_2 = new PetriTransition(pn);
        ts_2.TransitionName = "ts_2";
        ts_2.InputPlaceName.add("ps_1");
        ts_2.InputPlaceName.add("ps_3");
        ts_2.InputPlaceName.add("ps_2");

        Condition Ts2Ct1 = new Condition(ts_2,"ps_1",TransitionCondition.HaveREL);
        Condition Ts2Ct2 = new Condition(ts_2,"ps_2",TransitionCondition.NotNull);
        Condition Ts2Ct3 = new Condition(ts_2,"ps_3",TransitionCondition.NotNull);

        Ts2Ct1.SetNextCondition(LogicConnector.AND,Ts2Ct2);
        Ts2Ct2.SetNextCondition(LogicConnector.AND,Ts2Ct3);

        GuardMapping grdTs_2 = new GuardMapping();
        grdTs_2.condition = Ts2Ct1;

        ArrayList<String> outputs = new ArrayList<>();
        outputs.add("ps_o1");
        outputs.add("ps_3");

        grdTs_2.Activations.add(new Activation(ts_2,"ps_1",TransitionOperation.SendROverNetwork,"ps_o1"));
        grdTs_2.Activations.add(new Activation(ts_2,"ps_1",TransitionOperation.PopElement_R_E,outputs));

        ts_2.GuardMappingList.add(grdTs_2);

        ts_2.Delay = 0;
        pn.Transitions.add(ts_2);



        PetriTransition ts_3 = new PetriTransition(pn);
        ts_3.TransitionName = "ts_3";
        ts_3.InputPlaceName.add("ps_i2");

        Condition Ts3Ct1 = new Condition(ts_3,"ps_i2",TransitionCondition.NotNull);

        GuardMapping grdTs_3 = new GuardMapping();
        grdTs_3.condition = Ts3Ct1;

        grdTs_3.Activations.add(new Activation(ts_3,"ps_i2",TransitionOperation.Move,"ps_2"));
        grdTs_3.Activations.add(new Activation(ts_3,"ps_i2",TransitionOperation.Move,"ps_o2"));

        ts_3.GuardMappingList.add(grdTs_3);
        ts_3.Delay = 0;
        pn.Transitions.add(ts_3);

        System.out.println("Exp1 started \n ------------------------------");
        pn.Delay = 3000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}
