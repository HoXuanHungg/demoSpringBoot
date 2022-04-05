package com.example.demo_Spring.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//File Entity.java
@Retention(RetentionPolicy.RUNTIME)//exist
@Target(ElementType.TYPE)//scope
public @interface Entity {
}

//
