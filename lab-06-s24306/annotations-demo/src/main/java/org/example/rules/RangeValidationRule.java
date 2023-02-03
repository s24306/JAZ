package main.java.org.example.rules;

import main.java.org.example.annotations.Range;
import main.java.org.example.interfaces.ICheckValidationRule;
import main.java.org.example.validation.ValidationResult;

import java.lang.reflect.Field;
import java.util.Collections;

public class RangeValidationRule implements ICheckValidationRule{
    @Override
    public <T> void validate(ValidationResult<T> result){
        Class<?> clazz = result.getValidatedObject().getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Range.class)) {
                var range = field.getAnnotation(Range.class);
                field.setAccessible(true);
                try {
                    if (field.getInt(result.getValidatedObject()) < range.min() || field.getInt(result.getValidatedObject()) > range.max()){
                        result.setValid(false);
                        if(result.getNotValidFields().containsKey(field.getName())) {
                            result.getNotValidFields().get(field.getName()).add(range.message().formatted(range.min(),range.max()));
                        } else {
                            result.getNotValidFields()
                                    .put(field.getName(), Collections.singletonList(range.message().formatted(range.min(),range.max())));
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
