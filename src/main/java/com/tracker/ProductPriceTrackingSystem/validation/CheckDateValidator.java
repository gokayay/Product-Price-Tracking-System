package com.tracker.ProductPriceTrackingSystem.validation;

import com.tracker.ProductPriceTrackingSystem.dto.PriceDto;
import org.modelmapper.internal.Errors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckDateValidator implements ConstraintValidator<CheckDateCustom, String> {

    private String pattern;

    @Override
    public void initialize(CheckDateCustom constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        if ( object == null ) {
            return true;
        }

        try {
            Date date = new SimpleDateFormat(pattern).parse(object);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
