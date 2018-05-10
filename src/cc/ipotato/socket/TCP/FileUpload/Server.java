package cc.ipotato.socket.TCP.FileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            final Socket socket = server.accept();
            new Thread(() -> {
                try {
                    InputStream inputStream = socket.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    PrintStream printStream = new PrintStream(socket.getOutputStream());

                    String fileName= bufferedReader.readLine();
                    File dir = new File("upload");
                    if (!dir.exists()) {
                        dir.mkdir();
                    }

                    File file = new File(dir, fileName);
                    if (file.exists()) {
                        System.out.println("file exists");
                        printStream.println("file exists");
                        socket.close();
                        return;
                    } else {
                        System.out.println("get fileName: " + fileName);
                        printStream.println("ok");
                    }


                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] data = new byte[8192];
                    int len = 0;
                    while ((len = inputStream.read(data)) != -1) {
                        fileOutputStream.write(data, 0, len);
                    }

                    printStream.println("upload success!!!");
                    fileOutputStream.close();
                    socket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
