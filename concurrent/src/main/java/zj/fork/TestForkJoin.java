package zj.fork;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @author Lzj Created on 2016/3/20.
 */
public class TestForkJoin {

    public static void main(String[] args) {

        ProductListGenerator generator = new ProductListGenerator();
        List<Product> products = generator.generate(10000);

        ProductTask task = new ProductTask(products, 0, products.size(), 0.2);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.execute(task);

        //显示关于线程池演变的信息
        do {
            System.out.println("Main : Thread Count : " + forkJoinPool.getActiveThreadCount());
            System.out.println("Main : Thread Steal : " + forkJoinPool.getStealCount());
            System.out.println("Main : Parallelism : " + forkJoinPool.getParallelism());
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());
        forkJoinPool.shutdown();

        //检查任务是否已经完成并且没有错误
        if (task.isCompletedNormally()) {
            System.out.println("Main : The process has completed normally");
        }

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getPrice() != 12) {
                System.out.println("Product " + product.getName() + "  price is " + product.getPrice());
            }
        }

        System.err.println("Main : End of the program");

    }


}
