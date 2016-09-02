package zj.string;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Lzj Created on 2016/3/6.
 */
public class TestString {

    public static void main(String[] args) {
        String s1, s2, s3;
        //字符串常量，"ab" 和"abc"为相同类型
        s1 = "abc";
        //字符串对象，new String(s1)、new String(s1) + ""同类型
        s2 = new String(s1);
        //拘留字符串，获取的是对应字符串的常量地址
        // new String(s1).intern();和new String("abc").intern();同类型
        s3 = new String(s1).intern();

        System.out.println("常量 == 对象  " + (s1 == s2));
        System.out.println("常量 == intern() " + (s1 == s3));
        System.out.println("对象 == intern()   " + (s2 == s3));
    }
}
