package cc.ipotato.io;

import jdk.internal.util.xml.impl.Input;

import java.io.*;

/**
 * Created by Hello on 2017/11/7.
 */

class CopyUtil {
    private CopyUtil(){}

    /**
     * 根据输入的路径信息判断文件是否存在
     * @param path 输入的路径信息
     * @return 若路径存在返回true，不存在则返回false
     */
    public static boolean fileExists(String path){
        return new File(path).exists();
    }

    public static void createParentDirectory(String path){
        File file = new File(path);
        if(! file.getParentFile().exists())
            file.getParentFile().mkdirs();
    }

    public static boolean copy(String src, String des){
        boolean flag=false;
        File srcFile = new File(src);
        File desFile = new File(des);
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(srcFile);
            output = new FileOutputStream(desFile);
            copyHandle(input, output);
            flag = true;
        } catch (IOException e){
            e.printStackTrace();
            flag = false;
        } finally {
            try{
                input.close();
                output.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return flag;
    }

    private static void copyHandle(InputStream input, OutputStream output) throws IOException {
        long start = System.currentTimeMillis();
//        do{
//            temp = input.read();
//            output.write(temp);
//        } while (temp != -1);
        int temp;
        byte[] data = new byte[100];
        while ((temp = input.read(data)) != -1){
            output.write(data, 0, temp);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制文件花费时间：" + (end - start));
    }
}

public class CopyFileTest {
    public static void main(String[] args) {
        if (args.length != 2){
            System.out.println("输入路径错误");
            System.exit(1);
        }

        if(CopyUtil.fileExists(args[0])){
            CopyUtil.createParentDirectory(args[1]);
            System.out.println((CopyUtil.copy(args[0], args[1])) ? "文件拷贝成功！" : "文件拷贝失败！");
        }
        else{
            System.out.println("源文件不存在");
            System.exit(1);
        }
    }
}
