package Lab10.src.main.java.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleClient {
    public static void main (String[] args) throws IOException
    {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader (
                        new InputStreamReader(socket.getInputStream()))
        ) {

            //read from the keyboard the request
            Scanner keyboard = new Scanner(System.in);
            //the message
            String response = "";
            boolean running = true;
            while(running)
            {
                System.out.println("[CLIENT] Enter a command:");
                String request = keyboard.nextLine();
                if(request.equals("exit"))
                {
                    running = false;
                }
                out.println(request);

                if(running)
                {
                    response = in.readLine();
                    System.out.println(response);
                }
            }
        }
        catch (UnknownHostException e)
        {
            System.err.println("No server listening... " + e);
        }
        finally
        {
            System.out.println("[CLIENT] Stop command entered. good bye!");
        }
    }
}