package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sh1 on 15-12-10.
 */
public class BioServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private int iClient;

    public BioServer() throws IOException {
        serverSocket = new ServerSocket(7888);
        iClient = 0;
        while (true) {
            socket = serverSocket.accept();
            System.out.println("共有多少：" + (++iClient));
            new Thread(new ClientThread(socket)).start();
        }
    }


    public static void main(String[] args) {
        try {
            new BioServer() ;
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

