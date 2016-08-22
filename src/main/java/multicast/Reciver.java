package multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by iranna.patil on 22-08-2016.
 */
public class Reciver {

    public static void main(String[] args) throws IOException {
        InetAddress group = InetAddress.getByName("225.4.5.6");
        MulticastSocket socket = new MulticastSocket(3456);
        socket.joinGroup(group);
        byte[] buff = new byte[100];

        DatagramPacket packet = new DatagramPacket(buff, buff.length);

        socket.receive(packet);

        System.out.println(new String(buff));
        socket.close();
    }
}
