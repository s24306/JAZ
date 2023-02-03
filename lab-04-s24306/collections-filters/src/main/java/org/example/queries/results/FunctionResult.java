package main.java.org.example.queries.results;

import main.java.org.example.queries.search.Funcs;

public class FunctionResult {
    private Funcs function;
    private String fieldName;
    private double value;

    public Funcs getFunction() {
        return function;
    }

    public void setFunction(Funcs function) {
        this.function = function;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
