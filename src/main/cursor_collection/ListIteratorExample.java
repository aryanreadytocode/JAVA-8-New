package main.cursor_collection;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;

public class ListIteratorExample {
    public static void main(String[] args) {
        LinkedList<Integer> v = new LinkedList<>();

        for (int i = 0; i< 10; i++) {
            v.add(i);
        }
        System.out.println(v);
        ListIterator<Integer> itr = v.listIterator();
        while (itr.hasNext()) {
            Integer i = itr.next();
            if (i%3 ==0) {
                itr.remove();
            }
            if (i%2 ==0) {
                itr.add(i*2);
            }
        }
        System.out.println(v);
    }
}
