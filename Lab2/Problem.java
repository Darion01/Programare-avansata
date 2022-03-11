package Lab2;

public class Problem {
    private Event[] E;
    private Room[] R;

    public void setE(Event... e) {
        this.E = e;
    }

    public void setR(Room... r) {
        this.R = r;
    }

    public Event[] getE() {
        return E;
    }

    public Room[] getR() {
        return R;
    }
}
