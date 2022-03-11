import Event.*;
import Room.*;

import java.sql.Array;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>(20);
        List<Event> events = new ArrayList<>();

        Room.addRoom(new CourseRoom(20,"C123",true),rooms);
        Room.addRoom(new CourseRoom(15,"C523",false),rooms);
        Room.addRoom(new CourseRoom(10,"C424",true),rooms);
        Room.addRoom(new CourseRoom(14,"C164",false),rooms);

        Room.addRoom(new Lab(15,"Lab132","Windows"),rooms);
        Room.addRoom(new Lab(20,"Lab123","Windows"),rooms);
        Room.addRoom(new Lab(20,"Lab150","Linux"),rooms);

        Event.addEvent(new Event(8,10,"E123",13),events);
        Event.addEvent(new Event(9,11,"E812",15),events);

        Event.addEvent(new Seminar(7,9,"Seminar135","Linux",20),events);
        Event.addEvent(new Seminar(7,9,"Seminar135","Linux",20),events);

        for(Room r : rooms)
            System.out.println(r);
        for(Event e : events)
            System.out.println(e);


        // System.out.println(events.size());
        //  System.out.println(rooms.size());

        // Organiser o = new Organiser(rooms, events);

        // System.out.println(events.size());
        // System.out.println(rooms.size());
    }
}
