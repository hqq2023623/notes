package test.io;

import org.junit.Test;

import java.io.*;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class TestReader {

    @Test
    public void test01() throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader(new File(TestReader.class.getClassLoader().getResource("files/f1.txt").getFile())));
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = reader.readLine()) != null) {
            sb.append(s).append("\r\n");
        }
        System.out.println(sb);
        reader.close();


    }

    @Test
    public void testPrintWriter() throws Exception {

        File f1 = new File(TestReader.class.getClassLoader().getResource("files/f1.txt").getFile());
        File f2 = new File(TestReader.class.getClassLoader().getResource("files/f2.txt").getFile());
        BufferedReader reader = new BufferedReader(new FileReader(f1));
        PrintWriter pw = new PrintWriter(f2);
        int lineCount = 1;
        String s;
        while ((s = reader.readLine()) != null) {
            pw.println(lineCount++ + s);
        }
        reader.close();
        pw.close();

    }


}
