package cn.abelib.basic.util;

/**
 * Created by huangjinajin on 2017/7/19.
 * ʹ�������������Լ��������
 */
public class StdIO {
    /**
     * @param s
     * String output without wrap
     */
    public static void print(String s){
        System.out.print(s);
    }

    /**
     * @param a
     */
    public static void print(Comparable a){
        println(a + "");
    }

    /**
     * @param i
     */
    public static void print(int i){
        print(i+" ");
    }

    /**
     * @param d
     */
    public static void print(double d){
        print(d+" ");
    }

    /**
     * @param c
     */
    public static void print(char c) {
        print(c+"");
    }
    /**
     * @param a
     * Array output without wrap
     */
    public static void print(Comparable[] a){
        for(int i=0;i<a.length;i++){
            if (i==a.length-1){
                System.out.println(a[i]);
                return;
            }
            if (i%10 == 9){
                println(a[i]);
                continue;
            }
            System.out.print(a[i]+" ");
        }
    }

    /**
     * @param s
     * String output with wrap
     */
    public static void println(String s){
        System.out.println(s);
    }

    /**
     * @param a
     */
    public static void println(Comparable a){
        println(a + "");
    }

    /**
     * @param d
     */
    public static void println(double d){
        println(d + "");
    }

    /**
     * @param i
     */
    public static void println(int i){
        println(i + "");
    }

    /**
     * @param c
     */
    public static void println(char c){
        println(c+"");
    }
    /**
     * @param a
     *Array output and each item newline
     */
    public static void println(Comparable[] a){
        for(Comparable c : a){
            System.out.println(c);
        }
    }

    /**
     * newline
     */
    public static void println(){
        System.out.println();
    }

    /**
     * @param format
     * @param args
     * Format output
     */
    public static void printf(String format, Object ... args){
        System.out.printf(format, args);
    }
}
