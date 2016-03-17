package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by sh1 on 15-12-10.
 */
public class BioClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 7888);
        BufferedReader clientIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        boolean flag = true;
        while (flag) {
            System.out.println("请输入发送信息");
            String clientSay = clientIn.readLine();
            if (clientSay == null || "".equals(clientSay)) {
                flag = false;
                break;
            }
            if ("bye".equals(clientSay)) {
                flag = false;
                break;
            }
            out.println(clientSay);
            System.out.println("服务器：" + serverIn.readLine());
        }
        clientIn.close();
        serverIn.close();
        out.close();
        socket.close();
    }
}
