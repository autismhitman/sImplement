package com.neopane.frameworkAnnotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.neopane.enums.CategoryType;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({METHOD, TYPE})
public @interface Annotations {
	
	 String[] author() default {"Raj"};
	 CategoryType[] category() default {CategoryType.SMOKE};
}
