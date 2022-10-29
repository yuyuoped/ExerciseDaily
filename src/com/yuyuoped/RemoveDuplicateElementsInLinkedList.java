package com.yuyuoped;

import java.util.*;

public class RemoveDuplicateElementsInLinkedList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < 6; i++) {
            linkedList.add(sc.next());
        }

        LinkedList<String> lis = Solution7.Weighting(linkedList);

        Iterator<String> it = lis.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        sc.close();
    }
}

class Solution7 {

    public static LinkedList<String> Weighting(LinkedList<String> list) {

        // write your code here
        LinkedList<String> newList = new LinkedList<>();
        Set<String> set = new HashSet<>();

        while (!list.isEmpty()) {
            String s = list.pop();
            if (!set.contains(s)) {
                set.add(s);
                newList.add(s);
            }
        }

        return newList;
    }

}
