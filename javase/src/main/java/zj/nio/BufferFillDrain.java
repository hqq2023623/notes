package zj.nio;

import java.nio.CharBuffer;

/**
 * 对缓冲区的填充和读取操作--get()和put()
 *
 * @author Lzj Created on 2015/12/18.
 */
public class BufferFillDrain {


    private static int index = 0;

    private static String[] strings = {
            "A random string value",
            "The product of an infinite number of monkeys",
            "Hey hey we're the Monkees",
            "Opening act for the Monkees: Jimi Hendrix",
            "'Scuse me while I kiss this fly",  // Sorry Jimi ;-)
            "Help Me!  Help Me!",
    };

    public static void main(String[] argv)
            throws Exception {
        //设置positon和limit为1024
        CharBuffer buffer = CharBuffer.allocate(1024);
        //每次读取一个字符串填充到缓冲区,然后从缓冲区读取该字符串并清空缓冲区
        while (fillBuffer(buffer)) {
            buffer.flip();
            drainBuffer(buffer);
            buffer.clear();
        }
    }

    //打印缓冲区数据
    private static void drainBuffer(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get());
        }
        System.out.println("");
    }

    //填充数据到缓冲区
    private static boolean fillBuffer(CharBuffer buffer) {
        //读取完毕
        if (index >= strings.length) {
            return (false);
        }
        //从字符串数组中获取某个字符串
        String string = strings[index++];
        //填充字符串到缓冲区
        for (int i = 0; i < string.length(); i++) {
            buffer.put(string.charAt(i));
        }
        return true;
    }
}
