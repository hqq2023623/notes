package zj.framework.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author Lzj Created on 2016/3/20.
 */
public class TestCallable {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        List<Future<Integer>> resultList = new ArrayList<>();
        Random random = new Random();
        //生成一个介于0~10之间的随机整数
        for (int i = 0; i < 10; i++) {
            Integer number = random.nextInt(10);
            FactorialCalculator calculator = new FactorialCalculator(number);
            //传递一个Callable对象给执行器去执行
            Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
        }
        //创建一个do循环来监控执行器的状态
        do {
            System.err.println("Main : Number of Completed Tasks : " + executor.getCompletedTaskCount());
            //遍历resultList列表中的10个Future对象，通过调用isDonw()方法来显示任务是否完成的信息
            for (int i = 0; i < resultList.size(); i++) {
                Future<Integer> result = resultList.get(i);
                if (result.isDone()) {
                    System.err.println("Main : Task " + i + "   " + result.isDone());
                } else {
                    System.out.println("Main : Task " + i + "   " + result.isDone());
                }
            }
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (executor.getCompletedTaskCount() < resultList.size());


        //在控制台输出每一个任务得到的结果，通过Future.get()
        System.out.println("Main : Results ");
        for (int i = 0; i < resultList.size(); i++) {
            Future<Integer> result = resultList.get(i);
            Integer number = null;
            try {
                number = result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("Main: Task " + i + "   " + number);
        }

        //关闭执行器
        executor.shutdown();


    }


}
