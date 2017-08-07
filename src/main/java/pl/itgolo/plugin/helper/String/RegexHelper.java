package pl.itgolo.plugin.helper.String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ITGolo on 04.03.2017.
 */
public class RegexHelper {

    /**
     * Find pattern in text
     * @param text text
     * @param pattern pattern
     * @param group group of matcher
     * @return first find pattern in text
     */
    public static String findFirst(String text, String pattern, Integer group){
        String result = null;
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        while (matcher.find()){
            result = matcher.group(group);
            break;
        }
        return result;
    }
}
