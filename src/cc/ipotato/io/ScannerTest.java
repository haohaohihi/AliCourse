package cc.ipotato.io;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数据：");
        if (scanner.hasNext()){
            System.out.println("输入内容："+ scanner.next());
        }
        scanner.close();
    }
}
