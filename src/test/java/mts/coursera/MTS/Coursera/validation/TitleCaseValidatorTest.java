package mts.coursera.MTS.Coursera.validation;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 12.02.2024
 */
class TitleCaseValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"Привет пока", "Пока,\"':.", "Как дела"})
    void isValidRuTrue(String rusString) {
        TitleCaseValidator validator = new TitleCaseValidator();
        TitleCase titleCase = mock(TitleCase.class);
        when(titleCase.titleLang()).thenReturn("RU");
        validator.initialize(titleCase);
        assertThat(validator.isValid(rusString, mock(ConstraintValidatorContext.class))).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"ПриветZ пока", " Пока,\"':.", "Как дела "})
    void isValidRuFalse(String rusString) {
        TitleCaseValidator validator = new TitleCaseValidator();
        TitleCase titleCase = mock(TitleCase.class);
        when(titleCase.titleLang()).thenReturn("EN");
        validator.initialize(titleCase);
        assertThat(validator.isValid(rusString, mock(ConstraintValidatorContext.class))).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello world", "World,\"':.", "how are you doing"})
    void isValidEnTrue(String rusString) {
        TitleCaseValidator validator = new TitleCaseValidator();
        TitleCase titleCase = mock(TitleCase.class);
        when(titleCase.titleLang()).thenReturn("EN");
        validator.initialize(titleCase);
        assertThat(validator.isValid(rusString, mock(ConstraintValidatorContext.class))).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"HelloА world", "World  ,\"':.", "how are you doing\r"})
    void isValidEnFalse(String rusString) {
        TitleCaseValidator validator = new TitleCaseValidator();
        TitleCase titleCase = mock(TitleCase.class);
        when(titleCase.titleLang()).thenReturn("EN");
        validator.initialize(titleCase);
        assertThat(validator.isValid(rusString, mock(ConstraintValidatorContext.class))).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello world. Привет мир", "World,\"':. Мир", "how are you doing. Как дела"})
    void isValidAnyTrue(String rusString) {
        TitleCaseValidator validator = new TitleCaseValidator();
        TitleCase titleCase = mock(TitleCase.class);
        when(titleCase.titleLang()).thenReturn("ANY");
        validator.initialize(titleCase);
        assertThat(validator.isValid(rusString, mock(ConstraintValidatorContext.class))).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {" Hello world. Привет мир", "World,  \"':. Мир", "how are\n you doing. Как дела"})
    void isValidAnyFalse(String rusString) {
        TitleCaseValidator validator = new TitleCaseValidator();
        TitleCase titleCase = mock(TitleCase.class);
        when(titleCase.titleLang()).thenReturn("ANY");
        validator.initialize(titleCase);
        assertThat(validator.isValid(rusString, mock(ConstraintValidatorContext.class))).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Привет\r", "Пока \t", "Как \n дела"})
    void isValidSpecialTrue(String string) {
        TitleCaseValidator validator = new TitleCaseValidator();
        assertThat(validator.isValidSpecial(string)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Привет пока", "Пока.", "Как дела"})
    void isValidSpecialFalse(String string) {
        TitleCaseValidator validator = new TitleCaseValidator();
        assertThat(validator.isValidSpecial(string)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Привет  пока", "Пока  .", "Как    дела"})
    void isWordMoreOneSpaseTrue(String string) {
        TitleCaseValidator validator = new TitleCaseValidator();
        assertThat(validator.isWordMoreOneSpase(string)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Привет пока", "Пока .", "Как дела"})
    void isWordMoreOneSpaseFalse(String string) {
        TitleCaseValidator validator = new TitleCaseValidator();
        assertThat(validator.isWordMoreOneSpase(string)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {" Привет пока", "Пока. ", " Как дела "})
    void isStartEndSpaceTrue(String string) {
        TitleCaseValidator validator = new TitleCaseValidator();
        assertThat(validator.isStartEndSpace(string)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Привет пока", "Пока.", "Как дела"})
    void isStartEndSpaceFalse(String string) {
        TitleCaseValidator validator = new TitleCaseValidator();
        assertThat(validator.isStartEndSpace(string)).isFalse();
    }

}