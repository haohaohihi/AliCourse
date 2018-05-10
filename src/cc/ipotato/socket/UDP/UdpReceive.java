package cc.ipotato.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by haohao on 2018/5/10.
 */
public class UdpReceive {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        DatagramPacket packet = new DatagramPacket(new byte[1024],1024);
        while(true) {
            socket.receive(packet);
            byte[] arr = packet.getData();
            String ip = packet.getAddress().getHostAddress();
            int port = packet.getPort();
            System.out.println(ip + ":" + port + ": " + new String(arr, 0, packet.getLength()));
        }
    }
}
