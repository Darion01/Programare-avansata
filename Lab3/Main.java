package Lab3;

public class Main {

    public static void main(String args[])
    {
        Network myNetwork = new Network();
        Computer computer1 = new Computer("Asus",null,"Location1",1024);
        Computer computer2 = new Computer("Lenovo",null,"Location2",1024);
        Router router1 = new Router("tpLink", null,"Location1");
        Router router2 = new Router("netGear", null,"Location3");
        Switch switch1 = new Switch("Dlink", null);
        Switch switch2 = new Switch("Tenda", null);

        myNetwork.addNodes(computer1);
        myNetwork.addNodes(computer2);

        myNetwork.addNodes(router1);
        myNetwork.addNodes(router2);

        myNetwork.addNodes(switch1);
        myNetwork.addNodes(switch2);


        System.out.println(myNetwork);


    }
}
