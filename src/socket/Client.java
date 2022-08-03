package socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    private Socket socket;
    public Client(){

        try {
            System.out.println("Connecting to the server...");
            Socket socket=new Socket("localhost",8088);
            System.out.println("Connected already");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        try {
            OutputStream out=socket.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(out, StandardCharsets.UTF_8);
            BufferedWriter bw=new BufferedWriter(osw);
            PrintWriter pw=new PrintWriter(bw,true);
            pw.println("Hello,Server!");
            }
            catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client=new Client();
        client.start();
    }
}
