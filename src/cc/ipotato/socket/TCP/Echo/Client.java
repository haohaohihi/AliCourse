package cc.ipotato.socket.TCP.Echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1", 8888);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());
        while (true) {
            String line = sc.nextLine();
            out.println(line);
            System.out.println(in.readLine());
            if ("quit".equals(line)) {
                break;
            }
        }
        socket.close();
    }
}
