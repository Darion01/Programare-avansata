package Event;

import Room.CourseRoom;
import Room.Room;

public class Course extends Event {
    private boolean projectorNeeded;

    public Course(int startTime, int spanTime, String name, boolean projectorNeeded, int size) {
        super(startTime, spanTime, name, size);
        this.projectorNeeded = projectorNeeded;
    }
    public boolean isProjectorNeeded() {
        return projectorNeeded;
    }

    public void setProjectorNeeded(boolean projectorNeeded) {
        this.projectorNeeded = projectorNeeded;
    }



    @Override
    public boolean validRoom(Room r) {
        if (!(r instanceof CourseRoom))
            return false;
        return !projectorNeeded || ((CourseRoom) r).isProjector();
    }

    @Override
    public String toString() {
        return super.toString() + (projectorNeeded ? " || nevoie de proiector" : "");
    }
}
