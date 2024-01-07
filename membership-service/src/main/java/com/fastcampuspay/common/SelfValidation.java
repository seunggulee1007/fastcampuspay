package com.fastcampuspay.common;

import jakarta.validation.*;

import java.util.Set;

public abstract class SelfValidation<T> {

    private final Validator validator;

    protected SelfValidation() {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
        }
    }

    protected void validateSelf() {
        Set<ConstraintViolation<T>> violations = validator.validate((T)this);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

}
