package cc.ipotato.socket;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created by haohao on 2018/5/10.
 */
public class UdpSend {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        DatagramSocket socket = new DatagramSocket();   //创建socket
        while (true) {
            String s = sc.nextLine();
            if ("quit".equals(s)) {
                break;
            }
            DatagramPacket packet = new DatagramPacket(s.getBytes(), s.length(),
                    InetAddress.getByName("127.0.0.1"), 8888);  //创建packet
            socket.send(packet);
        }
        socket.close();
    }
}
