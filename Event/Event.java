package Event;

import Room.Room;

import java.util.List;
import java.util.Objects;

public class Event {
    protected int startTime;
    protected int entTime;
    protected int size;
    protected String name;

    public Event(int startTime, int spanTime, String name, int size) {
        this.startTime = startTime;
        this.entTime = startTime + spanTime;
        this.name = name;
        this.size = size;
    }


    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEntTime() {
        return entTime;
    }

    public void setEntTime(int entTime) {
        this.entTime = entTime;
    }

    public int getSize() { return size; }

    public void setSize(int size) { this.size = size; }

    public boolean validRoom(Room r){
        return true;
    }

    public static boolean addEvent(Event event, List<Event> eventList)
    {
        for(Event temporary : eventList)
        {
            if(event.equals(temporary))
                return false;
        }
        eventList.add(event);
        return true;
    }

    @Override
    public String toString() {
        return name + " (" + size + "," + startTime + ", " + entTime + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Event)) return false;
        Event event = (Event) obj;
        return this.startTime == event.startTime && entTime == event.entTime && size == event.size && name.equals(event.name);
    }
/*
    @Override
    public int hashCode() {
        return Objects.hash(startTime, entTime, name);
    }
    */

}
