package cn.abelib.basic.util;

/**
 * Created by huangjinajin on 2017/7/19.
 * Comparable �ӿڵĹ�����
 */
public class Comparables {

    /**
     * @param dis
     * @param src
     */
    public static void copy(Comparable [] dis, Comparable [] src){
        for (int i=0; i<src.length; i++)
            dis[i] = src[i];
    }

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

    /**
     * @param charArray
     * @return Character []
     */
    public static Character [] parseCharacterArray(char [] charArray){
        Character [] characterArray = new Character[charArray.length];
        for (int i=0; i<charArray.length; i++){
            characterArray[i] = charArray[i];
        }
        return characterArray;
    }

    /**
     * @param characterArray
     * @return char []
     */
    public static char [] paeseCharArray(char [] characterArray){
        char [] charArray = new char[characterArray.length];
        for (int i=0; i<characterArray.length; i++){
            charArray[i] = characterArray[i];
        }
        return charArray;
    }
}
