package main.cursor_collection;

import java.util.LinkedHashSet;
import java.util.Set;

public class LInkedHashSetExample {

    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<Integer>();
        set.add(5);
        set.add(1);
        set.add(8);
        set.add(null);
        System.out.println(set);
    }
}
