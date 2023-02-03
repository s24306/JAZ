package main.java.org.example.model;

import main.java.org.example.model.annotations.init;

import java.util.Arrays;

public class ClassInitiator {

    private Class<?> clazz;

    public ClassInitiator(Class<?> clazz){
        this.clazz = clazz;
    }

    public boolean haveDefaultConstructor(){
        return clazz.getDeclaredConstructors()[0].getParameterCount()==1;
    }

    public Object createObject(){
        if(haveDefaultConstructor()){
            return new ClassInitiator(clazz);
        }
        return null;
    }

    public Class<?> initiateObject(){
        var obj = createObject();
        if(obj.getClass().isAnnotationPresent(init.class)){
            var ann = obj.getClass().getAnnotation(init.class);
            .invoke(ann);
        }
    }
}
