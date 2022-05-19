package Lab10.src.main.java.app;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server
{
    // Define the port on which the server is listening
    public static final int PORT = 8100;
    boolean running = true;

    //list of client sockets
    List<Socket> clients = new ArrayList<>();
    List<String> users = new ArrayList<>();

    //list of lists of friends
    List<List<String>> usersFriends = new ArrayList<>();

    public Server() throws IOException
    {
        //launch a thread which iterates through all clients at 1 second intervals
        //and closes the ones not available
        ClientKiller clientKiller = new ClientKiller(this);
        ServerSocket serverSocket = null ;
        try
        {
            serverSocket = new ServerSocket(PORT);
            while (running)
            {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();

                //adding this client to the list of clients
                clients.add(socket);

                // Execute the client's request in a new thread
                new ClientThread(socket, this).run();
            }
        } catch (IOException e)
        {
            System.err. println ("Ooops... " + e);
        }
        finally
        {
            serverSocket.close();
        }
    }

    public void setRunning(boolean running)
    {
        this.running = running;
    }

    public boolean addUser(String currentUser)
    {
        for(String user : users)
        {
            if (user.equals(currentUser))
            {
                //user is already registered!
                return false;
            }
        }
        users.add(currentUser);
        return true;
    }

    public boolean login(String currentUser)
    {
        for(String user : users)
        {
            if(user.equals(currentUser))
            {
                return true;
            }
        }
        return false;
    }

    public List<List<String>> getUsersFriends()
    {
        return this.usersFriends;
    }

    public List<String> getUsers()
    {
        return this.users;
    }

    public List<Socket> getClients()
    {
        return clients;
    }

    public void removeClient(Socket client)
    {
        clients.removeIf(socket -> socket.equals(client));
    }

    public static void main ( String [] args ) throws IOException
    {
        Server server = new Server();
    }
}