package zj.fork;


import java.io.Serializable;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * @author Lzj Created on 2016/3/20.
 */
public class ProductTask extends RecursiveAction {

    //添加serialVersionUID
    private static final long serialVersionUID = 8087026114582542413L;

    private List<Product> products;
    private int first;
    private int last;
    private double increment;

    public ProductTask(List<Product> products, int first, int last, double increment) {
        this.products = products;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    @Override
    protected void compute() {
        //一个任务只更新少于10件产品的价格
        if (last - first < 10) {
            updatePrices();
        } else {
            //二分
            int middle = (first + last) / 2;
            System.out.println("Task : Pending tasks " + getQueuedTaskCount());
            ProductTask t1 = new ProductTask(products, first, middle + 1, increment);
            ProductTask t2 = new ProductTask(products, middle + 1, last, increment);
            invokeAll(t1, t2);
        }
    }

    private void updatePrices() {
        for (int i = first; i < last; i++) {
            Product product = products.get(i);
            product.setPrice(product.getPrice() * (1 + increment));
        }
    }


}
