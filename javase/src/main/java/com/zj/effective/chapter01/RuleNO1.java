package com.zj.effective.chapter01;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * RuleNO1:考虑使用静态工厂方法代替构造器<br/>
 * <p>
 * 其与构造器相比的优势:
 * </p>
 * <p>
 * 1.静态工厂方法有名称,代码可读性高,当一个类需要多个构造方法时可以用静态工厂方法代替
 * </p>
 * <p>
 * 2.不必在每次调用的时候新建一个对象
 * </p>
 * <p>
 * 3.可以返回原类型的任何子类对象,使用接口引用返回的对象,有利于面向接口编程
 * </p>
 * <p>
 * 4.在创建参数化实例类型的时候,可以使代码变得更简洁,Map<String,List<Object>> map =
 * HaspMap.newInstance(); Map<String,List<Object>> map = new
 * HashMap<String,List<Object>>(); jdk1.8已经可以自动推导类型
 * </p>
 * <p>
 * 静态工厂方法的缺点：
 * </p>
 * <p>
 * 1.类如果不含有共有的的或者受保护的构造器,就不能被子类化
 * </p>
 *
 * @author lzj 2015年10月30日
 */
public class RuleNO1 {

    @Test
    public void test01() {

    }

}

// 服务提供者基本架构:
// 1.服务接口,由提供者实现
// 2.提供者注册API,系统用来注册实现,让客户端访问它们
// 3.服务访问API,客户端用来获取服务的实例

// 服务接口
interface Service {
}

// 服务提供者
interface Provider {
    Service newInstance();
}

class Services {
    private Services() {
    }

    private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();
    // 默认的提供者名称
    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    // 提供者注册API
    public static void registerDefaultProvider(Provider p) {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, Provider p) {
        providers.put(name, p);
    }

    // 服务访问API
    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name) {
        Provider p = providers.get(name);
        if (p == null) {
            try {
                throw new Exception("木有该名称的提供者");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return p.newInstance();
    }

}