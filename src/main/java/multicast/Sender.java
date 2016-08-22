package multicast;

import java.io.IOException;
import java.net.*;

/**
 * Created by iranna.patil on 22-08-2016.
 */
public class Sender {

    public static void main(String[] args) throws IOException {
        InetAddress group = InetAddress.getByName("225.4.5.6");
        MulticastSocket socket = new MulticastSocket();
        socket.joinGroup(group);
        String message = "how are you";

        DatagramPacket packet = new DatagramPacket(message.getBytes(),message.length(),group,3456);

        socket.send(packet);

        socket.close();
    }
}
