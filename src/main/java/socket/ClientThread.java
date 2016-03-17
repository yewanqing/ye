package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by sh1 on 15-12-10.
 */
public class ClientThread implements Runnable {
    private Socket client ;
    public ClientThread(Socket client) {
        this.client = client ;
    }
    @Override
    public void run() {
// TODO Auto-generated method stub
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream())) ;
            boolean flag = true ;
            while(flag){
                String clientSay = reader.readLine() ;
                if (clientSay == null || "".equals(clientSay)) {
                    flag = false;
                    break;
                }
                if ("bye".equals(clientSay)) {
                    flag = false;
                    break;
                }
                System.out.println("client说："+clientSay);
                PrintWriter out = new PrintWriter(client.getOutputStream() ,true ) ;
                out.println("client端 说的是："+clientSay) ;
            }
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
