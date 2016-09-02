package com.zj.model;

/**
 * Created by LZJ on 2015/12/7.
 */
public interface UserFactory<U extends User> {

    U create(String name, Integer age);

}
