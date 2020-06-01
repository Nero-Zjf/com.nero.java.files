package com.nero.java.files;

import java.io.File;
import java.io.IOException;

public class FileTest {

    public static void main(String[] args) throws IOException {
//        createFile();//创建文件
//        createDir();//创建目录
//        deleteFile();//删除文件
//        getFileInfo();//获取文件信息

    }

    /**
     * 创建文件
     */
    private static void createFile() throws IOException {
        //将具体的路径封装成了File对象。可以封装存在的文件或目录，也可以封装不存在的文件或目录
        File file = new File("d:\\1.txt");
        System.out.println("file创建成功：" + file.createNewFile());//不存在文件则创建，存在文件则不创建。创建成功返回true，创建失败或没有创建返回false
        //File(String parent, String child)
        File file1 = new File("d:\\", "2.txt");
        System.out.println("file1创建成功：" + file1.createNewFile());

        File dir = new File("d:\\");
        File file2 = new File(dir, "2.txt");
        System.out.println("file2创建成功：" + file2.createNewFile());
    }

    /**
     * 创建文件夹
     */
    private static void createDir() throws IOException {
        //创建一级目录
        File file = new File("d:\\test");
        System.out.println("file文件夹创建成功：" + file.mkdir());

        //创建多级目录
        File file1 = new File("d:\\test1\\child");
        System.out.println("file1文件夹创建成功：" + file1.mkdirs());
    }

    /**
     * 删除文件或文件夹
     */
    private static void deleteFile() throws IOException {
        File file = new File("d:\\test");
        System.out.println("file删除成功：" + file.delete());//删除方法要慎用，其不走回车站。并且删除一个不存在的文件，返回false。
    }

    /**
     * 获取文件或文件夹的信息
     */
    private static void getFileInfo() throws IOException {
        File file = new File("d:\\");

        //判断消息
        System.out.println("exists：" + file.exists());//true
        System.out.println("isDirectory：" + file.isDirectory());//false
        System.out.println("isFile：" + file.isFile());//true
        System.out.println("isAbsolute：" + file.isAbsolute());//false
        System.out.println("isHidden：" + file.isHidden());//false
        System.out.println("canExecute：" + file.canExecute());//true
        //获取基本消息
        System.out.println("name：" + file.getName());
        System.out.println("length：" + file.length());
        System.out.println("parent：" + file.getParent());
        System.out.println("absolutePath：" + file.getAbsolutePath());
        System.out.println("path：" + file.getPath());
        System.out.println("lastModified：" + file.lastModified());

        //获取高级消息
        System.out.println("列出系统可以磁盘");
        File[] files = File.listRoots();
        for (File f :
                files) {
            System.out.println(f);
        }

        System.out.println("列出当前目录所有内容-String类型");
        String[] list = file.list();
        for (String str :
                list) {
            System.out.println(str);
        }

        System.out.println("列出当前目录所有内容-File类型");
        File[] list1 = file.listFiles();
        for (File f :
                list1) {
            System.out.println(f);
        }
    }
}
