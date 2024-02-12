package mts.coursera.MTS.Coursera.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.02.2024
 */
public class TitleCaseValidator implements ConstraintValidator<TitleCase, String> {
    private String titleLang;
    private Map<String, Pattern> patternLang = Map.of(
            "RU", Pattern.compile("^[а-яА-Я\"\',:.][а-яА-Я\"\',:.\\s]+$"),
            "EN", Pattern.compile("^[a-zA-Z\"\',:.][a-zA-Z\"\',:.\\s]+$"),
            "ANY", Pattern.compile(".+")
    );

    @Override
    public void initialize(TitleCase constraintAnnotation) {
        this.titleLang = constraintAnnotation.titleLang();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (isValidSpecial(value) || isWordMoreOneSpase(value) || isStartEndSpace(value)) {
            return false;
        }
        Pattern pattern = patternLang.get(titleLang);
        return pattern.matcher(value).matches();
    }

    /**
     * 1. Строка содержит спец. символы \r, \t, \n
     *
     * @param string String
     * @return boolean
     */
    public boolean isValidSpecial(String string) {
        Pattern pattern = Pattern.compile("[\r\t\n]");
        return pattern.matcher(string).find();
    }

    /**
     * 2. Слова в заголовках разделяются одним пробелом
     *
     * @param string String
     * @return boolean
     */
    public boolean isWordMoreOneSpase(String string) {
        Pattern pattern = Pattern.compile("\\s{2,}");
        return pattern.matcher(string).find();
    }

    /**
     * 3. Строка начинается или заканчивается пробелом
     *
     * @param string String
     * @return boolean
     */
    public boolean isStartEndSpace(String string) {
        return string.startsWith(" ") || string.endsWith(" ");
    }
}
