package HW3;

import javax.xml.stream.Location;
import java.util.Map;

public class Switch extends Node {

    public Switch(String name, Map<Node, Integer> cost) {
        super(name, cost);
    }

    @Override
    public int compareTo(Location o) {
        return 0;
    }
}
