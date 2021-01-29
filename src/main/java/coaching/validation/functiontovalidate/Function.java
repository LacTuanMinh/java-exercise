package coaching.validation.functiontovalidate;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public abstract class Function {

    private static Map<String, Function> availableFunctions = new HashMap<>();

    static {
        availableFunctions.put("NotNull", new NotNullFunction());
        availableFunctions.put("Size", new SizeFunction());
        availableFunctions.put("Regex", new RegexFunction());

    }

    public static Function getFunctionByName(String name) {
        if (availableFunctions.containsKey(name))
            return availableFunctions.get(name);
        return null;
    }

    public abstract boolean isValid(Object value, Map<String, Object> attributes);

}
