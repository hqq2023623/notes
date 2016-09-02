package zj.lock.condition;

/**
 * 文件模拟类
 *
 * @author Lzj Created on 2016/3/17.
 */
public class FileMock {

    //文件内容
    private String content[];
    //读取内容的行号
    private int index;

    public FileMock(int size, int length) {
        content = new String[size];
        for (int i = 0; i < size; i++) {
            StringBuilder builder = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                int indice = (int) Math.random() * 255;
                builder.append((char) indice);
            }
            content[i] = builder.toString();
        }
        index = 0;
    }


    //是否还有下一行
    public boolean hasMoreLines() {
        return index < content.length;
    }

    //返回属性index指定的行内容，并且自动指向下一行
    public String nextLine() {
        if (hasMoreLines()) {
            System.out.println("Mock : " + (content.length - index));
            return content[index++];
        }
        return null;
    }


}
