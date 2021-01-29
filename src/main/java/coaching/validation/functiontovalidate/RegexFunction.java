package coaching.validation.functiontovalidate;

import java.lang.reflect.Field;
import java.util.Map;

public class RegexFunction extends Function {
    @Override
    public boolean isValid(Object value, Map<String, Object> attributes) {

        String pattern = (String) attributes.get("pattern");

        if (value != null) {
            if (value instanceof String) {
                return ((String) value).matches(pattern);
            } else {
                return false;
            }
        }

        return true;
    }
}
