package mts.coursera.MTS.Coursera.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.02.2024
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TitleCaseValidator.class)
public @interface TitleCase {
    String titleLang();

    String message() default "Title case not valid";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default {};
}
