package main.cursor_collection;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetExample {

    public static void main(String[] args) {
        SortedSet<StringBuffer> set = new TreeSet<>();
        set.add(new StringBuffer("A"));
        set.add(new StringBuffer("Z"));
        set.add(new StringBuffer("L"));
        System.out.println(set.add(new StringBuffer("A")));
        System.out.println(set);


    }
}
