package Event;

import Room.LectureHall;
import Room.Room;

public class Lecture extends Event{
    public Lecture(int startTime, int spanTime, String name, int size) {
        super(startTime, spanTime, name, size);
    }

    @Override
    public boolean validRoom(Room r) {
        return (r instanceof LectureHall);
    }

}
