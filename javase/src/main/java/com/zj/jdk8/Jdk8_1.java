package com.zj.jdk8;

import com.zj.model.User;
import com.zj.model.UserFactory;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;

/**
 * JDK8的新特性
 * Created by LZJ on 2015/12/7.
 */
public class Jdk8_1 {

    //Lambda表达式
    public void lambda() {
        //匿名对象的实现对字符串的排序
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        //
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        //对于函数体只有一行代码的，你可以去掉大括号{}以及return关键字
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        //Java编译器可以自动推导出参数类型，所以你可以不用再写一次类型
        Collections.sort(names, (a, b) -> b.compareTo(a));

        //在lambda表达式中访问外层作用域和老版本的匿名对象中的方式很相似。你可以直接访问标记了final的外层局部变量，或者实例的字段以及静态变量。


    }

    //函数式接口
    public void functionalInterface() {
        //输入String返回Integer
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted + "---" + (converted instanceof Integer));

        //Java 8 允许你使用 :: 关键字来传递方法或者构造函数引用
        converter = Integer::valueOf;

        //也可以引用一个对象的方法
        User u = new User();
        u.setName("lzj");
        converter = u::getAge;
        //调用构造函数
        UserFactory<User> uf = User::new;
        u = uf.create("lzj2", 22);
    }

    //Function接口
    public void functionI() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        backToString.apply("123");
    }

    //Stream接口
    public void stream() {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        //Filter过滤
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        //sort排序
        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        //map映射
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

        //match匹配
        boolean anyStartsWithA =
                stringCollection
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));
        System.out.println(anyStartsWithA);      // true
        boolean allStartsWithA =
                stringCollection
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));
        System.out.println(allStartsWithA);      // false
        boolean noneStartsWithZ =
                stringCollection
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));
        System.out.println(noneStartsWithZ);      // true

        //count计数
        long startsWithB =
                stringCollection
                        .stream()
                        .filter((s) -> s.startsWith("b"))
                        .count();

        //reduce规约
        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);

    }

    //Clock类提供了访问当前日期和时间的方法，Clock是时区敏感的，可以用来取代 System.currentTimeMillis() 来获取当前的微秒数。某一个特定的时间点也可以使用Instant类来表示，Instant类也可以用来创建老的java.util.Date对象。
    public void clock() {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);   // legacy java.util.Date
    }

    //本地时间
    public void localTime() {

        System.out.println(ZoneId.getAvailableZoneIds());
// prints all available timezone ids
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());
// ZoneRules[currentStandardOffset=+01:00]
// ZoneRules[currentStandardOffset=-03:00]

        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        System.out.println(now1.isBefore(now2));  // false
        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
        System.out.println(hoursBetween);       // -3
        System.out.println(minutesBetween);     // -239
    }


}
