package Lab2;

public class Room extends ObjectAbstract {

    enum EnumType {ComputerLab, LectureHall}

    private String name;
    private int capacity;
    private EnumType type;

    public Room(String name, int capacity, EnumType type) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }

    public void setType(EnumType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public EnumType getType() {
        return type;
    }

    @Override
    public String toString() {
        return getName() + "(cap= " + getCapacity() + "," + getType() + ")";
    }

}
