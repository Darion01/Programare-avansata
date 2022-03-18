package HW3;

import HW3.Node;
import Lab3.Identifiable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Network {

    private final List<Node> nodes = new ArrayList<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void nodeDisplay()
    {
        List<Node> identifiableNode = new ArrayList<>();
        for( Node n : nodes)
        {
            if(n instanceof Lab3.Identifiable)
                identifiableNode.add(n);
        }
        identifiableNode.sort(Comparator.comparing(n -> ((Identifiable) n).getAddress()));

        for (Node n : identifiableNode)
            System.out.println(n.getName());
    }
    public String toString()
    {
        StringBuilder net = new StringBuilder();
        for( Node n : nodes)
        {
            System.out.println(n.getName());
            n.getCost().forEach((k, v) -> {
                System.out.println(k.getName() + " " + v + "\n");
            });
        }
        return net.toString();
    }
}
