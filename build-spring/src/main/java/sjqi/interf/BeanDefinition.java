package sjqi.interf;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @ClassName BeanDefinition
 * @Description TODO
 * @Author sjqi
 * @Date 16:25 2019/3/28
 * @Version 1.0
 **/
public class BeanDefinition {
    public static final String SCOPE_DEFAULT = "";

    public static final int DEPENDENCY_CHECK_NONE = 0;

    public static final int DEPENDENCY_CHECK_OBJECTS = 1;

    public static final int DEPENDENCY_CHECK_SIMPLE = 2;

    public static final int DEPENDENCY_CHECK_ALL = 3;


    public static final String INFER_METHOD = "(inferred)";


    private volatile Object beanClass;
    private String beanName;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    private String scope = SCOPE_DEFAULT;

    private boolean abstractFlag = false;

    private boolean lazyInit = false;

    private int dependencyCheck = DEPENDENCY_CHECK_NONE;

    private String[] dependsOn;

    private boolean autowireCandidate = true;

    private boolean primary = false;


    private Supplier<?> instanceSupplier;

    private boolean nonPublicAccessAllowed = true;

    private boolean lenientConstructorResolution = true;



    private String initMethodName;

    private String destroyMethodName;

    private boolean enforceInitMethod = true;

    private boolean enforceDestroyMethod = true;

    private boolean synthetic = false;


    private String description;

    private Resource resource;

    public static String getScopeDefault() {
        return SCOPE_DEFAULT;
    }

    public static int getDependencyCheckNone() {
        return DEPENDENCY_CHECK_NONE;
    }

    public static int getDependencyCheckObjects() {
        return DEPENDENCY_CHECK_OBJECTS;
    }

    public static int getDependencyCheckSimple() {
        return DEPENDENCY_CHECK_SIMPLE;
    }

    public static int getDependencyCheckAll() {
        return DEPENDENCY_CHECK_ALL;
    }

    public static String getInferMethod() {
        return INFER_METHOD;
    }

    public Object getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Object beanClass) {
        this.beanClass = beanClass;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isAbstractFlag() {
        return abstractFlag;
    }

    public void setAbstractFlag(boolean abstractFlag) {
        this.abstractFlag = abstractFlag;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public int getDependencyCheck() {
        return dependencyCheck;
    }

    public void setDependencyCheck(int dependencyCheck) {
        this.dependencyCheck = dependencyCheck;
    }

    public String[] getDependsOn() {
        return dependsOn;
    }

    public void setDependsOn(String[] dependsOn) {
        this.dependsOn = dependsOn;
    }

    public boolean isAutowireCandidate() {
        return autowireCandidate;
    }

    public void setAutowireCandidate(boolean autowireCandidate) {
        this.autowireCandidate = autowireCandidate;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public Supplier<?> getInstanceSupplier() {
        return instanceSupplier;
    }

    public void setInstanceSupplier(Supplier<?> instanceSupplier) {
        this.instanceSupplier = instanceSupplier;
    }

    public boolean isNonPublicAccessAllowed() {
        return nonPublicAccessAllowed;
    }

    public void setNonPublicAccessAllowed(boolean nonPublicAccessAllowed) {
        this.nonPublicAccessAllowed = nonPublicAccessAllowed;
    }

    public boolean isLenientConstructorResolution() {
        return lenientConstructorResolution;
    }

    public void setLenientConstructorResolution(boolean lenientConstructorResolution) {
        this.lenientConstructorResolution = lenientConstructorResolution;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }

    public boolean isEnforceInitMethod() {
        return enforceInitMethod;
    }

    public void setEnforceInitMethod(boolean enforceInitMethod) {
        this.enforceInitMethod = enforceInitMethod;
    }

    public boolean isEnforceDestroyMethod() {
        return enforceDestroyMethod;
    }

    public void setEnforceDestroyMethod(boolean enforceDestroyMethod) {
        this.enforceDestroyMethod = enforceDestroyMethod;
    }

    public boolean isSynthetic() {
        return synthetic;
    }

    public void setSynthetic(boolean synthetic) {
        this.synthetic = synthetic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
