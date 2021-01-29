package coaching.validation;

import java.lang.reflect.Field;
import java.util.Collection;

/**
 * Supply information about constraint violation
 */
public class Violation {

    Object data;
    Field field;
    Collection<String> messages = null;

    public Violation(Object data, Field field, Collection<String> messages) {
        this.data = data;
        this.field = field;
        this.messages = messages;
    }

    /**
     * Invalid value of field violating the rules
     *
     * @return Invalid value
     */
    public Object getInvalidValue() {
        try {
            return field.get(data);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * List of violation messages. The reason that we return messages is because one field
     * could violate multiple rules
     *
     * @return Violation message declared in rule annotation
     */
    public Collection<String> getMessages() {
        return messages;
    }

    /**
     * Field violating the rule
     *
     * @return Field name
     */
    public String getFieldName() {
        return field.getName();
    }

    @Override
    public String toString() {
        return "Violation{" +
                "fieldName: '" + getFieldName() + "', " +
                "invalidValue: '" + getInvalidValue() + "', " +
                "messages: '" + getMessages() + "'" +
                "}";
    }
}
