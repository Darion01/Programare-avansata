package Room;

public class CourseRoom extends Room{
    private boolean projector;

    public CourseRoom(int size, String name, boolean projector) {
        super(size, name);
        this.projector = projector;
    }

    public boolean isProjector() {
        return projector;
    }

    public void setProjector(boolean projector) {
        this.projector = projector;
    }

    @Override
    public String toString() {
        return "Sala de curs " + (projector ? "cu" : "fara") + " video-proiector: " + super.toString();
    }
}
