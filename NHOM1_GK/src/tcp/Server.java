package tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Nhom1
 */
public class Server {
    
    public static int serverPort = 8888;
    
    private ServerSocket server;
    
    private BufferedReader rev;
    private DataOutputStream send;
    
    public Server() throws IOException{
        this.server = new ServerSocket(serverPort);
        this.server.setReuseAddress(true);
    }
    
    public ServerSocket getServer(){
        return this.server;
    }
    
    public void acceptClient(Socket client) throws IOException{
        this.rev = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.send = new DataOutputStream(client.getOutputStream());
    }
    
    public void sendData(String s) throws IOException{
        this.send.writeBytes(s+"\n");
    }
    
    public String revData() throws IOException{
        return this.rev.readLine();
    }
    
    public void closeServer() throws IOException{
        this.server.close();
    }
    
}
