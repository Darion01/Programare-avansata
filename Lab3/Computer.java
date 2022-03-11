package Lab3;

import javax.xml.stream.Location;
import java.util.Map;

public class Computer extends Node implements Identifiable, Storage{
    private String address;
    private int capacity;

    public Computer(String name, Map<Node, Integer> cost, String address, int capacity) {
        super(name, cost);
        this.address = address;
        this.capacity = capacity;
    }

    @Override
    public int compareTo(Location o) {
        return 0;
    }

    @Override
    public String getAddress() {
            return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int getStorageCapacity() {
        return capacity;
    }
}
