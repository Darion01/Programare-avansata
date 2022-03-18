package HW3;

import HW3.Identifiable;
import HW3.Storage;

import javax.xml.stream.Location;
import java.util.Map;

public class Computer extends Node implements Identifiable, Storage {
    private String address;
    private int storageCapacity;

    public Computer(String address, int storageCapacity) {
        super();
        this.address = address;
        this.storageCapacity = storageCapacity;
    }

    public Computer(String name, Map<Node, Integer> cost, String address, int storageCapacity) {
        super(name, cost);
        this.address = address;
        this.storageCapacity = storageCapacity;
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
        return storageCapacity;
    }

    @Override
    public int compareTo(Location o) {
        return 0;
    }

}
