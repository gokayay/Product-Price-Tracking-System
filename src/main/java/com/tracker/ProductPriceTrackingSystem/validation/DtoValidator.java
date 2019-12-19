package com.tracker.ProductPriceTrackingSystem.validation;

import com.tracker.ProductPriceTrackingSystem.dto.PriceDto;
import com.tracker.ProductPriceTrackingSystem.model.Price;
import org.modelmapper.internal.Errors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DtoValidator implements ConstraintValidator<DtoValidation, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }

    //@Override (should be)
    public void validatePrice(Object target, Errors errors) {
        PriceDto price = (PriceDto) target;
        if (price.getPrice().isInfinite()) {
            errors.addMessage("price", null, "Price can not be null");
        }
    }
}
