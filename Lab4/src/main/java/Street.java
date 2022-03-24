
import java.util.ArrayList;
import java.util.List;

public class Street {
   private String name;
    private Integer length;
    private Intersection node1;
    private Intersection node2;

    public Street(String name, Integer length, Intersection node1, Intersection node2) {
        this.name = name;
        this.length = length;
        this.node1 = node1;
        this.node2 = node2;
    }

    public Street(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Intersection getNode1() {
        return node1;
    }

    public void setNode1(Intersection node1) {
        this.node1 = node1;
    }

    public Intersection getNode2() {
        return node2;
    }

    public void setNode2(Intersection node2) {
        this.node2 = node2;
    }

    @Override
    public String toString() {
        return "Street" +
                "name=" + name +
                ", length= " + length +
                ", node1= " + node1 +
                ", node2= " + node2;
    }
}
