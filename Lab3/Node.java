package Lab3;

import javax.xml.stream.Location;
import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Location> {
    private String name;
    private Map<Node, Integer> cost = new HashMap<>();

    public Node(String name, Map<Node, Integer> cost){
        this.name = name;
        if(cost != null)
            this.cost = cost;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Node, Integer> getCost() {
        return cost;
    }

    public void setCost(Map<Node, Integer> cost) {
        this.cost = cost;
    }

    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    public String toString()
    {
        return "name = " + name + "(" + cost + ")";
    }

    public int compareTo(Node other) {
        return this.name.compareTo(other.name);
    }
}
