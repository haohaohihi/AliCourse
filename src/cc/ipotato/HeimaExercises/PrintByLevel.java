package cc.ipotato.HeimaExercises;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by haohao on 2018/5/4.
 */
public class PrintByLevel {
    public static void main(String[] args) {
        printByLevel(DirectorySizeCount.getDirectory(), 0);
    }

    public static void printByLevel(File f, int level) {
        File[] subFiles = f.listFiles();
        StringBuilder sb = new StringBuilder();
        for (File subFile: subFiles) {
            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }
            System.out.println(subFile.getName());
            if (subFile.isDirectory()) {
                printByLevel(subFile, level + 1);
            }
        }
    }
}