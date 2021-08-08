package com.ems.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DOBConstraintValidator implements ConstraintValidator<DOBConstraint, LocalDate> {

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {
        if(date==null)
            return true;

        return ChronoUnit.YEARS.between(date,LocalDate.now())>=24;
    }
}
