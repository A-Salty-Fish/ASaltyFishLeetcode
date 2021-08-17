package com.example.java.Tecent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author dzy
 * @title: XNode
 * @projectName Java
 * @description: 删除链表中和为0的区间
 * @date 2021/8/16 17:50
 */
public class XNode {
    int value;
    XNode next;
//
//    // 删除链表中和为0的区间
//    XNode deleteZeroSumNodes(XNode list) {
//        // 前缀和
//        List<Integer> pre = new ArrayList<>();
//        LinkedHashMap<Integer, List<Integer>> pre2Indexes = new LinkedHashMap<>();
//        pre.add(0);
//        int index = 0;
//        while (list != null) {
//            int curPreSum = list.value + pre.get(pre.size() - 1);
//            pre.add(curPreSum);
//            List<Integer> indexes = pre2Indexes.getOrDefault(curPreSum, new ArrayList<>());
//            indexes.add(curPreSum);
//            pre2Indexes.put(curPreSum, indexes);
//            list = list.next;
//        }
//        // 搜索为 0 的区间
//        for (Integer preSum : pre2Indexes.keySet()) {
//            if (pre2Indexes.get(preSum).size() > 1) {
//                // todo 删除
//            }
//        }
//    }
}
