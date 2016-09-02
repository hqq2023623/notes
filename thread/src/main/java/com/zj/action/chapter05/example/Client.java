package com.zj.action.chapter05.example;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by LZJ on 2015/12/8.
 */
public class Client {

    public static void main(String[] args) {

        BlockingQueue<File> queue = new LinkedBlockingQueue<>();
        FileFilter filter = filename -> false;
        File[] roots = new File("c:/123").listFiles();

        for (File root : roots) {
            new Thread(new FileCrawler(queue, filter, root)).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(new Indexer(queue)).start();
        }

    }

}
