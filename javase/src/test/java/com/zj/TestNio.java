package com.zj;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class TestNio {

    private static final String FILE = "nio.txt";

    /**
     * FileChannel读取文件
     */
    @Test
    public void testFile() throws Exception {

        FileInputStream fis = new FileInputStream(TestNio.class.getClassLoader().getResource("nio.txt").getFile());

        FileChannel fileChannel = fis.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);
        int bytesRead = fileChannel.read(buf);
        int count = 0;
        //一次循环读1024个字节
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            buf.clear();
            bytesRead = fileChannel.read(buf);
            count++;
        }
        fileChannel.close();

    }


}
