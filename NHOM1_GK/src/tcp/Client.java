package tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Nhom1
 */
public class Client {
    
    private Socket client;
    
    private DataOutputStream send;
    private BufferedReader rev;
    private String host="localhost";
    private int port=8888;
    
    public Client(String host, int port) throws IOException{
        this.client = new Socket(host, port);
        this.host = host;
        this.port = port;
        this.send = new DataOutputStream(this.client.getOutputStream());
        this.rev = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
    }
    
    public void reconnect() throws IOException{
        this.client = new Socket(this.host, this.port);
        this.send = new DataOutputStream(this.client.getOutputStream());
        this.rev = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
    }
    
    public void sendData(String s) throws IOException{
        this.send.writeBytes(s+"\n");
    }
    
    public String revData() throws IOException{
        return this.rev.readLine();
    }
    
    public void closeClient() throws IOException{
        this.client.close();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
}
