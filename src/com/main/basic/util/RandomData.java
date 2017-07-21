package com.main.basic.util;

import java.util.Random;

/**
 * Created by huangjinajin on 2017/7/22.
 * 用于生成用于测试的随机数以及随机数组
 *
 * 值得注意的是对于生成一个随机double， 其范围是[0,range)
 * 其中range是参数：随机数取值范围
 *
 * 如果seed相同那么生成的随机数也相同
 */
public class RandomData {
    /**
     * @param seed
     * @param range
     * @return random int
     */
    public static int randInt(long seed, int range){
        Random random=new Random(seed);
        return random.nextInt(range);
    }

    /**
     * @param range
     * @return
     */
    public static int randInt(int range){
        long seed=System.currentTimeMillis();
        return randInt(seed, range);
    }

    /** create a random Integer array
     * @param seed
     * @param range
     * @param size
     * @return random Integer array
     */
    public static  Integer[] randIntegerArray(long seed, int range, int size) {
        Random random=new Random(seed);
        Integer [] integerArray=new Integer[size];
        for (int i=0; i<size; i++){
            integerArray[i]=random.nextInt(range);
        }
        return integerArray;
    }

    /**
     * @param range
     * @param size
     * @return
     */
    public static  Integer[] randIntegerArray(int range, int size) {
        long seed = System.currentTimeMillis();
        return randIntegerArray(seed, range, size);
    }

    /**
     * @param seed
     * @return random double
     */
    public static double randDouble(long seed){
        Random random=new Random(seed);
        return random.nextDouble();
    }

    /**
     * @return random double
     */
    public static double randDouble(){
        long seed=System.currentTimeMillis();
        return randDouble(seed);
    }

    /** create a random Double array
     * @param range
     * @param size
     * @return random Double array
     */
    public static  Double[] randDoubleArray(long seed, int range, int size){
        Random random=new Random(seed);
        Double [] doubleArray=new Double[size];
        for (int i=0; i<size; i++){
            doubleArray[i]=random.nextDouble()+random.nextInt(range);
        }
        return doubleArray;
    }

    /**
     * @param range
     * @param size
     * @return
     */
    public static  Double[] randDoubleArray(int range,int size){
        long seed=System.currentTimeMillis();
        return randDoubleArray(seed, range, size);
    }

    /**
     * 生成不超过指定长度的随机字符串
     * @param seed
     * @param length
     * @param size
     * @return
     */
    public static  String[] randStringArrray(long seed, int length, int size){
        Random random=new Random();
        return null;
    }

}
