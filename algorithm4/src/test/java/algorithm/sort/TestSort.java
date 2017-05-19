package algorithm.sort;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import zj.sort.SortTemplate;

/**
 * Created by lzj on 2017/5/19.
 */
public class TestSort {

    Integer a[];
    SortTemplate sortTemplate;

    @Before
    public void setUp() {
        a = new Integer[]{9, 1, 4, 8, 6, 3, 7, 2, 5};
    }


    /**
     *
     */
    @Test
    public void testBubble() throws Exception {
        sortTemplate = new BubbleSort();
        sortTemplate.doSort(a);
        assertTrue(sortTemplate.isSorted(a));

    }

    /**
     *
     */
    @Test
    public void testSelect() throws Exception {
        sortTemplate = new SelectSort();
        sortTemplate.doSort(a);
        assertTrue(sortTemplate.isSorted(a));

    }

    /**
     *
     */
    @Test
    public void testInsertction() throws Exception {
        sortTemplate = new InsertSort();
        sortTemplate.doSort(a);
        assertTrue(sortTemplate.isSorted(a));

    }


    /**
     *
     */
    @Test
    public void testShellSort() throws Exception {
        sortTemplate = new ShellSort();
        sortTemplate.doSort(a);
        assertTrue(sortTemplate.isSorted(a));

    }

    /**
     *
     */
    @Test
    public void testMerge() throws Exception {
        sortTemplate = new MergeSort();
        sortTemplate.doSort(a);
        assertTrue(sortTemplate.isSorted(a));

    }

}
