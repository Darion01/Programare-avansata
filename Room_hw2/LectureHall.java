package Room;

public class LectureHall extends Room{
    public LectureHall(int size, String name) {
        super(size, name);
    }

    public LectureHall() {
    }

    @Override
    public String toString() {
        return "Sala de lectura: " + super.toString();
    }
}
