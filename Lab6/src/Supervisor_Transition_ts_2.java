
import Interfaces.PlaceHandlerTemplate;
import Interfaces.TransitionTemplate;

import java.util.List;

public class Supervisor_Transition_ts_2 implements TransitionTemplate {
    Integer timeUnitControl = 500;
    Integer eet;
    Integer let;
    String name;
    PlaceHandlerTemplate PH;
    PlaceHandlerTemplate ControllerPH;

    public Supervisor_Transition_ts_2(String name, PlaceHandlerTemplate PH, Integer delay){
        this.Init(name,PH);
        this.SetDelay(delay);
    }

    public Supervisor_Transition_ts_2(String name, PlaceHandlerTemplate PH, Integer eet, Integer let){

        this.Init(name,PH);
        this.SetDelayInRange(eet, let);
    }

    @Override
    public void TransitionDelay(){
        try {
            if (this.let == null) {
                Thread.sleep(this.eet * timeUnitControl);
            } else {
                Thread.sleep(Math.round(Math.random() * (this.let - this.eet) + this.eet) * timeUnitControl);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean TransitionGuardsMappings(){
        TransitionDelay();
        List<InputUser>inputUserList = (List<InputUser>)PH.GetPlaceByName("ps_1").Get();
        String toPrint="---------Supervisor---------\n";

        if(!inputUserList.isEmpty() && !PH.GetPlaceByName("ps_2").IsNull() &&
                (inputUserList.get(0).R!=PH.GetPlaceByName("ps_2").Get())){

            toPrint = toPrint.concat(Print() + "\n");
            toPrint = toPrint.concat("SupervisiorrPH\n"+ControllerPH.PrintAllPlaces()+ "\n");

            PH.GetPlaceByName("ps_o1").Set(inputUserList.get(0).R);
            ControllerPH.GetPlaceByName("p_i1").Set(PH.GetPlaceByName("ps_o1").Get());
            PH.GetPlaceByName("ps_3").Set(inputUserList.get(0).E);
            inputUserList.remove(0);

            toPrint = toPrint.concat(Print() + "\n");
            toPrint = toPrint.concat("-----------------------------------\n");

            System.out.println(toPrint);
            return true;
        }
        return false;
    }

    @Override
    public void Init(String name, PlaceHandlerTemplate PH){
        this.PH = PH;
        this.name = name;
    }

    @Override
    public void SetDelay(int value){
        this.eet = value;
    }

    @Override
    public void SetDelayInRange(int eet, int let){
        this.eet = eet;
        this.let = let;
    }

    @Override
    public String Print(){
        return this.name +"\n" + this.PH.PrintAllPlaces();
    }

}
