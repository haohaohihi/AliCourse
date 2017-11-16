package cc.ipotato.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TestClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 54321);

        Scanner scan = new Scanner(client.getInputStream());    //获取服务端发送结果的Scanner类
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);  //发送数据给服务端的PrintWriter类

        Scanner keyScan = new Scanner(System.in);   //获取键盘输入的Scanner类
        keyScan.useDelimiter("\n");

        System.out.print("请输入：");
        while(keyScan.hasNextLine()){
            String str = keyScan.nextLine().trim();
            out.println(str);
            System.out.println(scan.nextLine());
            if("bye".equalsIgnoreCase(str))  {
                System.out.println("程序结束！");
                break;
            }
            System.out.print("请输入： ");
        }
        out.close();
        scan.close();
        client.close();
    }
}
