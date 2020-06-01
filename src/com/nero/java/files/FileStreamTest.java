package com.nero.java.files;

import java.io.*;

public class FileStreamTest {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\1.txt";
        //写入文件
        FileWriter writer = new FileWriter(filePath);
        writer.write("ewrwe\r\n");
        writer.write("trerf\r\n");
        writer.flush();
        writer.close();

        //读取文件
        FileInputStream in = new FileInputStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        in.close();
    }
}
