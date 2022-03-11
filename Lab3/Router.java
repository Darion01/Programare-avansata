package Lab3;

import javax.xml.stream.Location;
import java.util.Map;

public class Router extends Node implements Identifiable {
        private String address;

    public Router(String name, Map<Node, Integer> cost,String address) {
        super(name, cost);
        this.address = address;
    }

    @Override
    public int compareTo(Location o) {
        return 0;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
