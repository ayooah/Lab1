package utils;

import utils.config.AutoinjectConfig;
import utils.config.JavaConfig;
import utils.config.ObjectConfigurator;
import utils.config.ValidatorInjConfig;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ObjectFactory {
    JavaConfig config;
    private List<ObjectConfigurator> configurators = new ArrayList<>();

    public ObjectFactory(JavaConfig config) {
        this.config = config;
        configurators.add(new AutoinjectConfig());
        configurators.add(new ValidatorInjConfig());
    }

    public <T> T createObject(Class<T> type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<? extends T> implClass = type;

        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }
        T t = implClass.getDeclaredConstructor().newInstance();
        configure(t);
        return t;

    }

    private <T> void configure(T t) {
        configurators.forEach(objectConfigurator -> {
            try {
                objectConfigurator.configure(t, this);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

}
