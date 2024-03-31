package main;

import javax.lang.model.element.VariableElement;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionApiExample {
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("main.Emp");
        // Constructor array
        Constructor[] constructors = c.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("Name of constructor : "+constructor);
            System.out.println("Count of constructor param"+constructor.getParameterCount());
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Constructor's parameter :"+parameter);
            }
            System.out.println();
        }
        System.out.println();
        // Method array

        Method[] methods = c.getDeclaredMethods();
        System.out.println("Length of method : "+methods.length);
        for (Method method : methods) {
            System.out.println("Method name: \t"+method);
            System.out.println("Method return type : \t"+method.getReturnType());
            System.out.println("Method parameter count: \t"+method.getParameterCount());
            System.out.println();
            Parameter[] parameters = method.getParameters();
            for(Parameter parameter : parameters) {
                System.out.println("Method's Parameter : "+parameter);
            }
            System.out.println();
        }
        System.out.println();
//        Annotations
        Class[] classes = c.getDeclaredClasses();
        for(Class class1 : classes) {
            System.out.println("class: "+class1);
            System.out.println("Name of class: "+class1.getName());
        }
//        Annotations
        Annotation[] anno = c.getDeclaredAnnotations();
        for(Annotation annotation : anno) {
            System.out.println("Annotation: "+annotation);
        }

        // variables
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Fields :"+field);
        }
    }
}

class Emp {
    private int eid;
    private double esal;
    private String ename;

    enum Week {
        SUN, TUE, WED
    }

    @interface MyAnno{

    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public double getEsal() {
        return esal;
    }

    public void setEsal(double esal) {
        this.esal = esal;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Emp(int eid, double esal, String ename) {
        this.eid = eid;
        this.esal = esal;
        this.ename = ename;
    }

    class A {

    }
    class B {

    }
}
