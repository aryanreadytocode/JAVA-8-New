package main.cursor_collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(null);
        System.out.println(set.add(null));
        System.out.println(set);
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}
