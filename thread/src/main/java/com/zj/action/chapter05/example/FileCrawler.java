package com.zj.action.chapter05.example;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

/**
 * 遍历文件
 * Created by LZJ on 2015/12/8.
 */
public class FileCrawler implements Runnable {

    private final BlockingQueue<File> queue;

    private final FileFilter filter;

    private final File root;

    public FileCrawler(BlockingQueue<File> queue, FileFilter filter, File root) {
        this.queue = queue;
        this.filter = filter;
        this.root = root;
    }

    @Override
    public void run() {
        try {
            crawl(root);
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    private void crawl(File root) throws Exception {
        File[] entries = root.listFiles();
        if (entries != null) {
            for (File entry : entries) {
                if (entry.isDirectory()) {
                    crawl(entry);
                } else if (!alreadyIndexed(entry)) {
                    queue.put(entry);
                }
            }
        }
    }

    private boolean alreadyIndexed(File f) {
        boolean result = false;
        if (queue.contains(f)) {
            result = true;
        }
        return result;
    }


}


