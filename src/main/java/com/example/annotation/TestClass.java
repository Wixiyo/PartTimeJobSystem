package com.example.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface TestClass {
    /*描述所测试的类的作用*/
    String value()default "";
}
