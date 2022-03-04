package Lab2;

public class Main {

    public static void main(String[] args) {

        Event C1 = new Event("C1", 150, 8, 10);
        Event L1 = new Event("L1", 150, 10, 12);
        Event C2 = new Event("C2", 30, 8, 10);
        Event L2 = new Event("L2", 100, 8, 10);
        Event C3 = new Event("C3", 95, 10, 12);
        Event L3 = new Event("L4", 90, 9, 11);

        Room R1 = new Room("401", 30, Room.EnumType.ComputerLab);
        Room R2 = new Room("302", 100, Room.EnumType.LectureHall);

        System.out.println(C1.toString());
    }
}