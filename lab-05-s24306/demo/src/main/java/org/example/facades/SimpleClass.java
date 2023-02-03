package main.java.org.example.facades;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleClass implements IClassFacade{

    private Class<?> clazz;

    public SimpleClass(Class<?> clazz){
        this.clazz = clazz;
    }
    @Override
    public List<IMethodFacade> getPublicDeclaredMethods() {
        return Arrays.stream(this.clazz.getDeclaredMethods())
                .filter(method -> Modifier.isPublic(method.getModifiers()))
                .toList();
    }

    @Override
    public List<IMethodFacade> getPublicGetters() {
        return null;
    }

    @Override
    public List<IMethodFacade> getPublicSetters() {
        return null;
    }

    @Override
    public List<Field> getFieldsForPublicProperties() {
        return null;
    }
}
