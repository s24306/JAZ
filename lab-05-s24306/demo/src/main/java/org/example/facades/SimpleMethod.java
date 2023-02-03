package main.java.org.example.facades;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Objects;
import java.util.function.Predicate;

public class SimpleMethod implements IMethodFacade{

    private Method method;

    public SimpleMethod(Method method){
        this.method = method;
    }

    @Override
    public boolean isPublic() {
        return Objects.equals(Modifier.toString(this.method.getModifiers()), "public");
    }

    @Override
    public boolean paramsCountEquals(int count) {
        return this.method.getParameterCount() == count;
    }

    @Override
    public boolean isVoid() {
        return Void.TYPE.equals(this.method.getReturnType());
    }

    @Override
    public boolean startsWith(String prefix) {
        return this.method.getName().startsWith(prefix);
    }

    @Override
    public boolean isSetter() {
        return isPublic() && isVoid() && startsWith("set") && paramsCountEquals(1);
    }

    @Override
    public boolean isGetter() {
        return isPublic() && !isVoid() && (startsWith("get") || startsWith("is")) && paramsCountEquals(0);
    }

    @Override
    public String getFieldName() {
        return this.method.getName().substring(3).toLowerCase();
    }

    @Override
    public Method getUnderlyingMethod() {
        return this.method;
    }
}
