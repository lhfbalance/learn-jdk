package learn.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("61.135.169.121");
        byte[] bytes = {127, 0, 0, 1};
        InetAddress inetAddress1 = InetAddress.getByAddress("61.135.169.121", bytes);
        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress1.getHostAddress());
    }

}
