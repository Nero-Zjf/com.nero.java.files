package com.nero.java.files.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class PathTest {
    public static void main(String[] args) throws IOException {
        //Path path = create();//创建文件/目录
        //write(path);//文件写操作
        //read(path);//读取文件
        //iterate1();//遍历一个文件夹1
        //iterate2();//遍历一个文件夹2
    }

    /**
     * 创建文件/目录
     */
    public static Path create() throws IOException {
        //创建目录
        Files.createDirectory(Paths.get("d:\\test"));
        //Files.createDirectories(Paths.get("d:\\test\test1\test2"));//会创建不存在的父级文件夹
        Path path = Paths.get("d:\\1.txt");//如果使用相对路径则在工作目录
        //Path path1 = FileSystems.getDefault().getPath("1.txt");
        //创建文件
        //Set perms = PosixFilePermissions.fromString("rw-rw-rw-");//windows系统不支持设置rwx权限
        //FileAttribute attrs = PosixFilePermissions.asFileAttribute(perms);
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        return path;
    }

    /**
     * 文件写操作
     */
    public static void write(Path path) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
            writer.write("测试文件写操作");
            writer.flush();
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 读取文件
     */
    public static void read(Path path) {
        try {
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String str = null;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历一个文件夹1
     */
    private static void iterate1() {
        Path dir = Paths.get("D:\\NERO");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path e : stream) {
                System.out.println(e.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历一个文件夹2
     */
    private static void iterate2() {
        Path dir = Paths.get("D:\\NERO");
        try (Stream stream = Files.list(dir)){
            Iterator ite = stream.iterator();
            while(ite.hasNext()){
                Path pp = (Path) ite.next();
                System.out.println(pp.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static class FindJavaVisitor extends SimpleFileVisitor<Path>{
        private List result;
        public FindJavaVisitor(List result){
            this.result = result;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if(file.toString().endsWith(".java")){
                result.add(file.getFileName());
                System.out.println(file.getFileName());
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
