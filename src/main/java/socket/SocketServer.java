package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by sh1 on 16-1-11.
 */
public class SocketServer {


    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5678);
        Socket client = server.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedReader serverIn = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(client.getOutputStream());
        while (true) {
            String str = in.readLine();
            System.out.println(str);
            String serverInStr = serverIn.readLine();
            out.println(serverInStr);
            out.flush();
            if (str.equals("end"))
                break;
        }
        client.close();

    }
}
