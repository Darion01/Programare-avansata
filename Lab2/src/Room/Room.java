package Room;

import java.util.*;


abstract public class Room {

    protected int size;
    protected String name;

    public Room(int size, String name) {
        this.size = size;
        this.name = name;
    }

    public Room(){
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public static boolean addRoom(Room room1,List<Room> roomList)
    {
        for(Room temporary : roomList)
        {
            if(room1.equals(temporary))
                return false;
        }
        roomList.add(room1);
        return true;
    }

    @Override
    public String toString() {
        return name + " (" + size + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return name.equals(room.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
