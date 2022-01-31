package utils.config;

import utils.ObjectFactory;

import java.lang.reflect.InvocationTargetException;

public interface ObjectConfigurator {
    void configure(Object t, ObjectFactory objectFactory) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
