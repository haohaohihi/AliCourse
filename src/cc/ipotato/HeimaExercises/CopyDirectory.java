package cc.ipotato.HeimaExercises;

import java.io.*;

/**
 * Created by haohao on 2018/5/4.
 */
public class CopyDirectory {
    public static void main(String[] args) throws IOException{
        File src = DirectorySizeCount.getDirectory();
        File dest = DirectorySizeCount.getDirectory();
        copy(src, dest);
    }

    public static void copy(File src, File dest) throws IOException {
        File newDir = new File(dest, src.getName());
        newDir.mkdir();
        File[] subFiles = src.listFiles();
        for (File subFile: subFiles) {
            if (subFile.isFile()) {
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(subFile));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(newDir, subFile.getName())));
                int d;
                while ((d = bis.read()) != -1) {
                    bos.write(d);
                }
                bis.close();
                bos.close();
            } else {
                copy(subFile, newDir);
            }
        }
    }
}
