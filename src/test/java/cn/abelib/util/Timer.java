package cn.abelib.util;

/**
<<<<<<< HEAD
 * Created by abel-huang on 2017/7/20.
 *
=======
 * Created by huangjinajin on 2017/7/20.
 * ���ڼ�ʱ����
>>>>>>> 245eb44931ba0001767e05c615c1e630842b2ec3
 */
public class Timer {
    private double now=0;
    public Timer(){
        now=System.currentTimeMillis();
    }

    public double timeGoesBy(){
        return System.currentTimeMillis()-now;
    }

    public static void main(String []args){
        Timer timer=new Timer();
        for (long  i=0;i<100000;i++){
            StdIO.print("");
        }
        StdIO.println("Time goes by: "+ timer.timeGoesBy());
    }
}
