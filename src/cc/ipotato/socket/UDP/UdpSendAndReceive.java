package cc.ipotato.socket.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created by haohao on 2018/5/10.
 */
public class UdpSendAndReceive {
    public static void main(String[] args) {
        new ReceiveThread().start();
        new SendThread().start();
    }
}

class SendThread extends Thread {
    @Override
    public void run() {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ReceiveThread extends Thread {
    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(8888);
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            while (true) {
                socket.receive(packet);
                byte[] arr = packet.getData();
                String ip = packet.getAddress().getHostAddress();
                int port = packet.getPort();
                System.out.println(ip + ":" + port + ": " + new String(arr, 0, packet.getLength()));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}