package cc.ipotato.socket.TCP.FileUpload;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        File file = getFile();
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream outputStream= socket.getOutputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream printStream = new PrintStream(socket.getOutputStream());

        printStream.println(file.getName());
        String startMessage = bufferedReader.readLine();
        if (!"ok".equals(startMessage)) {
            System.out.println("upload failed");
            return;
        } else {
            System.out.println("start uploading...");
        }


        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] data = new byte[8192];
        int len;
        while ((len = fileInputStream.read(data)) != -1) {
            outputStream.write(data, 0, len);
        }
        fileInputStream.close();

        socket.shutdownOutput();    // 这句很重要，不然server接收不到文件传输结束的-1标识

        System.out.println(bufferedReader.readLine());
        socket.close();
    }

    public static File getFile() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入一个的文件路径: ");
            String line = scanner.nextLine();
            File file = new File(line);
            if (file.isFile()) {
                return file;
            }
            System.out.println("输入错误，请输入正确的文件路径！！！");
        }
    }
}


