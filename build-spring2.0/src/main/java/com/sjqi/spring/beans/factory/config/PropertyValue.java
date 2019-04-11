package com.sjqi.spring.beans.factory.config;

/**
 * @ClassName PropertyValue
 * @Description 对应配置中的Property
 * @Author sjqi
 * @Date 9:08 2019/4/3
 * @Version 1.0
 **/
public class PropertyValue {
    private String name;
    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
