package mts.coursera.MTS.Coursera.validation;

import java.util.regex.Pattern;

/**
 * Возможные значения дял проверки
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.02.2024
 */
public enum TitleLang {
    RU {
        @Override
        boolean isValid(String title) {
            if (isValidSpecial(title) || isWordMoreOneSpase(title) || isStartEndSpace(title)) {
                return false;
            }
            return title.isBlank();
        }
    }, EN {
        @Override
        boolean isValid(String title) {
            return title.isBlank();
        }
    }, ANY {
        @Override
        boolean isValid(String title) {
            return title.isBlank();
        }
    };

    abstract boolean isValid(String title);

    /**
     * 1. Строка содержит спец. символы \r, \t, \n
     *
     * @param title String
     * @return boolean
     */
    boolean isValidSpecial(String title) {
        Pattern pattern = Pattern.compile("[\r\t\n]");
        return pattern.matcher(title).find();
    }

    /**
     * 2. Слова в заголовках разделяются одним пробелом
     *
     * @param title String
     * @return boolean
     */
    boolean isWordMoreOneSpase(String title) {
        Pattern pattern = Pattern.compile("\\s{2,}");
        return pattern.matcher(title).find();
    }

    /**
     * 3. Строка начинается или заканчивается пробелом
     *
     * @param title String
     * @return boolean
     */
    boolean isStartEndSpace(String title) {
        return title.startsWith(" ") || title.endsWith(" ");
    }
}
