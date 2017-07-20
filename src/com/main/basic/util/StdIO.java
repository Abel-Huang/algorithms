package com.main.basic.util;

/**
 * Created by huangjinajin on 2017/7/19.
 * 使用这个工具类可以简化输入输出
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
     * Array output without wrap
     */
    public static void print(Comparable[] a){
        for(int i=0;i<a.length;i++){
            if (i==a.length-1){
                System.out.println(a[i]);
                return;
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
