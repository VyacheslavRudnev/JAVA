package program;

import program.classes.Fish;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        final double PI = 3.14159265358;
        byte a = 50;
        byte b = (byte) (a*2);
        System.out.println(a);
        System.out.println(b);

        int [] ar1;
        int [] ar2 = new int[100];
        String s1 = "hello";
        char [] c1 = {'a','b','c'};
        String s2 = new String(c1);
        System.out.println("s2:" + s2);

        double d1 = 1;
        double d2 = 0;
        System.out.println("d1/d2=" + d1/d2);

        Fish f1 = new Fish("salmon", 4, 120);
        System.out.println("f1=" + f1);
    }
}