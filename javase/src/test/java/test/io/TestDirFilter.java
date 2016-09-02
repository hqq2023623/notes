package test.io;

import com.zj.tij.io.file.DirFilter;
import org.junit.Test;

import java.io.File;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class TestDirFilter {

    @Test
    public void test01() throws Exception {



        String[] fileNames;

        File f = new File(TestDirFilter.class.getClassLoader().getResource("files").getFile());
        if (f.exists()) {
            fileNames = f.list(new DirFilter(".*"));
            for (String s : fileNames) {
                System.out.println(s);
            }
        }

    }


}
