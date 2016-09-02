package zj.fork;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lzj Created on 2016/3/20.
 */
public class ProductListGenerator {

    //生成一个随机产品列表
    public List<Product> generate(int size) {
        List<Product> result = new ArrayList<>();
        Product product;
        for (int i = 0; i < size; i++) {
            product = new Product();
            product.setName("Product " + i);
            product.setPrice(10);
            result.add(product);
        }
        return result;
    }


}
