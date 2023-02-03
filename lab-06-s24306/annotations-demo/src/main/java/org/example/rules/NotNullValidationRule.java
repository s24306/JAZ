package main.java.org.example.rules;

import main.java.org.example.annotations.NotNull;
import main.java.org.example.interfaces.ICheckValidationRule;
import main.java.org.example.validation.ValidationResult;

import java.lang.reflect.Field;
import java.util.Collections;

public class NotNullValidationRule implements ICheckValidationRule{
    @Override
    public <T> void validate(ValidationResult<T> result){
        Class<?> clazz = result.getValidatedObject().getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                var notNull = field.getAnnotation(NotNull.class);
                field.setAccessible(true);
                try {
                    if (field.get(result.getValidatedObject()) == null) {
                        result.setValid(false);
                        if(result.getNotValidFields().containsKey(field.getName())) {
                            result.getNotValidFields().get(field.getName()).add(notNull.message());
                        } else {
                            result.getNotValidFields().put(field.getName(), Collections.singletonList(notNull.message()));
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
