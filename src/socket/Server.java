package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    public Server(){
        try {
            System.out.println("Starting the server...");
            serverSocket=new ServerSocket(8088);
            System.out.println("Start already");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        try {
            System.out.println("Waiting client connect...");
            Socket socket=serverSocket.accept();//阻塞方法
            System.out.println("Client connected");

            InputStream is=socket.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            String line=br.readLine();
            System.out.println("Client says:"+line);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Server server=new Server();
        server.start();
    }
}
