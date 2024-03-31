package main;

final class ImmutableClass {
    private final String name;
    private final int age;

    public ImmutableClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public static void main(String[] args) {
        ImmutableClass cs = new ImmutableClass("Raj", 31);
        System.out.println(cs);
        String s = new String("Aryan");
        String s1 = "Aryan";
        System.out.println(s.equals(s1));
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
