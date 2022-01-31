package utils;

import utils.annotations.Configuration;
import utils.config.JavaConfig;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration(packages = {"utils"})
public class Injector {
    public static <T> T inject(Class<T> type) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        Configuration annotation = Injector.class.getAnnotation(Configuration.class);
        ObjectFactory factory = new ObjectFactory(new JavaConfig(annotation.packages()[0],new HashMap<>(Map.of(List.class, ArrayList.class))));
        T obj = factory.createObject(type);

        return obj;
    }
}
