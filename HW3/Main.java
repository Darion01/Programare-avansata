package HW3;

import HW3.Computer;
import HW3.Router;
import HW3.Switch;


public class Main {

    public static void main(String args[])
    {
        Network myNetwork = new Network();
        Computer computer1 = new Computer("Asus",null,"location1",1024);
        Computer computer2 = new Computer("Lenovo",null,"location2",1024);
        Router router1 = new Router("tpLink", null,"location1");
        Router router2 = new Router("netGear", null,"location3");
        Switch switch1 = new Switch("Dlink", null);
        Switch switch2 = new Switch("Tenda", null);

        computer1.setCost(router1,10);
        computer1.setCost(switch2,50);
        router1.setCost(switch1,20);
        router1.setCost(computer2,20);
        router1.setCost(router1,10);
        switch2.setCost(computer2,20);
        computer2.setCost(router1,30);
        computer2.setCost(switch1,10);
        router2.setCost(switch1,20);

        myNetwork.addNode(computer1);
        myNetwork.addNode(computer2);

        myNetwork.addNode(router1);
        myNetwork.addNode(router2);

        myNetwork.addNode(switch1);
        myNetwork.addNode(switch2);

        myNetwork.nodeDisplay();

        System.out.println(myNetwork);


    }
}
