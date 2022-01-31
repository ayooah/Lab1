package utils.config;

import org.reflections.Reflections;
import utils.ObjectFactory;
import utils.annotations.ValidatorInjection;
import utils.validators.ContractValidator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ValidatorInjConfig implements ObjectConfigurator {
    @Override
    public void configure(Object t, ObjectFactory objectFactory) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (Field field : t.getClass().getDeclaredFields()) {
            Reflections scanner=new Reflections("utils");
            if (field.isAnnotationPresent(ValidatorInjection.class)) {
                field.setAccessible(true);
                Set<Class< ? extends ContractValidator>> validatorsClasses=scanner.getSubTypesOf(ContractValidator.class);
                List<ContractValidator> validators=new ArrayList<>();
                validators.add(ContractValidator.class.getDeclaredConstructor().newInstance());
                for (Class< ? extends ContractValidator> el:validatorsClasses
                     ) {
                    validators.add(el.getDeclaredConstructor().newInstance());
                }
                field.set(t, validators);
            }
        }
    }
}
