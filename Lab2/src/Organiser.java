import Event.*;
import Room.Room;

import java.util.*;

public class Organiser {
    private final Set<Event> events;
    private final Set<Room> rooms;

    public Organiser(Collection<Room> rooms, Collection<Event> events) {
        this.events = new TreeSet<>(new EventComparator());
        this.events.addAll(events);
        this.rooms = new HashSet<>(rooms);
    }

    public Organiser() {
        this(Collections.emptyList(), Collections.emptyList());
    }

    public Set<Event> getEvents() {
        return events;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public boolean addEvent(Event e){
        return events.add(e);
    }

    public boolean removeEvent(Event e){
        return events.remove(e);
    }

    public boolean addRoom(Room r){
        return rooms.add(r);
    }

    public boolean removeRoom(Room r){
        return rooms.remove(r);
    }

    public Map<Room, List<Event>> runGreedy(){
        return Collections.emptyMap();
    }


}
