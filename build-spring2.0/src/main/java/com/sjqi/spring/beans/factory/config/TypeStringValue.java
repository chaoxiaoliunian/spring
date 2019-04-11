package com.sjqi.spring.beans.factory.config;

/**
 * @ClassName TypeStringValue
 * @Description TODO
 * @Author sjqi
 * @Date 9:58 2019/4/3
 * @Version 1.0
 **/
public class TypeStringValue {
    private String value;

    public TypeStringValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
