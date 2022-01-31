package utils.config;

import utils.ObjectFactory;
import utils.annotations.AutoInjectable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class AutoinjectConfig implements ObjectConfigurator {
    @Override
    public void configure(Object t, ObjectFactory objectFactory) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                field.setAccessible(true);

                Object object = objectFactory.createObject(field.getType());
                field.set(t, object);
            }
        }
    }
}
