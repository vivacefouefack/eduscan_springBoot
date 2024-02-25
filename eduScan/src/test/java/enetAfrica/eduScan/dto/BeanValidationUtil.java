package enetAfrica.eduScan.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.annotation.Annotation;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Component
public class BeanValidationUtil<T> {

    @Autowired private Validator validator;  
    
    /**
     * 
     * @param entity
     */
    public void assertIsValid(T entity) {
        assertTrue(validator.validate(entity).isEmpty());
    }

    /**
     * 
     * @param entity
     * @param invalidField
     * @param violatedConstraint
     */
    public void assertHasError(T entity, String invalidField, Class<? extends Annotation> violatedConstraint) {
        Set<ConstraintViolation<T>> violations = validator.validate(entity);
        assertEquals(1, violations.size());
        ConstraintViolation<T> violation = violations.iterator().next();
        assertEquals(invalidField, violation.getPropertyPath().toString());
        assertEquals(violatedConstraint,
        violation.getConstraintDescriptor().getAnnotation().annotationType());
    }
    
}
