package com.zj.visitor010;

/**
 * Created by LZJ on 2015/12/3.
 */
public interface ItemElement {

    int accept(ShoppingCartVisitor visitor);

}
