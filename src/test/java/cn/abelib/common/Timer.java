package cn.abelib.common;

/**
 * Created by abel-huang on 2017/7/20.
 */
public class Timer {
    private double now=0;
    public Timer(){
        now=System.currentTimeMillis();
    }

    public double timeGoesBy(){
        return System.currentTimeMillis()-now;
    }
}
