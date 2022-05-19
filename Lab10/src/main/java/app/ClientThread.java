package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ClientThread
{
    private Socket socket = null ;
    private Server server = null;
    private String currentUser = "";
    private boolean isLoggedIn = false;

    public ClientThread(Socket socket, Server server) { this.socket = socket ;  this.server = server;}
    public void run () {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            boolean running = true;
            while(running)
            {
                String request = in.readLine();

                if(request.startsWith("listreg"))
                {
                    int i = 0;
                    for(String users : server.getUsers())
                    {
                        i++;
                        System.out.printf("User %d: %s\n", i, users);
                    }
                }

                if(request.startsWith("listuser"))
                {
                    if(isLoggedIn)
                    {
                        System.out.printf("Current user is: %s\n", currentUser);
                    }
                }

                if(request.startsWith("listfriends"))
                {
                    if(isLoggedIn)
                    {
                        for(List<String> userFriends : server.getUsersFriends())
                        {
                            if(userFriends.get(0).equals(currentUser))
                            {
                                int i = 0;
                                System.out.printf("User %s has %d friends:\n", currentUser, userFriends.size() - 1);
                                for(String friends : userFriends)
                                {
                                    if(i == 0)
                                    {
                                        i++;
                                    }
                                    System.out.printf("Friend %d: %s\n", i, friends);
                                    i++;
                                }
                            }
                        }
                    }
                }

                if(request.startsWith("register"))
                {
                    out.println("[SERVER] login command initiated");
                    server.addUser(request.substring(8));
                    server.getUsersFriends().add(new LinkedList<>());
                    server.getUsersFriends().get(server.getUsersFriends().size() - 1).add(request.substring(8));
                }

                if(request.startsWith("login"))
                {
                    if(server.login(request.substring(5)))
                    {
                        setCurrentUser(request.substring(5));
                        setLoggedIn(true);
                    }
                }

                if(request.startsWith("logout"))
                {
                    if(isLoggedIn)
                    {
                        setCurrentUser("");
                        setLoggedIn(false);
                    }
                }

                if(request.startsWith("friend"))
                {
                    //verify if logged in
                    if(isLoggedIn)
                    {
                        List<String> friendsToBeAdded = Arrays.stream(request.substring(7).split(" ")).toList();
                        for(List<String> usersFriends: server.getUsersFriends())
                        {
                            if(usersFriends.get(0).equals(currentUser))
                            {
                                usersFriends.addAll(friendsToBeAdded);
                            }
                        }
                    }
                }

                if(request.equals("exit"))
                {
                    break;
                }

                if(request.equals("stop"))
                {
                    server.setRunning(false);
                }

                out.println(request);
                out.flush();
            }

        }
        catch (IOException e)
        {
            System.err.println("Communication error... " + e);
        }
    }

    public void setCurrentUser(String currentUser)
    {
        this.currentUser = currentUser;
    }

    public void setLoggedIn(boolean isLoggedIn)
    {
        this.isLoggedIn = isLoggedIn;
    }
}
