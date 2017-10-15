package cn.abelib.test.basic.util;

import cn.abelib.basic.util.RandomData;
import cn.abelib.basic.util.StdIO;

/**
 * Created by huangjianjin on 2017/7/22.
 */
public class TestRandArray {
    public static void main(String [] args){
//        Double[] i= RandomData.randDoubleArray(10, 10, 20);
//        StdIO.print(i);
//        StdIO.print(RandomData.randDoubleArray(10, 10));
//        StdIO.print(RandomData.randIntegerArray(10, 10));
          StdIO.print(RandomData.randStrArray(5, 5, 10));
          StdIO.print(RandomData.randCharArray(10));
    }
}
