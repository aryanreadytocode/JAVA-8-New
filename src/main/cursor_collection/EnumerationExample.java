package main.cursor_collection;

import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class EnumerationExample {

    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();

        for (int i = 0; i< 10; i++) {
            v.add(i);
        }
        System.out.println(v);
        Enumeration<Integer> e = v.elements();
        while (e.hasMoreElements()) {
            Integer i = e.nextElement();
            if (i%2 ==0)
                System.out.print(i);
        }
        System.out.println(v);


    }
}
