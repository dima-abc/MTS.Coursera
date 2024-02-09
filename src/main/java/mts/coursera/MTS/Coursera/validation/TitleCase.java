package mts.coursera.MTS.Coursera.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.02.2024
 */
@Constraint(validatedBy = TitleCaseValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TitleCase {
    TitleLang TITLE_LANG();

    String message() default "Title case not valid";

    Class<?>[] group() default {};

    Class<? extends Payload>[] payload() default {};

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        TitleCase[] value();
    }
}
