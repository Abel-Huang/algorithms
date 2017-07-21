package com.main.basic.util;

/**
 * Created by huangjinajin on 2017/7/19.
 * 用于类型转换的工具,主要用于数值类型数组和其对应引用类型数组之间的转换
 */
public class Converter {
    /**
     * @param integerArray
     * @return int []
     */
    public static int [] parseIntArray(Integer [] integerArray){
        int [] intArray=new int[integerArray.length];
        for (int i=0; i<integerArray.length; i++){
            intArray[i] = integerArray[i];
        }
        return intArray;
    }

    /**
     * @param intArray
     * @return Integer []
     */
    public static Integer [] parseIntegerArray(int [] intArray){
        Integer [] integerArray=new Integer[intArray.length];
        for (int i=0; i<intArray.length; i++){
            integerArray[i] = intArray[i];
        }
        return integerArray;
    }

    /**
     * @param doubleArray
     * @return double []
     */
    public static double [] parseDbArray(Double [] doubleArray){
        double [] dbArray=new double[doubleArray.length];
        for (int i=0; i<doubleArray.length; i++){
            dbArray[i] = doubleArray[i];
        }
        return dbArray;
    }

    /**
     * @param dbArray
     * @return Double []
     */
    public static Double [] parseDoubleArray(double [] dbArray){
        Double [] doubleArray=new Double[dbArray.length];
        for (int i=0; i<dbArray.length; i++){
            doubleArray[i] = dbArray[i];
        }
        return doubleArray;
    }
}
