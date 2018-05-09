package cc.ipotato.HeimaExercises;

import java.io.File;

/**
 * Created by haohao on 2018/5/4.
 */
public class DeleteDirectory {
    public static void main(String[] args) {
        File dir = DirectorySizeCount.getDirectory();
        deleteDirectory(dir);
    }

    public static void deleteDirectory(File dir) {
        System.out.println(dir);
        File[] subFiles = dir.listFiles();
        for (File subFile: subFiles) {
            if (subFile.isFile()) {
                subFile.delete();
            } else {
                deleteDirectory(subFile);
            }
        }
        dir.delete();
    }
}
