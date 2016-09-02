package com.zj.visitor010;

/**
 * Created by LZJ on 2015/12/3.
 */
public class ShoppingCartClient {

    /**
     * 访问者模式的好处是如果操作的逻辑改变，我们只需要改变访问者的实现就够了，而不用去修改其他所有的商品类
     */
    public static void main(String[] args) {
        ItemElement[] items = new ItemElement[]{new Book(20, "1234"), new Book(100, "5678"),
                new Fruit(10, 2, "Banana"), new Fruit(5, 5, "Apple")};

        int total = calculatePrice(items);
        System.out.println("Total Cost = " + total);
    }

    private static int calculatePrice(ItemElement[] items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum = 0;
        for (ItemElement item : items) {
            sum = sum + item.accept(visitor);
        }
        return sum;
    }

}
