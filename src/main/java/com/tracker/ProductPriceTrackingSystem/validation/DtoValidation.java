package com.tracker.ProductPriceTrackingSystem.validation;

import javax.validation.Payload;

public @interface DtoValidation {

    String message() default "...... is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
