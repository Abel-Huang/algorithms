package cn.abelib.other.noname;

import java.lang.reflect.Method;

/**
 * Created by huangjianjin on 2017/7/22.
 */
public class User
{
    public void use(Method method)
    {
        TestTest tool = new TestTest();
        try {
            method.invoke(tool, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Controller control = new Controller();
        control.invoke(0);
    }
}