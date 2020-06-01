package com.nero.java.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {
//       readAt();//从指定位置读取文件
       writeAt();//向文件中追加内容
    }

    /**
     * 从指定位置读取文件
     */
    private static void readAt() throws IOException {
        String filePath = "d:\\1.txt";
        RandomAccessFile raf = null;
        File file = null;
        try {
            file = new File(filePath);
            raf = new RandomAccessFile(file, "r");
            // 获取 RandomAccessFile对象文件指针的位置，初始位置为0
            System.out.println("输入内容：" + raf.getFilePointer());
            //移动文件记录指针的位置
            raf.seek(1000);

            byte[] b = new byte[1024];
            int hasRead = 0;
            //循环读取文件
            while ((hasRead = raf.read(b)) > 0) {
                //输出文件读取的内容
                System.out.print(new String(b, 0, hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                raf.close();
            }
        }
    }

    /**
     * 向文件中追加内容
     */
    private static void writeAt() throws IOException {
        String filePath = "d:\\1.txt";
        RandomAccessFile raf = null;
        File file = null;
        try {
            file = new File(filePath);
            raf = new RandomAccessFile(file, "rw");
            //追加到文件的末尾
            raf.seek(raf.length());
            raf.write("nero test insert string".getBytes(Charset.defaultCharset()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                raf.close();
                System.out.println("完成追加内容");
            }
        }
    }
}
