

import Interfaces.PlaceTemplate;

public class UserPlace implements PlaceTemplate {
    String Name;
    InputUser value;

    public UserPlace(String name, Object value) {
        this.Init(name, value);
    }

    @Override
    public Object Get() {
        return this.value;
    }

    @Override
    public void Set(Object value) {
        this.value = (InputUser) value;
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
        if(this.value == null){
            return "[" + this.Name + "=" + null + "]";
        }
        return "[" + this.Name + "=" + this.value + "]";
    }

    @Override
    public void Init(String name, Object value) {
        this.SetPlaceName(name);
        this.Set(value);
    }

    @Override
    public Boolean IsNull() {
        return this.Get() == null;
    }
}
