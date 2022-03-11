package Event;

import Room.Lab;
import Room.Room;

public class Seminar extends Event{
    private String operatingSys;

    public Seminar(int startTime, int spanTime, String name, String operatingSys, int size) {
        super(startTime, spanTime, name, size);
        this.operatingSys = operatingSys;
    }

    public String getOperatingSystemNeeded() {
        return operatingSys;
    }

    public void setOperatingSystemNeeded(String operatingSys) {
        this.operatingSys = operatingSys;
    }

    @Override
    public boolean validRoom(Room r) {
        if (!(r instanceof Lab))
            return false;

        if(operatingSys == null)
            return true;

        return operatingSys == ((Lab) r).getOperatingSystem();
    }

    @Override
    public String toString() {
        return super.toString() + (operatingSys != null ? (" || " + operatingSys) : "");
    }
}
