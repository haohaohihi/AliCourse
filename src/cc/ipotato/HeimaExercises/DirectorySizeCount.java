package cc.ipotato.HeimaExercises;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 从键盘接收一个文件夹路径,统计该文件夹大小
 * Created by haohao on 2018/5/4.
 */
public class DirectorySizeCount {
    public static void main(String[] args) {
        File d = getDirectory();
        System.out.println(getFileLength(d));
    }

    public static File getDirectory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入合理的目录路径：");
        while (true) {
            String line = scanner.nextLine();
            File f = new File(line);
            if (f.isDirectory()) {
                return f;
            } else {
                System.out.println("输入错误，请输入正确的目录路径：");
            }
        }
    }

    public static long getFileLength(File dir) {
        long len = 0;
        File[] subFiles = dir.listFiles();
        for (File subFile : subFiles) {
            if (subFile.isFile()) {
                len += subFile.length();
            } else {
                len += getFileLength(subFile);
            }
        }
        return len;
    }
}
