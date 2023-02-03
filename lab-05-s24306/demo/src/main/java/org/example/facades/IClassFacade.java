package main.java.org.example.facades;

import java.lang.reflect.Field;
import java.util.List;

public interface IClassFacade {

    List<IMethodFacade> getPublicDeclaredMethods();
    List<IMethodFacade> getPublicGetters();
    List<IMethodFacade> getPublicSetters();
    List<Field> getFieldsForPublicProperties();
}
