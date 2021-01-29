package coaching.validation.functiontovalidate;

import java.lang.reflect.Field;
import java.util.Map;

public class NotNullFunction extends Function {
    @Override
    public boolean isValid(Object value, Map<String, Object> attributes) {
        return value != null;
    }
}
