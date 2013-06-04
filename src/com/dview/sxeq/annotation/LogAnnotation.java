package com.dview.sxeq.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {

	String value() default "no content";
}
