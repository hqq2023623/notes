package zj.sort;

/**
 * Created by lzj on 2017/5/19.
 */
public abstract class SortTemplate {

    protected abstract void sort(Comparable[] a);

    public void doSort(Comparable[] a) {
        System.out.print("origin : ");
        show(a);
        sort(a);
    }

    protected boolean lessThan(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void show(Comparable[] a) {
        for (Comparable comparable : a) {
            System.out.print(comparable + "\t");
        }
        System.out.println();
    }

    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (lessThan(a[i], a[i - 1])) {
                show(a);
                return false;
            }
        }
        return true;
    }


}
