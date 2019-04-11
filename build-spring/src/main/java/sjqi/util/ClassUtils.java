package sjqi.util;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ClassUtils
 * @Description TODO
 * @Author sjqi
 * @Date 15:44 2019/3/28
 * @Version 1.0
 **/
public abstract class ClassUtils {
    /** The package separator character: '.' */
    private static final char PACKAGE_SEPARATOR = '.';

    /** The path separator character: '/' */
    private static final char PATH_SEPARATOR = '/';
    private static final Map<String, Class<?>> primitiveTypeNameMap = new HashMap(32);
    private static final Map<String, Class<?>> commonClassCache = new HashMap(32);


    public static Class<?> resolvePrimitiveClassName(String name) {
        Class<?> result = null;
        if (name != null && name.length() <= 8) {
            result = (Class)primitiveTypeNameMap.get(name);
        }

        return result;
    }
    /**
     * 用BeanDefinition 创建对象
     * @param name
     * @param classLoader
     * @return
     * @throws ClassNotFoundException
     * @throws LinkageError
     */
    public static Class<?> forName(String name, ClassLoader classLoader) throws ClassNotFoundException, LinkageError {
        Class<?> clazz = resolvePrimitiveClassName(name);
        if (clazz == null) {
            clazz = (Class)commonClassCache.get(name);
        }

        if (clazz != null) {
            return clazz;
        } else {
            Class elementClass;
            String elementName;
            if (name.endsWith("[]")) {
                elementName = name.substring(0, name.length() - "[]".length());
                elementClass = forName(elementName, classLoader);
                return Array.newInstance(elementClass, 0).getClass();
            } else if (name.startsWith("[L") && name.endsWith(";")) {
                elementName = name.substring("[L".length(), name.length() - 1);
                elementClass = forName(elementName, classLoader);
                return Array.newInstance(elementClass, 0).getClass();
            } else if (name.startsWith("[")) {
                elementName = name.substring("[".length());
                elementClass = forName(elementName, classLoader);
                return Array.newInstance(elementClass, 0).getClass();
            } else {
                ClassLoader clToUse = classLoader;
                if (classLoader == null) {
                    clToUse = getDefaultClassLoader();
                }

                try {
                    return clToUse != null ? clToUse.loadClass(name) : Class.forName(name);
                } catch (ClassNotFoundException var9) {
                    int lastDotIndex = name.lastIndexOf(46);
                    if (lastDotIndex != -1) {
                        String innerClassName = name.substring(0, lastDotIndex) + '$' + name.substring(lastDotIndex + 1);

                        try {
                            return clToUse != null ? clToUse.loadClass(innerClassName) : Class.forName(innerClassName);
                        } catch (ClassNotFoundException var8) {
                            ;
                        }
                    }

                    throw var9;
                }
            }
        }
    }
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;

        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable var3) {
            ;
        }

        if (cl == null) {
            cl = ClassUtils.class.getClassLoader();
            if (cl == null) {
                try {
                    cl = ClassLoader.getSystemClassLoader();
                } catch (Throwable var2) {
                    ;
                }
            }
        }

        return cl;
    }
    public static String classPackageAsResourcePath( Class<?> clazz) {
        if (clazz == null) {
            return "";
        }
        String className = clazz.getName();
        int packageEndIndex = className.lastIndexOf(PACKAGE_SEPARATOR);
        if (packageEndIndex == -1) {
            return "";
        }
        String packageName = className.substring(0, packageEndIndex);
        return packageName.replace(PACKAGE_SEPARATOR, PATH_SEPARATOR);
    }
}
