package remote;

/**
 * Created by sh1 on 16-1-18.
 */
public class BusinessImpl implements Business {
    @Override
    public String echo(String message) {
        if ("quit".equalsIgnoreCase(message)) {
            System.out.println("Server will be shutdown");
            System.exit(0);
        }

        System.out.println("Message from client:" + message);

        return "Server response:" + message;
    }
}
