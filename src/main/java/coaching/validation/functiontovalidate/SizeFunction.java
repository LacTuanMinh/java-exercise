package coaching.validation.functiontovalidate;

import java.lang.reflect.Field;
import java.util.Map;

public class SizeFunction extends Function {
    @Override
    public boolean isValid(Object value, Map<String, Object> attributes) {

        int min = (int) attributes.get("min");
        int max = (int) attributes.get("max");

        if (value != null) {
            if (value instanceof Integer) {
                return min <= (int) value && (int) value <= max;
            } else if (value instanceof String) {
                return min <= Integer.parseInt((String) value) && Integer.parseInt((String) value) <= max;
            }
        }
        return true;
    }
}
