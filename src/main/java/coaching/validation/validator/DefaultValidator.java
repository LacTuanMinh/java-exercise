package coaching.validation.validator;

import coaching.validation.Violation;
import coaching.validation.functiontovalidate.Function;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * TODO Your implementation goes here
 */
public class DefaultValidator implements Validator {

    /**
     * {@inheritDoc}
     *
     * @param data Input data
     * @return
     */
    @Override
    public Collection<Violation> validate(Object data) throws InvocationTargetException, IllegalAccessException {

        List<Violation> violationList = new ArrayList<>();


        if (Objects.isNull(data)) {
            return violationList;
        }

        Class<?> classOfData = data.getClass();

        // check each field of class
        for (Field field : classOfData.getDeclaredFields()) {
            field.setAccessible(true);

            Annotation[] declaredAnnotations = field.getDeclaredAnnotations();

            if (declaredAnnotations.length != 0) {

                List<String> errorMessages = new ArrayList<>();

                for (Annotation annotation : declaredAnnotations) {

                    //processor    : field Field, data Object
                    Class<? extends Annotation> type = annotation.annotationType();

                    String annotationName = type.getSimpleName();

                    Method[] methods = type.getDeclaredMethods();

                    Map<String, Object> annotationAttributes = new HashMap<>();

                    for (int i = 0; i < methods.length; i++) {
                        Object attribute = methods[i].invoke(annotation, (Object[]) null);
                        annotationAttributes.put(methods[i].getName(), attribute);
                    }

                    Function validatingFunction = Function.getFunctionByName(annotationName);

                    if (validatingFunction != null) {
                        try {
                            boolean isValid = validatingFunction.isValid(field.get(data), annotationAttributes);

                            if (!isValid) {
                                errorMessages.add((String) annotationAttributes.get("message"));
                            }

                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }

                violationList.add(new Violation(data, field, errorMessages));
            }
        }
        return violationList;
    }
}
