package Lab3;

import javax.xml.stream.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Network {
    private List<Node> nodes = new ArrayList<>();

    public void addNodes(Node node)
    {
        nodes.add(node);
    }

    public String toString()
    {
        StringBuilder net = new StringBuilder();
        for( Node n : nodes)
        {
            System.out.println(n.getName());
        }
        return net.toString();
    }
}
