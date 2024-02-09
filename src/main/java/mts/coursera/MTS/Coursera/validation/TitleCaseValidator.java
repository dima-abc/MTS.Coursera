package mts.coursera.MTS.Coursera.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.02.2024
 */
public class TitleCaseValidator implements ConstraintValidator<TitleCase, String> {
    private TitleLang TITLE_LANG;
    @Override
    public void initialize(TitleCase constraintAnnotation) {
        this.TITLE_LANG = constraintAnnotation.TITLE_LANG();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return TITLE_LANG.isValid(value);
    }
}
