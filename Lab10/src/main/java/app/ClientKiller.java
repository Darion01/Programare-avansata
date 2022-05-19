package app;

import java.io.IOException;
import java.net.Socket;

public class ClientKiller
{
    Server server = null;

    public ClientKiller(Server server)
    {
        this.server = server;
    }

    public void run()
    {
        //iterate through the connected users and reap the non responsive ones
        for(Socket user : server.getClients())
        {
            if(!user.isConnected())
            {
                try
                {
                    user.close();
                    server.removeClient(user);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}