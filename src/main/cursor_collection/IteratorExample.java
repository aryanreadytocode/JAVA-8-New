package main.cursor_collection;

import java.util.*;

public class IteratorExample {

    public static void main(String[] args) {
        LinkedHashSet<Integer> v = new LinkedHashSet<>();

        for (int i = 0; i< 10; i++) {
            v.add(i);
        }
        System.out.println(v);
        Iterator<Integer> itr = v.iterator();
        while (itr.hasNext()) {
            Integer value = itr.next();
            if (value % 2 != 0) {
                System.out.println(value);
                itr.remove();
            }
        }
        System.out.println(v);
    }
}
