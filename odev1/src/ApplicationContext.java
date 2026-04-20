import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Spring ApplicationContext mantigindan ilham alan, reflection ile nesne ureten basit bir container.
public class ApplicationContext {
    private final List<Class<?>> componentClasses;
    private final Map<Class<?>, Object> beans = new LinkedHashMap<>();

    public ApplicationContext(Class<?>... componentClasses) {
        this.componentClasses = Arrays.asList(componentClasses);

        for (Class<?> componentClass : this.componentClasses) {
            createBean(componentClass);
        }
    }

    public <T> T getBean(Class<T> type) {
        Object bean = resolveBean(type);
        return type.cast(bean);
    }

    private Object createBean(Class<?> type) {
        Object existingBean = beans.get(type);

        if (existingBean != null) {
            return existingBean;
        }

        if (!isManaged(type)) {
            throw new IllegalArgumentException("Yonetilmeyen sinif: " + type.getSimpleName());
        }

        try {
            Constructor<?> constructor = selectConstructor(type);
            Object[] dependencies = resolveDependencies(constructor.getParameterTypes());
            Object bean = constructor.newInstance(dependencies);
            beans.put(type, bean);
            return bean;
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("Bean olusturulamadi: " + type.getSimpleName(), e);
        }
    }

    private Constructor<?> selectConstructor(Class<?> type) {
        Constructor<?>[] constructors = type.getDeclaredConstructors();

        if (constructors.length == 1) {
            constructors[0].setAccessible(true);
            return constructors[0];
        }

        try {
            Constructor<?> constructor = type.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor;
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Uygun constructor bulunamadi: " + type.getSimpleName(), e);
        }
    }

    private Object[] resolveDependencies(Class<?>[] parameterTypes) {
        Object[] dependencies = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            dependencies[i] = resolveBean(parameterTypes[i]);
        }

        return dependencies;
    }

    private Object resolveBean(Class<?> type) {
        Object existingBean = beans.get(type);

        if (existingBean != null) {
            return existingBean;
        }

        if (!componentClasses.contains(type)) {
            throw new IllegalStateException("Bean bulunamadi: " + type.getSimpleName());
        }

        return createBean(type);
    }

    private boolean isManaged(Class<?> type) {
        return type.isAnnotationPresent(Component.class);
    }
}
