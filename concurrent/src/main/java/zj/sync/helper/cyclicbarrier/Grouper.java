package zj.sync.helper.cyclicbarrier;

/**
 * 基于Results计算在矩阵中查找到的总次数。
 * 这是传给CyclicBarrier的Runnable对象
 *
 * @author Lzj Created on 2016/3/19.
 */
public class Grouper implements Runnable {

    private Results results;

    public Grouper(Results results) {
        this.results = results;
    }

    @Override
    public void run() {
        int finalResult = 0;
        System.out.println("Grouper : Processing results...");
        int data[] = results.getData();
        for (int number : data) {
            finalResult += number;
        }
        System.out.println("Grouper : Total results = " + finalResult);
    }


}
