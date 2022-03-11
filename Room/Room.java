package Room;

import java.util.*;


abstract public class Room {

    protected int size;
    protected final String name;

    public Room(int size, String name) {
        this.size = size;
        this.name = name;
    }

    public Room(){
        this((int)(Math.random() * 10 + 10), "C" + (int)(Math.random()*300+100));
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
