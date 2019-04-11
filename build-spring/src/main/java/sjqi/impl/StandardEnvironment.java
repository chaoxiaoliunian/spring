package sjqi.impl;

import sjqi.interf.Environment;

/**
 * @ClassName StandardEnvironment
 * @Description 空类，目前未使用
 * @Author sjqi
 * @Date 16:59 2019/3/28
 * @Version 1.0
 **/
public class StandardEnvironment implements Environment {
    public boolean containsProperty(String key) {
        return false;
    }

    public String getProperty(String key) {
        return null;
    }

    public String getProperty(String key, String defaultValue) {
        return null;
    }

    public <T> T getProperty(String key, Class<T> targetType) {
        return null;
    }

    public <T> T getProperty(String key, Class<T> targetType, T defaultValue) {
        return null;
    }

    public String getRequiredProperty(String key) throws IllegalStateException {
        return null;
    }

    public <T> T getRequiredProperty(String key, Class<T> targetType) throws IllegalStateException {
        return null;
    }

    public String resolvePlaceholders(String text) {
        return null;
    }

    public String resolveRequiredPlaceholders(String text) throws IllegalArgumentException {
        return null;
    }

    public String[] getActiveProfiles() {
        return new String[0];
    }

    public String[] getDefaultProfiles() {
        return new String[0];
    }

    public boolean acceptsProfiles(String... profiles) {
        return false;
    }
}
