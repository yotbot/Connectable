/**
 * Created by Sietse on 1-8-2016.
 */

import java.io.*;
import java.net.*;

public class ConnectLib {

    String clientSentence;
    String capitalizedSentence;
    ServerSocket welcomeSocket;
    Socket connectionSocket;

    public ConnectLib(){}

    public boolean connect(){
        try
        {
            welcomeSocket = new ServerSocket(6789);
            System.out.println("Connection established.");
            return true;
        }
        catch (IOException e)
        {
            System.out.println("Connection failed.");
            return false;
        }
    }

    public boolean send(String msg)
    {
        try {
            connectionSocket = welcomeSocket.accept();

            //Send something
            //BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
            DataOutputStream outToServer = new DataOutputStream(connectionSocket.getOutputStream());
            outToServer.writeBytes(msg + '\n');

            connectionSocket.close();
            System.out.println("Send succesful.");
            return true;
        }
        catch (IOException e){
            System.out.println("Send failed.");
            return false;
        }
    }

    public boolean disconnect(){
        try{
            welcomeSocket.close();
            System.out.println("Connection closed.");
            return true;
        }
        catch (IOException e)
        {
            System.out.println("Connection failed to close.");
            return false;
        }
    }

    public static void main(String argv[]) {}

}
