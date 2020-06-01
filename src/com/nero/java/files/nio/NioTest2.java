package com.nero.java.files.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

/**
 * 测试 遍历整个目录（包含子级目录）
 */
public class NioTest2 {
    public static void main(String[] args) throws IOException {
        Path startingDir = Paths.get("D:\\NERO");
        List result = new LinkedList();
        Files.walkFileTree(startingDir, new FindJavaVisitor(result));
        System.out.println("result.size()=" + result.size());
    }


    private static class FindJavaVisitor extends SimpleFileVisitor<Path> {
        private List result;

        public FindJavaVisitor(List result) {
            this.result = result;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().endsWith(".java")) {
                result.add(file.getFileName());
                System.out.println(file.getFileName());
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
