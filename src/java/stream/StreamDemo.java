package stream;


import stream.entity.Fruit;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class StreamDemo {
    private static List<Fruit> list = new ArrayList<>();
    static {
        list.add(new Fruit(1L,"苹果",1,"红色"));
        list.add(new Fruit(1L,"苹果",5,"红色"));
        list.add(new Fruit(1L,"苹果",1,"绿色"));
        list.add(new Fruit(1L,"梨",1,"黄色"));
        list.add(new Fruit(1L,"梨",5,"绿色"));
        list.add(new Fruit(1L,"梨",1,"绿色"));
        list.add(new Fruit(1L,"香蕉",1,"黄色"));
        list.add(new Fruit(1L,"香蕉",5,"黄色"));
        list.add(new Fruit(1L,"香蕉",1,"绿色"));
    }

    public static void main(String[] args) {
        //按水果重量倒序排序
        list.stream().sorted(comparing(Fruit::getWeight).reversed()).forEach(System.out::println);
        //找出每种水果里重量最重的（按子组收集数据）
        list.stream().collect(groupingBy(Fruit::getName, Collectors.collectingAndThen(
                maxBy(comparingInt(Fruit::getWeight)),
                Optional::get))).forEach((k,v)-> System.out.println(v));
        //移除重量大于一的水果
        System.out.println(list.removeIf(fruit -> fruit.getWeight()>1));
        list.forEach(System.out::println);

    }
}
