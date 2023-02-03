package main.java.org.example.facades;

import java.lang.reflect.Method;

public interface IMethodFacade {

    boolean isPublic();
    boolean paramsCountEquals(int count);
    boolean isVoid();
    boolean startsWith(String prefix);
    boolean isSetter();
    boolean isGetter();
    String getFieldName();
    Method getUnderlyingMethod();
}
