package cn.abelib.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by abel on 2018/4/30.
 *  代码已经被废弃，可以被删除
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UnUse{
    String value() default "UnUse";
}
