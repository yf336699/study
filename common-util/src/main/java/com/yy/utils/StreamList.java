package com.yy.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * List集合取交集、并集、差集、去重并集
 * @author 12802
 */
public class StreamList {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("A", "B", "C", "D", "E");
        List<String> list2 = Arrays.asList("D", "F", "G", "H", "A");

        StreamList streamList = new StreamList();
        streamList.getInterSection(list1, list2);
        streamList.getReduce(list1, list2);
    }

    /**
     * 交集
     * @param list1
     * @param list2
     */
    private void getInterSection(List<String> list1, List<String> list2){
        List<String> collect = list1.stream().filter(item -> list2.contains(item)).collect(Collectors.toList());
        System.out.println("交集 = " + collect);
    }

    /**
     * 差集
     * @param list1
     * @param list2
     */
    private void getReduce(List<String> list1, List<String> list2){
        List<String> collect = list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());
        System.out.println("差集 [list1 - list2] = " + collect);
    }

    /**
     * 并集
     * @param list1
     * @param list2
     */
    private void getListAll(List<String> list1, List<String> list2){
    }


    /**
     * 去重并集
     * @param list1
     * @param list2
     */
    private void getListAllDistinct(List<String> list1, List<String> list2){

    }


}
