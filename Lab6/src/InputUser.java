
public class InputUser {
    Integer R;
    Integer E;
    Integer L;

    public InputUser(Integer r, Integer e, Integer l) {
        R = r;
        E = e;
        L = l;
    }

    public String print(){
        return "INPUT = { R = " + R +
                " E = " + E +
                " L = " + L +
                " }";
    }
}
