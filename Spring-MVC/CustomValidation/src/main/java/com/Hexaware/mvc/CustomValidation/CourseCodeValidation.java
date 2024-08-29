package com.Hexaware.mvc.CustomValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeValidation implements ConstraintValidator<CourseCode, String> {

    private String courseCodePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        courseCodePrefix = theCourseCode.value();
    }

    //theConstraintValidatorContext -> to set additional error msg, theCourseCode-> the string entered the UI by user
    @Override
    public boolean isValid(String theCourseCode, ConstraintValidatorContext theConstraintValidatorContext) {

        if (theCourseCode != null)
            return theCourseCode.startsWith(courseCodePrefix);
        else
            return true;
    }
}
