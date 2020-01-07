package com.tracker.ProductPriceTrackingSystem.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //Annotation will work at RUNTIME
@Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER}) //Annotation can be applied either on METHOD or on FIELD
@Constraint(validatedBy = DtoValidator.class) //class will validate the values
public @interface DtoValidation {

    String message() default "Values are not supported";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
