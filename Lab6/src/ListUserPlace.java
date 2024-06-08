

import Interfaces.PlaceTemplate;

import java.util.List;

public class ListUserPlace implements PlaceTemplate {
    String Name;
    List<InputUser> value;

    public ListUserPlace(String name, Object value) {
        this.Init(name, value);
    }

    @Override
    public Object Get() {
        return this.value;
    }

    @Override
    public void Set(Object value) {
        this.value.add((InputUser)value);
    }

    @Override
    public String GetPlaceName() {
        return this.Name;
    }

    @Override
    public void SetPlaceName(String name) {
        this.Name = name;
    }

    @Override
    public String Print() {
        String print = "[" + this.Name + "=";
        for (InputUser userinput : value){
            if(userinput != null){
                print = print.concat(userinput.print());
            }
        }

        print = print.concat("]");

        return print;
    }

    @Override
    public void Init(String name, Object value) {
        this.SetPlaceName(name);
        this.value = (List<InputUser>) value;
    }

    @Override
    public Boolean IsNull() {
        return this.Get() == null;
    }
}
