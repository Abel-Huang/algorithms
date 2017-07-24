package com.main.basic.test;

/**
 * Created by huangjinajin on 2017/7/19.
 * 测试异常类，当测试不通过时，打印错误原因
 */
public class TestException extends  Exception{
    public TestException(String msg){
        super(msg);
    }
}
