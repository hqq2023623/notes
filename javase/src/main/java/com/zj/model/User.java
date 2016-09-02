package com.zj.model;

/**
 * Created by LZJ on 2015/12/7.
 */
public class User {

    private String name;

    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge(String s) {
        return Integer.valueOf(s);
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
