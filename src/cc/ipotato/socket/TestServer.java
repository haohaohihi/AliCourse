package cc.ipotato.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestServer {
    public static void main(String[] args) throws IOException {
        System.out.println("等待输入...");
        ServerSocket server = new ServerSocket(54321);
        Socket client = server.accept();

        Scanner scan = new Scanner(client.getInputStream());   //获得客户端传送数据的Scanner对象
        scan.useDelimiter("\n");
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);  //返回结果给客户端的PrintWriter对象

        while(scan.hasNextLine()){
            String str = scan.nextLine().trim();
            System.out.println("输入： " + str);
            out.println("ECHO: " + str);
            if("bye".equalsIgnoreCase(str)){
                System.out.println("程序结束!");
                break;
            }
        }

        out.close();
        scan.close();
        client.close();
        server.close();

    }
}
