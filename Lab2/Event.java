package Lab2;
public class Event extends ObjectAbstract {

    private String name;
    private int size;
    private int start;
    private int end;

    public Event(String name, int size, int start, int end) {
        this.name = name;
        this.size = size;
        this.start = start;
        this.end = end;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString(){
        return getName() + "(size= " + getSize() + ", start= " + getStart() + ", end= "  + getEnd() + ")";
    }
}
