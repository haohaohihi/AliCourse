package cc.ipotato.socket;

import sun.reflect.generics.scope.Scope;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class ServerThread implements Runnable{
    private Socket client = null;
    public ServerThread(Socket client){
        this.client = client;
    }

    @Override
    public void run() {
        try {
            Scanner scan = new Scanner(client.getInputStream());   //获得客户端传送数据的Scanner对象
            scan.useDelimiter("\n");
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);  //返回结果给客户端的PrintWriter对象
            while (scan.hasNextLine()) {
                String str = scan.nextLine().trim();
                System.out.println("输入： " + str);
                out.println("ECHO: " + str);
                if ("bye".equalsIgnoreCase(str)) {
                    System.out.println("程序结束!");
                    break;
                }
            }
            out.close();
            scan.close();
            this.client.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

public class ThreadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(54321);
        Socket client = null;
        boolean f = true;
        int count = 1;
        while(f){
            client = server.accept();
            System.out.printf("与客户端%s连接成功!\n", count++);
            new Thread(new ServerThread(client)).start();
        }
    }
}
