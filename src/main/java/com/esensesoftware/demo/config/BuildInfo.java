package com.esensesoftware.demo.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BuildInfo {

    String build() default "";
    String author() default "";
    String story() default "";
    String comment() default "";

}//BuildInfo