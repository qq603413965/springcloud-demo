package com.wushuaiping.springcloud.jdk8stream;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @another: wushuaiping
 * @date: 2018/4/25 下午5:00
 * @description:
 */
public class StreamDemo {

    static List<String> list = Arrays.asList("a1", "a1", "a21", "b1", "c2", "c1", "a11");

    public static void main(String[] args) {
        //filter();
        //distinct();
        sorted();
    }

    // filter 中间操作 过滤
    public static void filter(){
        // 打印集合中长度为3的字符串
        list
                .stream()
                .filter(str -> str.length() == 3)
                .forEach(str -> System.out.println(str));
        // 打印集合中为"a1"的字符串
        list
                .stream()
                .filter(str -> str.equals("a1"))
                .forEach(s -> System.out.println(s));

    }

    // 去除集合中重复的元素
    public static void distinct(){
        list
                .stream()
                .distinct()
                .forEach(str -> System.out.println(str));
    }

    // 排序
    public static void sorted(){
        list
                .stream()
                .sorted()
                .forEach(str -> System.out.print(str));
    }

}
