package com.ems.validator;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;



@Constraint(validatedBy = DOBConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD,ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DOBConstraint {
    String message() default "Employee should be at least 24 years old!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
