package com.Hexaware.mvc.CustomValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//CourseCodeValidation class has the business logic to validate
@Constraint(validatedBy = CourseCodeValidation.class)
//Where can we use this annotation
@Target({ElementType.METHOD,ElementType.FIELD})
//How long this annotation is used
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    //define default value
    public String value() default "LV=";

    //define default message
    public String message() default "must starts with LV=";

    //define default groups
    public Class<?>[] groups() default {};

    //define default payload
    public Class<? extends Payload>[] payload() default {} ;
}
